function loadCbAccCategory(id) {
    $.ajax({
        type: "POST",
        url: "/AccessoryCategory/LoadAllAccessoryCategory",
        async: false,
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            $('#' + id).empty();
            $.each(data, function () {
                var opt = document.createElement("option");
                opt.value = this.accCatId;
                opt.innerHTML = this.accCatName;
                $('#' + id).append(opt);
            });
        },
        error: function () {
            alert("/Accessory/LoadAllAccessoryCategory error");
        }
    });
}
;
//Accessory
function generateAccID() {
    var id = "A";
    const possible = "0123456789";
    do {
        for (let i = 0; i < 4; i++) {
            id += possible.charAt(Math.floor(Math.random() * possible.length));
        }
    } while (checkAccIDExisted(id));
    $('#accIDIns').val(id);
}
function checkAccIDExisted(id) {
    $.ajax({
        type: "POST",
        url: "/Accessory/CheckAccIDExisted",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(id),
        success: function (data) {
            if (data === true) {
                return true;
            } else {
                return false;
            }
        },
        error: function () {
            alert("Some error occured at checkAccIDExisted.");
        }
    });
}
function insertAcc() {
    var obj = {
        AccId: $('#accIDIns').val(),
        AccName: $('#accNameIns').val(),
        AccCatId: $('#accCatIDIns').val(),
        Description: $('#desIns').val(),
        Brand: $('#brandIns').val(),
        Price: $('#priceIns').val(),
        Image: $('#imageIns').val(),
        SalePercent: $('#salePercentIns').val(),
        StartSellingDate: $('#startSellingDateIns').val(),
        AvailableQuantity: $('#availableQuantityIns').val(),
    }
    $.ajax({
        type: "POST",
        url: "/Accessory/InsertAcc",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            if (data) {
                alert("Insert accessory success");
            } else {
                alert("Insert accessory failed22.");
            }
            $('#accNameIns').val('');
            $('#brandIns').val('');
            $('#desIns').val('');
            $('#priceIns').val('');
            $('#startSellingDateIns').val('');
            $('#availableQuantityIns').val('');
            $('#salePercentIns').val('');
            $('#imageIns').val('');
            generateAccID();
            searchAccByLikeName();
        },
        error: function () {
            alert("Insert accessory failed.");
        }
    });
}
function loadAcc(accID, accName, accCatID, brand, description, price, salePercent, startSellingDate, imageName, availableQuantity, isDelete) {
    $('#accIDUpdt').val(accID);
    $('#accNameUpdt').val(accName);
    $('#accCatIDUpdt').val(accCatID);
    $('#brandUpdt').val(brand);
    $('#desUpdt').val(description);
    $('#priceUpdt').val(price);
    $('#availableQuantityUpdt').val(availableQuantity);
    $('#salePercentUpdt').val(salePercent);
    $('#isDeleteUpdt').val(isDelete);
    $('#startSellingDateUpdt').val(startSellingDate);
    $('#imageUpdt').val(imageName);
}
function searchAccByLikeName() {
    var obj = {
        AccNameSearch: $('#accSearch').val(),
        IsDeleteSearch: $('#isDeleteSearch').val()
    }
    $.ajax({
        type: "POST",
        url: "/Accessory/FindAccByLikeName",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            if (data !== null) {
                if (data !== null && data.length !== 0) {
                    $('#tbodyaccSearch').empty();
                    $('#accSearch-not-found').css("display", "none");
                    $('#accTable').css("display", "table");
                    $.each(data, function () {
                        var row = document.createElement("tr");
                        var tdID = document.createElement("td");
                        var tdName = document.createElement("td");
                        var tdCatName = document.createElement("td");
                        var tdBrand = document.createElement("td");
                        var tdDes = document.createElement("td");
                        var tdPrice = document.createElement("td");
                        var tdStartSellingDate = document.createElement("td");
                        var tdImage = document.createElement("td");
                        var tdAvailableQuantity = document.createElement("td");
                        var tdSale = document.createElement("td");
                        var tdisDelete = document.createElement("td");
                        var tdEdit = document.createElement("td");
                        var imgSrc = document.createElement("img");
                        var editLink = document.createElement("a");
                        tdID.innerHTML = this.accId;
                        tdName.innerHTML = this.accName;
                        tdCatName.innerHTML = this.accCatName;
                        tdBrand.innerHTML = this.brand;
                        tdDes.innerHTML = this.description;
                        var n = parseFloat(this.price);
                        var priceValue = Math.round(n * 100) / 100;
                        var m = parseFloat(this.salePercent);
                        var saleValue = Math.round(m * 100) / 100;
                        tdPrice.innerHTML = "$" + priceValue;
                        tdSale.innerHTML = saleValue;
                        var myDate = new Date(this.startSellingDate);
                        var month = myDate.getMonth() + 1;
                        var day = myDate.getDate();
                        var year = myDate.getFullYear();
                        var date = day + "/" + month + "/" + year;
                        var date2 = year.toString() + "-" + month.toString().padStart(2, 0) + "-" + day.toString().padStart(2, 0);
                        tdStartSellingDate.innerHTML = date;
                        var imageName = "";
                        if (this.image === null) {
                            imgSrc.src = "../img/product/noimage.jpg";
                        } else {
                            imgSrc.src = "../img/product/" + this.image;
                            imageName = this.image;
                        }
                        imgSrc.onerror = function () {
                            this.onerror = null;
                            this.src = '../img/product/noimage.jpg';
                        };
                        imgSrc.alt = "Image not found";
                        imgSrc.style = "max-width: none; width: 175px; height: auto";
                        tdImage.appendChild(imgSrc);
                        tdAvailableQuantity.innerHTML = this.availableQuantity;
                        tdisDelete.innerHTML = this.isDelete;
                        editLink.setAttribute("data-toggle", "modal");
                        editLink.href = 'javascript: void (0)';
                        editLink.setAttribute("data-target", "#modalUpdtAccForm");
                        editLink.style = "cursor: pointer";
                        var catID = this.accCatId;
                        editLink.addEventListener("click", function () {
                            loadCbAccCategory("accCatIDUpdt");
                            loadAcc(tdID.innerHTML, tdName.innerHTML, catID, tdBrand.innerHTML, tdDes.innerHTML, priceValue, saleValue, date2, imageName, tdAvailableQuantity.innerHTML, tdisDelete.innerHTML);
                        });
                        editLink.innerHTML = "Edit";
                        tdEdit.appendChild(editLink);
                        row.appendChild(tdID);
                        row.appendChild(tdName);
                        row.appendChild(tdCatName);
                        row.appendChild(tdBrand);
                        row.appendChild(tdDes);
                        row.appendChild(tdPrice);
                        row.appendChild(tdStartSellingDate);
                        row.appendChild(tdImage);
                        row.appendChild(tdAvailableQuantity);
                        row.appendChild(tdSale);
                        row.appendChild(tdisDelete);
                        row.appendChild(tdEdit);
                        $('#tbodyaccSearch').append(row);
                    });
                } else {
                    $('#accSearch-not-found').css("display", "block");
                    $('#accTable').css("display", "none");
                }
            } else {
                $('#accSearch-not-found').css("display", "block");
                $('#accTable').css("display", "none");
            }
        },
        error: function () {
            alert("Accessory/FindByLikeName error");
        }
    });
}
function updateAcc() {
    let obj = {
        AccId: $('#accIDUpdt').val(),
        AccName: $('#accNameUpdt').val(),
        AccCatId: $('#accCatIDUpdt').val(),
        Description: $('#desUpdt').val(),
        Brand: $('#brandUpdt').val(),
        Price: $('#priceUpdt').val(),
        Image: $('#imageUpdt').val(),
        SalePercent: $('#salePercentUpdt').val(),
        StartSellingDate: $('#startSellingDateUpdt').val(),
        AvailableQuantity: $('#availableQuantityUpdt').val(),
        IsDelete: $('#isDeleteUpdt').val()
    }
    $.ajax({
        type: "POST",
        url: "/Accessory/UpdateAcc",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function () {
            alert("Update accessory success");
            searchAccByLikeName();
        },
        error: function () {
            alert("Update accessory failed.");
        }
    });
}
$(function () {
    $('#form-acc-search').submit(function (e) {
        e.preventDefault();
    });
    searchAccByLikeName();
    $('#form-acc-ins').validate({
        rules: {
            accNameIns: {
                required: true
            },
            brandIns: {
                required: true
            },
            desIns: {
                required: true
            },
            priceIns: {
                required: true
            },
            startSellingDateIns: {
                required: true
            },
            availableQuantityIns: {
                required: true
            },
            salePercentIns: {
                required: true
            }
        },
        messages: {
            accNameIns: {
                required: "Accessory name cannot be epmty.",
                pattern: "Accessory name must be 1-40 characters."
            },
            brandIns: {
                required: "Brand cannot be empty.",
                pattern: "Brand must be 1-40 characters."
            },
            desIns: {
                required: "Description cannot be empty.",
                pattern: "Description must be 1-500 characters."
            },
            priceIns: {
                required: "Price cannot be empty.",
                maxlength: "Price maximum length is 13 digits."
            },
            startSellingDateIns: {
                required: "Date cannot be empty. Please enter a valid date.",
            },
            imageIns: {
                pattern: "Only accept images with extensions .jpg."
            },
            availableQuantityIns: {
                required: "Quantity cannot be empty.",
                min: "Quantity is a positive integer.",
                maxlength: "Quantity maximum length is 13 digits.",
                step: "Quantity is a positive integer."
            },
            salePercentIns: {
                required: "Sale percent cannot be empty.",
                min: "Enter a number between 0-1.",
                max: "Enter a number between 0-1."
            }
        },
        submitHandler: function () {
            insertAcc();
        }
    });
    $('#form-acc-updt').validate({
        rules: {
            accNameUpdt: {
                required: true
            },
            brandUpdt: {
                required: true
            },
            desUpdt: {
                required: true
            },
            priceUpdt: {
                required: true
            },
            startSellingDateUpdt: {
                required: true
            },
            availableQuantityUpdt: {
                required: true
            },
            salePercentUpdt: {
                required: true
            }
        },
        messages: {
            accNameUpdt: {
                required: "Accessory name cannot be epmty.",
                pattern: "Accessory name must be 1-40 characters."
            },
            brandUpdt: {
                required: "Brand cannot be empty.",
                pattern: "Brand must be 1-40 characters."
            },
            desUpdt: {
                required: "Description cannot be empty.",
                pattern: "Description must be 1-500 characters."
            },
            priceUpdt: {
                required: "Price cannot be empty.",
                maxlength: "Price maximum length is 13 digits."
            },
            startSellingDateUpdt: {
                required: "Date cannot be empty. Please enter a valid date."
            },
            imageUpdt: {
                pattern: "Only accept images with extensions .jpg."
            },
            availableQuantityUpdt: {
                required: "Quantity cannot be empty.",
                min: "Quantity is a positive integer.",
                maxlength: "Quantity maximum length is 13 digits.",
                step: "Quantity is a positive integer."
            },
            salePercentUpdt: {
                required: "Sale percent cannot be empty.",
                min: "Enter a number between 0-1.",
                max: "Enter a number between 0-1."
            }
        },
        submitHandler: function () {
            updateAcc();
        }
    });
});


