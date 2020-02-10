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
function resetForm() {
    $('#CategoryAdd').val("");
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
    var t = $('#dataTable').DataTable({
        "ajax": {
            url: "/Category/GetAllCategories",
            type: "GET",
            dataSrc: "",
            contentType: "application/json",
            dataType: "json"
        },
        'columns': [
            {
                "data": "categoryId",
                "visible": false,
            },
            {
                "data": "categoryName"
            },
            {
                "data": "minMark"
            },
            {
                "data": "maxMark"
            },
            {
                "data": function (row) {
                    let linkDiv = document.createElement("div");
                    let editLink = document.createElement("a");
                    let br = document.createElement("span");
                    br.innerHTML = "/";
                    editLink.setAttribute("data-toggle", "modal");
                    editLink.href = 'javascript: void (0)';
                    editLink.setAttribute("data-target", "#modalUpdtCategoryForm");
                    editLink.setAttribute("data-id", row.categoryId);
                    editLink.setAttribute("data-name", row.categoryName);
                    editLink.setAttribute("data-min", row.minMark);
                    editLink.setAttribute("data-max", row.maxMark);
                    editLink.setAttribute("class", "updtCategory");
                    editLink.style = "cursor: pointer";
                    editLink.innerHTML = "Chỉnh sửa";
                    let deleteLink = document.createElement("a");
                    deleteLink.href = 'javascript: void (0)';
                    deleteLink.setAttribute("class", "delCategory");
                    deleteLink.setAttribute("data-id", row.categoryId);
                    deleteLink.style = "cursor: pointer";
                    deleteLink.innerHTML = "Xóa";
                    linkDiv.appendChild(editLink);
                    linkDiv.appendChild(br);
                    linkDiv.appendChild(deleteLink);
                    return linkDiv.outerHTML;
                }
            }
        ],
        "order": [[1, "asc"]],
        "language": {
            "emptyTable": "Không có thể loại nào có sẵn",
            "lengthMenu": "Hiển thị _MENU_ thể loại mỗi trang",
            "zeroRecords": "Không tìm thấy thể loại nào",
            "info": "Hiển thị trang _PAGE_ trên _PAGES_",
            "infoEmpty": "Hiển thị trang 0 trên 0",
            "infoFiltered": "(đã lọc từ tất cả _MAX_ thể loại)",
            "loadingRecords": "Đang tải...",
            "processing": "Đang xử lí...",
            "search": "Tìm kiếm:",
            "paginate": {
                "first": "Đầu",
                "last": "Cuối",
                "next": "Tiếp",
                "previous": "Trước"
            },
            "aria": {
                "sortAscending": ": Sắp xếp tăng đân",
                "sortDescending": ": Sắp xếp giảm dần"
            }
        },
        "stateSave": true,
        "pagingType": "full_numbers"
    });
    $('#dataTable tbody').on('click', '.updtCategory', function () {
        let x = $(this);
        $('#CategoryUpdt').val($(this).data("name"));
        $('#CategoryIdUpdt').val($(this).data("id"));
        $('#MinMarkUpdt').val($(this).data("min"));
        $('#MaxMarkUpdt').val($(this).data("max"));
    });
    $('#dataTable tbody').on('click', '.delCategory', function () {
        let id = $(this).data("id");
        console.log(id);
        $("#confirmDeleteModal").modal("show");
        $('#delCategoryBtn').on('click', function () {
            deleteCategory(id);
        });
    });
    function createCategory() {
        let obj = {
            CategoryId: "C" + new Date().getTime(),
            CategoryName: $('#CategoryAdd').val(),
            MinMark: parseInt($('#MinMarkAdd').val()),
            MaxMark: parseInt($('#MaxMarkAdd').val())
        }
        $.ajax({
            type: "POST",
            url: "/Category/InsertCategory",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    showMessage("Tạo thể loại thành công");
                    resetForm();
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    function updateCategory() {
        let obj = {
            CategoryId: $('#CategoryIdUpdt').val(),
            CategoryName: $('#CategoryUpdt').val(),
            MinMark: parseInt($('#MinMarkUpdt').val()),
            MaxMark: parseInt($('#MaxMarkUpdt').val())
        }
        $.ajax({
            type: "POST",
            url: "/Category/UpdateCategory",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    $("#modalUpdtCategoryForm").modal("hide");
                    showMessage("Cập nhật thể loại thành công");
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    function deleteCategory(id) {
        $.ajax({
            type: "POST",
            url: "/Category/DeleteCategory",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(id),
            success: function (result) {
                if (result === "") {
                    $("#confirmDeleteModal").modal("hide");
                    showMessage("Xóa thể loại thành công");
                    t.ajax.reload();
                } else {
                    $("#confirmDeleteModal").modal("hide");
                    showMessage(result);
                }
            }
        });
    }
    $('#form-category-add').validate({
        rules: {
            CategoryAdd: {
                required: true
            },
            MinMarkAdd: {
                required: true
            },
            MaxMarkAdd: {
                required: true
            },
        },
        messages: {
            CategoryAdd: {
                required: "Tên thể loại không thể bỏ trống.",
                pattern: "Tên thể loại có 1 - 400 kí tự."
            },
            MinMarkAdd: {
                required: "Điểm thấp nhất không thể bỏ trống.",
                step: "Điểm thấp nhất không có phần thập phân.",
                min: "Điểm thấp nhất lớn hơn hoặc bằng 1",
                number: "Vui lòng nhập số"
            },
            MaxMarkAdd: {
                required: "Điểm cao nhất không thể bỏ trống.",
                step: "Điểm cao nhất không có phần thập phân.",
                min: "Điểm cao nhất lớn hơn hoặc bằng 1",
                number: "Vui lòng nhập số"
            }
        },
        submitHandler: function () {
            createCategory();
        }
    });
    var validator_update = $('#form-acc-updt').validate({
        rules: {
            CategoryUpdt: {
                required: true
            },
            MinMarkUpdt: {
                required: true
            },
            MaxMarkUpdt: {
                required: true
            },
        },
        messages: {
            CategoryUpdt: {
                required: "Tên thể loại không thể bỏ trống.",
                pattern: "Tên thể loại có 1 - 400 kí tự."
            },
            MinMarkUpdt: {
                required: "Điểm thấp nhất không thể bỏ trống.",
                step: "Điểm thấp nhất không có phần thập phân.",
                min: "Điểm thấp nhất lớn hơn hoặc bằng 1",
                number: "Vui lòng nhập số"
            },
            MaxMarkUpdt: {
                required: "Điểm cao nhất không thể bỏ trống.",
                step: "Điểm cao nhất không có phần thập phân.",
                min: "Điểm cao nhất lớn hơn hoặc bằng 1",
                number: "Vui lòng nhập số"
            }
        },
        submitHandler: function () {
            updateCategory();
        }
    });
    $('#modalUpdtCategoryForm').on('click', '.close', function () {
        validator_update.resetForm();
    });
    $("#modalUpdtCategoryForm").on("hidden.bs.modal", function () {
        validator_update.resetForm();
    });
    $('body').tooltip({ selector: '[data-toggle="tooltip"]' });
});