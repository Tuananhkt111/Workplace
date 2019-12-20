$(function () {
    $('.edit-cart').on('click', function () {
        $('#txtRoomTypeID').val($(this).data("id"));
        $('#txtQuantity').val($(this).data("quantity"));
    });
    $('#form-cart-updt').validate({
        messages: {
            txtQuantity: {
                required: "Quantity cannot be empty",
                min: "Quantity is greater or equal than 1",
                maxlength: "Max length is 9 characters"
            }
        }
    });
    $('.deleteBook').on('click', function () {
        $('#deleteLink').attr("href", $(this).data("action") + "?roomTypeID=" + $(this).data("id"));
    });
});


