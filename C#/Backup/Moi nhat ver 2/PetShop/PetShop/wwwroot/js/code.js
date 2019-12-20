var listAccessoryFavorite = null;
function checkCartLink() {
    if (roleValue === "user") {
        window.location.href = "../ShoppingCart";
    } else if (roleValue === "admin") {
        showMessage("Your role ADMIN is not authorized");
    } else {
        $('#modalLRForm').modal('show');
    }
}
;
function showMessage() {
    $("#myModal").modal("show");
}
function showMessage(msg) {
    $('#msg-modal').html(msg);
    $("#myModal").modal("show");
}
function checkFavoriteExisted(accID) {
    var check = false;
    $.each(listAccessoryFavorite, function () {
        if (this.accId === accID) {
            check = true;
        }
    });
    return check;
}
function insertFavorite(accID, username, element) {
    let obj = {
        AccId: accID,
        Username: username
    }
    $.ajax({
        type: "POST",
        url: "/Favorite/InsertFavorite",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            element.classList.remove("wishlist-btn");
            element.classList.add("wishlist-btn1");
            showMessage(data);
        },
        error: function () {
            alert("Insert favorite error.");
        }
    });
}

function addCart(accID) {
    $.ajax({
        type: "POST",
        url: "/ShoppingCart/AddCart",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(accID),
        success: function (data) {
            $('#cartCount').html(data.count);
            showMessage(data.msg);
        },
        error: function () {
            alert("Add accessory to cart failed.");
        }
    });
}

function countCart() {
    $.ajax({
        type: "GET",
        url: "/ShoppingCart/CountCart",
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            $('#cartCount').html(data);
        },
        error: function () {
            alert("Count cart failed.");
        }
    });
}
function deleteFavorite(accID, username, element) {
    let obj = {
        AccId: accID,
        Username: username
    }
    $.ajax({
        type: "POST",
        url: "/Favorite/DeleteFavorite",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            element.classList.add("wishlist-btn");
            element.classList.remove("wishlist-btn1");
            showMessage(data);
        },
        error: function () {
            alert("Delete favorite failed.");
        }
    });
}
function createSubMenuListItem(url, name) {
    var liItem = document.createElement("li");
    var aTag = document.createElement("a");
    aTag.innerHTML = name;
    aTag.href = url;
    liItem.appendChild(aTag);
    return liItem;
}
function createSubMenuItem(url, name, id) {
    var liItem = document.createElement("li");
    var aTag = document.createElement("a");
    var submenulist = document.createElement("ul");
    submenulist.classList.add("sub-menu-list");
    submenulist.id = "sml" + id;
    aTag.innerHTML = name;
    aTag.href = url;
    liItem.appendChild(aTag);
    liItem.appendChild(submenulist);
    return liItem;
}
function createProductItem(img, price, name, salePercent, accID, isFavorited) {
    var pItem = document.createElement("div");
    var pPic = document.createElement("div");
    var pLink = document.createElement("div");
    var pText = document.createElement("div");
    var priceTag = document.createElement("h6");
    var nameTag = document.createElement("a");
    var imgSrc = document.createElement("img");
    var acLink = document.createElement("a");
    var wbLink = document.createElement("a");
    var bag = document.createElement("i");
    var heart = document.createElement("i");
    var visible = document.createElement("i");
    var spanText = document.createElement("span");
    var newTag = document.createElement("div");
    var saleTag = document.createElement("div");
    var brLine = document.createElement("br");
    var priceSaleTag = document.createElement("del");
    var priceSale;
    newTag.classList.add("tag-new");
    newTag.innerHTML = "NEW";
    saleTag.classList.add("tag-sale");
    saleTag.style = "font-size: 20px;";
    if (salePercent > 0) {
        var x = salePercent * 100;
        x = Math.round(x);
        saleTag.innerHTML = x + "%";
        priceSaleTag.style = "color: gray;";
        priceSale = price * (1 - salePercent);
        priceSale = Math.round(priceSale * 100) / 100;
        priceRound = Math.round(price * 100) / 100;
        priceSaleTag.innerHTML = "$" + priceRound;
    }
    spanText.innerHTML = "ADD TO CART";
    bag.classList.add("flaticon-bag");
    heart.classList.add("flaticon-heart");
    visible.classList.add("flaticon-visible");
    acLink.classList.add("add-card");
    acLink.appendChild(bag);
    acLink.appendChild(spanText);
    if (isFavorited) {
        wbLink.classList.add("wishlist-btn1");
    } else {
        wbLink.classList.add("wishlist-btn");
    }
    wbLink.onclick = function () {
        if (roleValue === "user") {
            if (this.classList[0] === "wishlist-btn") {
                insertFavorite(accID, usernameValue, this);
            } else {
                deleteFavorite(accID, usernameValue, this);
            }
        } else if (roleValue === "admin") {
            alert("Your role ADMIN is not authorized");
        } else {
            $('#modalLRForm').modal('show');
        }
    };
    acLink.onclick = function () {
        if (roleValue === "user") {
            addCart(accID);
        } else if (roleValue === "admin") {
            alert("Your role ADMIN is not authorized");
        } else {
            $('#modalLRForm').modal('show');
        }
    };
    wbLink.appendChild(heart);
    wbLink.style = "cursor: pointer";
    acLink.style = "cursor: pointer";
    pLink.appendChild(acLink);
    pLink.appendChild(wbLink);
    pLink.classList.add("pi-links");
    if (img === "") {
        imgSrc.src = "../img/product/noimage.jpg";
    } else {
        imgSrc.src = "../img/product/" + img;
    }
    imgSrc.onerror = function () {
        this.onerror = null;
        this.src = "../img/product/noimage.jpg";
    };
    imgSrc.alt = "Image not found";
    pPic.appendChild(imgSrc);
    pPic.appendChild(pLink);
    pPic.classList.add("pi-pic");
    if (salePercent > 0) {
        priceTag.appendChild(priceSaleTag);
        priceTag.appendChild(brLine);
        priceTag.append("$" + priceSale);
    } else {
        priceTag.innerHTML = "$" + Math.round(price * 100) / 100;
    }
    nameTag.innerHTML = name;
    nameTag.href = "../Accessory/FindAccById?accIdSearch=" + accID;
    pText.appendChild(priceTag);
    pText.appendChild(nameTag);
    pText.classList.add("pi-text");
    pItem.appendChild(pPic);
    pItem.appendChild(pText);
    if (salePercent > 0) {
        pItem.appendChild(saleTag);
    }
    pItem.classList.add("product-item");
    pItem.classList.add("animated");
    pItem.classList.add("fadeIn");
    pItem.style = "margin:0 20px";
    return pItem;
}
$(function () {
    var listPetCategory = null;
    var listAccessoryCategory = null;
    getAllPetCategory();
    if (roleValue === "user") {
        getAccessoryFavoriteByUsername();
        countCart();
    }
    function getAccessoryFavoriteByUsername() {
        $.ajax({
            type: "GET",
            async: false,
            url: "/Favorite/LoadFavoriteAccessoriesByName",
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                listAccessoryFavorite = data;
            },
            error: function () {
                alert(" getAccessoryFavoriteByUsername error.");
            }
        });
    }
    function getAllPetCategory() {
        $.ajax({
            type: "POST",
            url: "/PetCategory/LoadAllPetCategory",
            dataType: 'json',
            success: function (data) {
                listPetCategory = data;
                loadSubMenuDropdown();
                getAllAccesoryCategory();
            },
            error: function () {
                alert("getAllPetCategory error.");
            }
        });
    }
    function getAllAccesoryCategory() {
        $.ajax({
            type: "POST",
            url: "/AccessoryCategory/LoadAllAccessoryCategory",
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                listAccessoryCategory = data;
                loadSubMenuListDropdown();
            },
            error: function () {
                alert("getAllAccesoryCategory error.");
            }
        });
    }
    function loadSubMenuDropdown() {
        if (listPetCategory !== null) {
            $.each(listPetCategory, function () {
                var row = createSubMenuItem("../Accessory/FindByPetCatID?petCatSearch=" + this.petCatId, this.petType, this.petCatId);
                $('#accessories-dropdown').append(row);
            });
        } else {
            $('#accessories-dropdown').html("<li><a>No pet categories</a></li>");
        }
    }
    function loadSubMenuListDropdown() {
        if (listAccessoryCategory !== null) {
            $.each(listPetCategory, function () {
                let id = this.petCatId;
                let check = false;
                $.each(listAccessoryCategory, function () {
                    if (id === this.petCatId) {
                        let row = createSubMenuListItem("../Accessory/FindByAccCatID?accCatIDSearch=" + this.accCatId, this.accCatName);
                        $('#sml' + id).append(row);
                        check = true;
                    }
                });
                if (!check) {
                    $('#sml' + id).html("<li><a>No accessory categories</a></li>");
                }
            });
        } else {
            $('#accessories-dropdown').html("<li><a>No accessory categories</a></li>");
        }
    }
});

