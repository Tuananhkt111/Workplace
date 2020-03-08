function resetForm() {
    $('#DepartmentAdd').val("");
};
$(document).ready(function () {
    var t = $('#dataTable').DataTable({
        "ajax": {
            url: "/Department/GetAllDepartments",
            type: "GET",
            dataSrc: "",
            contentType: "application/json",
            dataType: "json"
        },
        'columns': [
            {
                "data": "departmentId",
                "visible": false,
            },
            {
                "data": "departmentTypeId",
                "visible": false
            },
            {
                "data": "departmentType"
            },
            {
                "data": "departmentName"
            },
            {
                "data": "stockRate",
                "render": function (data) {
                    return data + "%";
                }
            },
            {
                "data": function (row) {
                    let linkDiv = document.createElement("div");
                    let editLink = document.createElement("a");
                    let br = document.createElement("span");
                    br.innerHTML = "/";
                    editLink.setAttribute("data-toggle", "modal");
                    editLink.href = 'javascript: void (0)';
                    editLink.setAttribute("data-target", "#modalUpdtDepartmentForm");
                    editLink.setAttribute("data-id", row.departmentId);
                    editLink.setAttribute("data-type", row.departmentTypeId);
                    editLink.setAttribute("data-name", row.departmentName);
                    editLink.setAttribute("data-rate", row.stockRate);
                    editLink.setAttribute("class", "updtDepartment");
                    editLink.style = "cursor: pointer";
                    editLink.innerHTML = "Chỉnh sửa";
                    let deleteLink = document.createElement("a");
                    deleteLink.href = 'javascript: void (0)';
                    deleteLink.setAttribute("class", "delDepartment");
                    deleteLink.setAttribute("data-id", row.departmentId);
                    deleteLink.style = "cursor: pointer";
                    deleteLink.innerHTML = "Xóa";
                    linkDiv.appendChild(editLink);
                    linkDiv.appendChild(br);
                    linkDiv.appendChild(deleteLink);
                    return linkDiv.outerHTML;
                }
            }
        ],
        "order": [[2, "asc"]],
        "language": {
            "emptyTable": "Không có đơn vị nào có sẵn",
            "lengthMenu": "Hiển thị _MENU_ đơn vị mỗi trang",
            "zeroRecords": "Không tìm thấy đơn vị nào",
            "info": "Hiển thị trang _PAGE_ trên _PAGES_ từ tất cả _MAX_ đơn vị",
            "infoEmpty": "Hiển thị trang 0 trên 0",
            "infoFiltered": "(đã lọc từ tất cả _MAX_ đơn vị)",
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
    $('#dataTable tbody').on('click', '.updtDepartment', function () {
        let x = $(this);
        $('#DepartmentUpdt').val($(this).data("name"));
        $('#DepartmentIdUpdt').val($(this).data("id"));
        $('#DepartmentTypeUpdt').val($(this).data("type"));
        $('#StockRateUpdt').val($(this).data("rate"));
    });
    $('#dataTable tbody').on('click', '.delDepartment', function () {
        let id = $(this).data("id");
        $("#confirmDeleteModal").modal("show");
        $('#delId').val(id);
    });
    function createDepartment() {
        let obj = {
            DepartmentId: "D" + new Date().getTime(),
            DepartmentType: parseInt($('#DepartmentTypeAdd').val()),
            DepartmentName: $('#DepartmentAdd').val(),
            StockRate: parseInt($('#StockRateAdd').val())
        }
        $.ajax({
            type: "POST",
            url: "/Department/InsertDepartment",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    showMessage("Tạo đơn vị thành công");
                    resetForm();
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    function updateDepartment() {
        let obj = {
            DepartmentId: $('#DepartmentIdUpdt').val(),
            DepartmentName: $('#DepartmentUpdt').val(),
            DepartmentType: parseInt($('#DepartmentTypeUpdt').val()),
            StockRate: parseInt($('#StockRateUpdt').val())
        }
        $.ajax({
            type: "POST",
            url: "/Department/UpdateDepartment",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    $("#modalUpdtDepartmentForm").modal("hide");
                    showMessage("Cập nhật đơn vị thành công");
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    function deleteDepartment() {
        $.ajax({
            type: "POST",
            url: "/Department/DeleteDepartment",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify($('#delId').val()),
            success: function (result) {
                if (result === "") {
                    $("#confirmDeleteModal").modal("hide");
                    showMessage("Xóa đơn vị thành công");
                    t.ajax.reload();
                } else {
                    $("#confirmDeleteModal").modal("hide");
                    showMessage(result);
                }
            }
        });
    }
    $('#delDepartmentBtn').on('click', function () {
        deleteDepartment();
    });
    $('#form-department-add').validate({
        rules: {
            DepartmentAdd: {
                required: true
            },
            StockRateAdd: {
                required: true
            }
        },
        messages: {
            DepartmentAdd: {
                required: "Tên đơn vị không thể bỏ trống.",
                pattern: "Tên đơn vị có 1 - 400 kí tự."
            },
            StockRateAdd: {
                required: "Mức khoán không thể bỏ trống.",
                min: "Mức khoán lớn hơn hoặc bằng 0",
                max: "Mức khoán nhỏ hơn hoặc bằng 100",
                number: "Vui lòng nhập số"
            }
        },
        submitHandler: function () {
            createDepartment();
        }
    });
    var validator_update = $('#form-acc-updt').validate({
        rules: {
            DepartmentUpdt: {
                required: true
            },
            StockRateUpdt: {
                required: true
            }
        },
        messages: {
            DepartmentUpdt: {
                required: "Tên đơn vị không thể bỏ trống.",
                pattern: "Tên đơn vị có 1 - 400 kí tự."
            },
            StockRateUpdt: {
                required: "Mức khoán không thể bỏ trống.",
                min: "Mức khoán lớn hơn hoặc bằng 0",
                max: "Mức khoán nhỏ hơn hoặc bằng 100",
                number: "Vui lòng nhập số"
            }
        },
        submitHandler: function () {
            updateDepartment();
        }
    });
    $('#modalUpdtDepartmentForm').on('click', '.close', function () {
        validator_update.resetForm();
    });
    $("#modalUpdtCategoryForm").on("hidden.bs.modal", function () {
        validator_update.resetForm();
    });
    $('body').tooltip({ selector: '[data-toggle="tooltip"]' });
});