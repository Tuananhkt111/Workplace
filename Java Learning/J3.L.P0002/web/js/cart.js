$(function () {
    $('.edit-cart').on('click', function () {
        $('#txtBookID').val($(this).data("id"));
        $('#txtQuantity').val($(this).data("quantity"));
    });
    $('#form-cart-updt').validate({
        messages: {
            txtQuantity: {
                required: "Quantity cannot be empty",
                min: "Quantity is greater or equal than 1"
            }
        }
    });
    $('.deleteBook').on('click', function () {
        $('#deleteLink').attr("href", $(this).data("action") + "?bookID=" + $(this).data("id"));
    });
});


