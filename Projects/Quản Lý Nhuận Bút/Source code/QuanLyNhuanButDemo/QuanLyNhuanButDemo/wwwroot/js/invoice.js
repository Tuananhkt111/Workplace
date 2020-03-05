$(document).ready(function () {
    $('#StockDeduction').on('blur', function () {
        if ($('#StockDeduction').val() === "") {
            $('#StockDeduction').val(0);
        }
    });
    $('#StockDeduction').maskNumber({
        integer: true
    });
    $.datetimepicker.setLocale('vi');
    $('#monthSearch').datetimepicker({
        timepicker: false,
        format: 'm/Y',
        onChangeMonth: function (cur, $i) {
            $('#monthSearch').val(moment(new Date(cur)).format("MM/YYYY"));
        },
        weeks: false,
        scrollInput: false,
        validateOnBlur: false
    });
    $('#monthSearch2').datetimepicker({
        timepicker: false,
        format: 'm/Y',
        onChangeMonth: function (cur, $i) {
            $('#monthSearch2').val(moment(new Date(cur)).format("MM/YYYY"));
        },
        weeks: false,
        scrollInput: false,
        validateOnBlur: false
    });
    $('#search-log').validate({
        rules: {
            monthSearch: {
                required: true,
                maxlength: 10
            },
        },
        messages: {
            monthSearch: {
                required: "Tháng không thể bỏ trống.",
                maxlength: "Tháng có format mm/yyyy."
            },
        }
    });
    $('#search-reporter').validate({
        rules: {
            monthSearch2: {
                required: true,
                maxlength: 10
            },
        },
        messages: {
            monthSearch2: {
                required: "Tháng không thể bỏ trống.",
                maxlength: "Tháng có format mm/yyyy."
            },
        }
    });
});