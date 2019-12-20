function addCart(accID, availableQuantity) {
    if (roleValue === "user") {
        var quantity = $('#inputQuantity').val();
        if (quantity > 0 && quantity <= Number.parseInt(availableQuantity)) {
            let obj = {
                AccId: accID,
                Quantity: quantity.toString(),
            }
            $.ajax({
                type: "POST",
                url: "/ShoppingCart/AddCartDetail",
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(obj),
                success: function (data) {
                    if (data.msg === "Available quantity is not enough to buy.") {
                        showMessage(data.msg);
                    } else {
                        showMessage(data.msg);
                        $('#cartCount').html(data.count);
                    }
                },
                error: function () {
                    alert("/ShoppingCart/AddCartDetail error");
                }
            });
        } else {
            alert("Please input valid quantity");
        }
    } else if (roleValue === "admin") {
        alert("Your role ADMIN is not authorized");
    } else {
        $('#modalLRForm').modal('show');
    }
}
function getRelatedAccessory(accCatIDSearch, accID) {
    var obj = {
        AccId: accID,
        AccCatId: accCatIDSearch
    }
    $.ajax({
        type: "POST",
        url: "/Accessory/GetRelatedAccessories",
        dataType: 'json',
        contentType: 'application/json charset=utf-8',
        data: JSON.stringify(obj),
        success: function (data) {
            loadRelatedList(data);
        },
        error: function () {
            alert("/Accessory/GetRelatedAccessories error.");
        }
    });
}
function loadRelatedList(data) {
    if (roleValue === "user") {
        if (data !== null) {
            $.each(data, function () {
                var imageName = "";
                if (this.image !== null) {
                    imageName = this.image;
                }
                var row;
                if (checkFavoriteExisted(this.accId)) {
                    row = createProductItem(imageName, this.price, this.accName, this.salePercent, this.accId, true);
                } else {
                    row = createProductItem(imageName, this.price, this.accName, this.salePercent, this.accId, false);
                }
                var container = document.createElement("div");
                container.classList.add("col-lg-3");
                container.appendChild(row);
                $('#related-acc').append(container);
            });
        } else {
            $('#related-acc').html("No ralated accessories.");
        }
    } else {
        if (data !== null) {
            $.each(data, function () {
                var imageName = "";
                if (this.image !== null) {
                    imageName = this.image;
                }
                var row = createProductItem(imageName, this.price, this.accName, this.salePercent, this.accId, false);
                var container = document.createElement("div");
                container.classList.add("col-lg-3");
                container.appendChild(row);
                $('#related-acc').append(container);
            });
        } else {
            $('#related-acc').html("No ralated accessories.");
        }
    }

}

