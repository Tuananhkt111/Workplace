$(document).ready(function () {
    $('#form-insert').validate({
        rules: {
            txtBookID: {
                required: true
            },
            txtTitle: {
                required: true
            },
            txtAuthor: {
                required: true
            },
            txtDes: {
                required: true
            },
            txtPrice: {
                required: true
            },
            txtQuantity: {
                required: true
            }
        },
        messages: {
            txtBookID: {
                required: "ID cannot be epmty.",
                pattern: "ID must be 13 numbers."
            },
            txtTitle: {
                required: "Title cannot be epmty.",
                pattern: "Title must be 1-50 characters."
            },
            txtAuthor: {
                required: "Author cannot be empty.",
                pattern: "Author must be 1-40 characters."
            },
            txtDes: {
                required: "Description cannot be empty.",
                pattern: "Description must be 1-500 characters."
            },
            file: {
                accept: "Please input valid image extension .pjp, .jpg, .pjpeg, .jpeg, .jfif or .png"
            },
            txtPrice: {
                required: "Price cannot be empty"
            },
            txtQuantity: {
                required: "Quantity cannot be empty",
                step: "Quantity must be an non-negative integer"
            }
        }
    });
});