$(function () {
    $('#txtSearch').on('change', function () {
        if ($(this).val() === "Name") {
            $('#searchName').show();
            $('#searchPrice').hide();
            $('#searchCat').hide();
        } else if ($(this).val() === "Price") {
            $('#searchName').hide();
            $('#searchPrice').show();
            $('#searchCat').hide();
        } else {
            $('#searchName').hide();
            $('#searchPrice').hide();
            $('#searchCat').show();
        }
    });
    if ($('#txtSearch').val() === "Name") {
        $('#searchName').show();
        $('#searchPrice').hide();
        $('#searchCat').hide();
    } else if ($('#txtSearch').val() === "Price") {
        $('#searchName').hide();
        $('#searchPrice').show();
        $('#searchCat').hide();
    } else if($('#txtSearch').val() === "Category"){
        $('#searchName').hide();
        $('#searchPrice').hide();
        $('#searchCat').show();
    }
    $('.deleteBook').on('click', function() {
       $('#deleteLink').attr("href",$(this).data("action") + "?bookID=" + $(this).data("id")); 
    });
});