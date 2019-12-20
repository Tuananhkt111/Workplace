$(function () {

    $('#txtSearch').on('change', function () {
        if ($(this).val() === "HotelName") {
            $('#searchName').show();
            $('#searchArea').hide();
        } else {
            $('#searchName').hide();
            $('#searchArea').show();
        }
    });
    if ($('#txtSearch').val() === "HotelName") {
        $('#searchName').show();
        $('#searchArea').hide();
    } else {
        $('#searchName').hide();
        $('#searchArea').show();
    }
    $('#form-search').validate({
        rules: {
            txtCheckinDate: {
                required: true
            },
            txtCheckoutDate: {
                required: true
            },
            txtQuantity: {
                required: true
            }
        },
        messages: {
            txtCheckinDate: {
                required: "Date checkin cannot be empty"
            },
            txtCheckoutDate: {
                required: "Date checkout cannot be empty"
            },
            txtQuantity: {
                required: "Quantity cannot be empty",
                maxlength: "Max length is 9 numbers",
                step: "Quantity is an integer"
            }
        },
        submitHandler: function (form) {
            var startDate = new Date($('#txtCheckinDate').val());
            var endDate = new Date($('#txtCheckoutDate').val());
            if (startDate >= endDate) {
                $('#date-error').html('Checkout date must greater than Checkin date');
            } else {
                $('#date-error').html('');
                form.submit();
            }
        }
    });
});