function createRowDetails(dto) {
    var row = document.createElement("tr");
    var tdID = document.createElement("td");
    var tdName = document.createElement("td");
    var tdCatName = document.createElement("td");
    var tdBrand = document.createElement("td");
    var tdDes = document.createElement("td");
    var tdPrice = document.createElement("td");
    var tdStartSellingDate = document.createElement("td");
    var tdImage = document.createElement("td");
    var tdQuantity = document.createElement("td");
    var tdSale = document.createElement("td");
    var imgSrc = document.createElement("img");
    tdID.innerHTML = dto.accId;
    tdName.innerHTML = dto.accName;
    tdCatName.innerHTML = dto.accCatId;
    tdBrand.innerHTML = dto.brand;
    tdDes.innerHTML = dto.description;
    var n = parseFloat(dto.price);
    var priceValue = Math.round(n * 100) / 100;
    var m = parseFloat(dto.salePercent);
    var saleValue = Math.round(m * 100) / 100;
    tdPrice.innerHTML = "$" + priceValue;
    tdSale.innerHTML = saleValue;
    var myDate = new Date(dto.startSellingDate);
    var month = myDate.getMonth() + 1;
    var day = myDate.getDate();
    var year = myDate.getFullYear();
    var date = day + "/" + month + "/" + year;
    tdStartSellingDate.innerHTML = date;
    if (dto.image === null) {
        imgSrc.src = "../img/product/noimage.jpg";
    } else {
        imgSrc.src = "../img/product/" + dto.image;
    }
    imgSrc.onerror = function () {
        this.onerror = null;
        this.src = '../img/product/noimage.jpg';
    };
    imgSrc.alt = "Image not found";
    imgSrc.style = "max-width: none; width: 175px; height: auto";
    tdImage.appendChild(imgSrc);
    tdQuantity.innerHTML = dto.quantity;
    row.appendChild(tdID);
    row.appendChild(tdName);
    row.appendChild(tdCatName);
    row.appendChild(tdBrand);
    row.appendChild(tdDes);
    row.appendChild(tdPrice);
    row.appendChild(tdStartSellingDate);
    row.appendChild(tdImage);
    row.appendChild(tdSale);
    row.appendChild(tdQuantity);
    return row;
}

function createRow(dto) {
    var row = document.createElement("tr");
    var tdID = document.createElement("td");
    var tdUsername = document.createElement("td");
    var tdtimeOrder = document.createElement("td");
    var tdtimeFinish = document.createElement("td");
    var tdDeliveryPhone = document.createElement("td");
    var tdDeliveryAddress = document.createElement("td");
    var tdPrice = document.createElement("td");
    var tdView = document.createElement("td");
    var tdStatus = document.createElement("td");
    tdID.innerHTML = dto.accTranId;
    tdUsername.innerHTML = dto.username;
    var myDate = new Date(dto.timeOrder);
    var month = myDate.getMonth() + 1;
    var day = myDate.getDate();
    var year = myDate.getFullYear();
    var hour = myDate.getHours();
    var min = myDate.getMinutes();
    var mili = myDate.getMilliseconds();
    var date = day + "/" + month + "/" + year + " " + hour + ":" + min + ":" + mili;
    tdtimeOrder.innerHTML = date;
    if (dto.timeFinish !== null) {
        var myDate1 = new Date(dto.timeFinish);
        var month1 = myDate1.getMonth() + 1;
        var day1 = myDate1.getDate();
        var year1 = myDate1.getFullYear();
        var hour1 = myDate1.getHours();
        var min1 = myDate1.getMinutes();
        var mili1 = myDate1.getMilliseconds();
        var date1 = day1.toString().padStart(2, 0) + "/"
            + month1.toString().padStart(2, 0) + "/" + year1.toString().padStart(4, 0)
            + " " + hour1.toString().padStart(2, 0) + ":" + min1.toString().padStart(2, 0)
            + ":" + mili1.toString().padStart(2, 0);
        tdtimeFinish.innerHTML = date1;
    } else {
        tdtimeFinish.innerHTML = "Unknown";
    }
    tdDeliveryPhone.innerHTML = dto.deliveryPhone;
    tdDeliveryAddress.innerHTML = dto.deliveryAddress;
    var n = parseFloat(dto.totalPrice);
    var priceValue = Math.round(n * 100) / 100;
    tdPrice.innerHTML = "$" + priceValue;
    //    View transaction
    var viewLink = document.createElement("a");
    viewLink.setAttribute("data-toggle", "modal");
    viewLink.setAttribute("data-target", "#modalAccTransForm");
    viewLink.style = "cursor: pointer";
    viewLink.href = 'javascript: void(0)';
    viewLink.addEventListener("click", function () {
        viewDetails(dto.accTranId);
    });
    viewLink.innerHTML = "View details";
    tdView.appendChild(viewLink);
    //Status
    var cb = document.createElement("select");
    var opt1 = document.createElement("option");
    var opt2 = document.createElement("option");
    var opt3 = document.createElement("option");
    var opt4 = document.createElement("option");
    cb.classList.add("form-control");
    opt1.value = "Waiting for response";
    opt1.innerHTML = "Waiting for response";
    opt2.value = "Waiting for payment";
    opt2.innerHTML = "Waiting for payment";
    opt3.value = "Finished";
    opt3.innerHTML = "Finished";
    opt4.value = "Canceled";
    opt4.innerHTML = "Canceled";
    if (dto.status === "Waiting for response") {
        cb.appendChild(opt1);
        cb.appendChild(opt2);
        cb.appendChild(opt3);
        cb.appendChild(opt4);
        opt1.selected = "selected";
    } else if (dto.status === "Waiting for payment") {
        cb.appendChild(opt2);
        cb.appendChild(opt3);
        cb.appendChild(opt4);
        opt2.selected = "selected";
    } else if (dto.status === "Finished") {
        cb.appendChild(opt3);
        opt3.selected = "selected";
        cb.disabled = "true";
    } else {
        cb.appendChild(opt4);
        opt4.selected = "selected";
        cb.disabled = "true";
    }
    cb.onchange = function () {
        updateTran(this.value, dto.accTranId);
        if (this.value === "Canceled") {
            restoreStorage(dto.accTranId);
        }
    };
    tdStatus.appendChild(cb);
    row.appendChild(tdID);
    row.appendChild(tdUsername);
    row.appendChild(tdtimeOrder);
    row.appendChild(tdtimeFinish);
    row.appendChild(tdDeliveryPhone);
    row.appendChild(tdDeliveryAddress);
    row.appendChild(tdPrice);
    row.appendChild(tdView);
    row.appendChild(tdStatus);
    return row;
}
function searchTran() {
    let obj = {
        UsernameSearch: $('#usernameSearch').val(),
        StatusSearch: $('#statusSearch').val(),
    }
    $.ajax({
        type: "POST",
        url: "/Transaction/FindAll",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            if (data !== null) {
                if (data !== null && data.length !== 0) {
                    $('#tbodyTranSearch').empty();
                    $('#accTranSearch-not-found').css("display", "none");
                    $('#accTranTable').css("display", "table");
                    $.each(data, function () {
                        var row = createRow(this);
                        $('#tbodyTranSearch').append(row);
                    });
                } else {
                    $('#accTranSearch-not-found').css("display", "block");
                    $('#accTranTable').css("display", "none");
                }
            } else {
                $('#accTranSearch-not-found').css("display", "block");
                $('#accTranTable').css("display", "none");
            }
        },
        error: function () {
            alert("/Transaction/FindAll error");
        }
    });
}
function updateTran(status, accTranID) {
    let obj = {
        AccTranID: accTranID,
        Status: status
    }
    $.ajax({
        type: "POST",
        url: "/Transaction/UpdateTran",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            alert(data);
            searchTran();
        },
        error: function () {
            alert("Update transaction failed.");
        }
    });
}

function viewDetails(accTranID) {
    $.ajax({
        type: "POST",
        url: "/Transaction/ViewDetail",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(accTranID),
        success: function (data) {
            if (data !== null) {
                if (data !== null && data.length !== 0) {
                    $('#tbodyAccTranSearch').empty();
                    $('#acc-not-found').css("display", "none");
                    $('#accTable').css("display", "table");
                    $.each(data, function () {
                        var row = createRowDetails(this);
                        $('#tbodyAccTranSearch').append(row);
                    });
                } else {
                    $('#acc-not-found').css("display", "block");
                    $('#accTable').css("display", "none");
                }
            } else {
                $('#acc-not-found').css("display", "block");
                $('#accTable').css("display", "none");
            }
        },
        error: function () {
            alert("/Transaction/ViewDetail error");
        }
    });
}
function restoreStorage(accTranID) {
    $.ajax({
        type: "POST",
        url: "/Transaction/RestoreStorage",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(accTranID),
        success: function (data) {
            alert(data);
            searchTran();
        },
        error: function () {
            alert("/Transaction/RestoreStorage error");
        }
    });
}
function closeModal() {
    $('#modalAccTransForm').hide();
}
$(function () {
    $('#form-acc-trans-search').submit(function (e) {
        e.preventDefault();
    });
    searchTran();
});


