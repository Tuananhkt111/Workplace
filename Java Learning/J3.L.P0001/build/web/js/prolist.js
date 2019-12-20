$(function () {
    $('.edit-pro-list').on('click', function() {
       $('#txtUserID').val($(this).data("id")); 
       $('#txtRank').val($(this).data("rank")); 
    });
    $('#form-pro-list-updt').validate({
       messages: {
           txtRank: {
               required: "Rank cannot be empty",
               min: "Rank is greater or equal than 1",
               max: "Rank is smaller than 10",
               maxlength: "Maximum length is 3"
           }
       } 
    });
});


