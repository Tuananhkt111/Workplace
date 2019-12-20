$(function () {
   $('#txtSearch').on('change', function () {
        if ($(this).val() === "Name") {
            $('#searchName').show();
            $('#searchDate').hide();
        } else {
            $('#searchName').hide();
            $('#searchDate').show();
        }
    });
    if ($('#txtSearch').val() === "Name") {
        $('#searchName').show();
        $('#searchDate').hide();
    } else if ($('#txtSearch').val() === "ShoppingDate") {
        $('#searchName').hide();
        $('#searchDate').show();
    }
});