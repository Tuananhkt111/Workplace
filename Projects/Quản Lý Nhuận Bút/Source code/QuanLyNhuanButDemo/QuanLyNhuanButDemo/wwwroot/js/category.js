var markValue;
function getMarkValue() {
    $.ajax({
        type: "GET",
        url: "/Category/GetMarkValue",
        dataType: "json",
        contentType: 'application/json; charset=utf-8',
        success: function (result) {
            markValue = result.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,');
            $('#MarkVal').val(markValue);
            $('#MarkVal').on('blur', function () {
                if ($('#MarkVal').val() === "0" || $('#MarkVal').val() === "") {
                    $('#MarkVal').val(markValue);
                }
            });
        },
        error: function (error) {
            showMessage(error);
        }
    });
};
$(document).ready(function () {
    getMarkValue();
    $('#MarkVal').maskNumber({
        integer: true
    });
    $('#form-mark-val').submit(function (e) {
        e.preventDefault();
    });
    $('#changeMarkBtn').on('click', function () {
        $.ajax({
            type: "POST",
            url: "/Category/ChangeMarkValue",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(parseInt($('#MarkVal').val().replace(",", ""))),
            success: function (result) {
                if (result === "") {
                    showMessage("Đổi giá trị điểm nhuận bút thành công");
                    markValue = $('#MarkVal').val();
                }
                else
                    showMessage(result);
            },
            error: function (error) {
                showMessage(error);
            }
        });
    });
});