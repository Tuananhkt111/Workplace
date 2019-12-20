$(function () {
       $('.deleteBook').on('click', function () {
        $('#deleteLink').attr("href", $(this).data("action") + "?txtTranID=" + $(this).data("id"));
    }); 
});