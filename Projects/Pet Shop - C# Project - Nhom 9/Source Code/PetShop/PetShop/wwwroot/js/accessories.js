function addFavorite(accID, element) {
    if (roleValue === "user") {
        if (element.classList[0] === "wishlist-btn") {
            insertFavorite(accID, usernameValue, element);
        } else {
            deleteFavorite(accID, usernameValue, element);
        }
    } else if (roleValue === "admin") {
        alert("Your role ADMIN is not authorized");
    } else {
        $('#modalLRForm').modal('show');
    }
}
function addToCart(accID) {
    if (roleValue === "user") {
        addCart(accID);
    } else if (roleValue === "admin") {
        alert("Your role ADMIN is not authorized");
    } else {
        $('#modalLRForm').modal('show');
    }
}

$(function () {
    $('.imgSrc').on("error", function () {
        this.onerror = null;
        this.src = "../img/product/noimage.jpg";
    });
    $('.wishlist-btn').each(function () {
        if (checkFavoriteExisted(this.id)) {
            this.classList.add("wishlist-btn1");
            this.classList.remove("wishlist-btn");
        } else {
            this.classList.add("wishlist-btn");
            this.classList.remove("wishlist-btn1");
        }
    });
});