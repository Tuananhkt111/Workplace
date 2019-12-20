$(function () {
    $('#form-book').validate({
        rules: {
            txtQuantity: {
                required: true
            }
        },
        messages: {
            txtQuantity: {
                required: "Quantity cannot be empty",
                maxlength: "Max length is 9 numbers",
                step: "Quantity is an integer"
            }
        }
    });
});