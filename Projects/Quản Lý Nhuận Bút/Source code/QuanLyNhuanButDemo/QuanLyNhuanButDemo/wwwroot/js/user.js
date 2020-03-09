function resetForm() {
    $('#UsernameRg').val("");
    $('#NickNameRg').val("");
    $('#NameRg').val("");
    $('#PasswordRg').val("");
    $('#RepPassRg').val("");
}
function checkUsernameExisted() {
    $.ajax({
        type: "POST",
        url: "/Admin/ManageUser/CheckUsername",
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($('#UsernameRg').val()),
        success: function (isExisted) {
            if (isExisted === true) {
                $('#Username-exist').html("Tên đăng nhập đã tồn tại.");
            } else {
                $('#Username-exist').html("");
            }
        },
        error: function () {
            alert("Admin/ManageUser/CheckUsername error.");
        }
    });
}
$(document).ready(function () {
    $('#departmentInput').hide();
    $('#RoleRg').on('change', function () {
        if ($(this).val() === "Phóng viên") {
            $('#departmentInput').show();
        } else {
            $('#departmentInput').hide();
        }
    });
    $('.departmentInput2').hide();
    $('#RoleUpdt').on('change', function () {
        if ($(this).val() === "Phóng viên") {
            $('.departmentInput2').show();
        } else {
            $('.departmentInput2').hide();
        }
    });
    $.fn.dataTable.moment('DD-MM-YYYY HH:mm:ss');
    var t = $('#dataTable').DataTable({
        "ajax": {
            url: "/Admin/ManageUser/LoadAllAccount",
            dataSrc: "",
            dataType: "json"
        },
        'columns': [
            { "data": "userName" },
            {
                "data": "name",
                "visible": false
            },
            {
                "data": "nickName",
                "visible": false
            },
            {
                "data": function (row) {
                    let para = document.createElement("div");
                    let nameSpan = document.createElement("p");
                    let nickNameSpan = document.createElement("p");
                    nameSpan.innerHTML = row.name;
                    nickNameSpan.innerHTML = row.nickName;
                    nickNameSpan.setAttribute("style", "color: blue");
                    para.appendChild(nameSpan);
                    para.appendChild(nickNameSpan);
                    return para.outerHTML;
                }
            },
            { "data": "role" },
            {
                "data": "departmentId",
                "visible": false
            },
            {
                "data": "departmentName",
            },
            {
                "data": "status",
                "render": function (data) {
                    return data ? "Đã vô hiệu hóa" : "Có thế sử dụng"
                }
            },
            {
                "data": "timeModified",
                "render": function (data) {
                    let date = new Date(data);
                    return data ? moment(date).format('DD-MM-YYYY HH:mm:ss') : '';
                }
            },
            {
                "data": function (row) {
                    let linkDiv = document.createElement("div");
                    let passLink = document.createElement("a");
                    let br = document.createElement("span");
                    br.innerHTML = "/";
                    passLink.setAttribute("data-toggle", "modal");
                    passLink.href = 'javascript: void (0)';
                    passLink.setAttribute("data-target", "#modalUpdtPassForm");
                    passLink.setAttribute("data-id", row.userName);
                    passLink.style = "cursor: pointer";
                    passLink.classList.add("updtPass");
                    passLink.innerHTML = "Đổi mật khẩu";
                    let editLink = document.createElement("a");
                    editLink.setAttribute("data-toggle", "modal");
                    editLink.href = 'javascript: void (0)';
                    editLink.setAttribute("data-target", "#modalUpdtAccForm");
                    editLink.setAttribute("data-id", row.userName);
                    editLink.setAttribute("data-depid", row.departmentId);
                    editLink.setAttribute("data-status", row.status);
                    editLink.setAttribute("data-name", row.name);
                    editLink.setAttribute("data-nickname", row.nickName);
                    editLink.setAttribute("data-role", row.role);
                    editLink.style = "cursor: pointer";
                    editLink.classList.add("updtAcc");
                    editLink.innerHTML = "Chỉnh sửa";
                    linkDiv.appendChild(editLink);
                    linkDiv.appendChild(br);
                    linkDiv.appendChild(passLink);
                    return linkDiv.outerHTML;
                }
            }
        ],
        "order": [[8, "desc"]],
        "language": {
            "emptyTable": "Không có tài khoản nào có sẵn",
            "lengthMenu": "Hiển thị _MENU_ tài khoản mỗi trang",
            "zeroRecords": "Không tìm thấy tài khoản nào",
            "info": "Hiển thị trang _PAGE_ trên _PAGES_ từ tất cả _MAX_ tài khoản",
            "infoEmpty": "Hiển thị trang 0 trên 0",
            "infoFiltered": "(đã lọc từ tất cả _MAX_ tài khoản)",
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
    $('#dataTable tbody').on('click', '.updtAcc', function () {
        let row = $(this);
        $('#UsernameUpdt').val(row.data("id"));
        $('#NameUpdt').val(row.data("name"));
        $('#NickNameUpdt').val(row.data("nickname"));
        $('#RoleUpdt').val(row.data("role"));
        if ($('#RoleUpdt').val() === "Phóng viên") {
            $('.departmentInput2').show();
        } else {
            $('.departmentInput2').hide();
        }
        $('#DepartmentUpdt').val(row.data("depid"));
        $('#DepartmentUpdt').change();
        if (!row.data("status")) {
            $('#IsDeletedUpdt').val("false");
        } else {
            $('#IsDeletedUpdt').val("true");
        }
    });
    $('#dataTable tbody').on('click', '.updtPass', function () {
        $('#UsernameUpdtPass').val($(this).data("id"));
    });
    function createAccount() {
        let departmentId = $('#DepartmentRg').val();
        let obj = {
            Username: $('#UsernameRg').val(),
            Name: $('#NameRg').val(),
            NickName: $('#NickNameRg').val(),
            Role: $('#RoleRg').val(),
            Password: $('#PasswordRg').val(),
            Status: false,
            TimeModified: new Date(),
            DepartmentId: $('#RoleRg').val() === "Phóng viên" ? departmentId : null
        }
        $.ajax({
            type: "POST",
            url: "/Admin/ManageUser/CreateAccount",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    showMessage("Tạo tài khoản thành công");
                    resetForm();
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    function UpdateAccount() {
        let departmentId = $('#DepartmentUpdt').val();
        let obj = {
            UserName: $('#UsernameUpdt').val(),
            Name: $('#NameUpdt').val(),
            NickName: $('#NickNameUpdt').val(),
            Role: $('#RoleUpdt').val(),
            Password: "",
            Status: $('#IsDeletedUpdt').val() === "true" ? true : false,
            TimeModified: new Date(),
            DepartmentId: $('#RoleUpdt').val() === "Phóng viên" ? departmentId : null
        }
        $.ajax({
            type: "POST",
            url: "/Admin/ManageUser/UpdateAccount",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    $("#modalUpdtAccForm").modal("hide");
                    showMessage("Cập nhật tài khoản thành công");
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    function ChangePass() {
        let obj = {
            Username: $('#UsernameUpdtPass').val(),
            PasswordNew: $('#PasswordUpdt').val(),
            PasswordOld: ""
        }
        $.ajax({
            type: "POST",
            url: "/Admin/ManageUser/ChangePassword",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    $("#modalUpdtPassForm").modal("hide");
                    showMessage("Thay đổi mật khẩu thành công");
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    $('#form-register').validate({
        rules: {
            UsernameRg: {
                required: true
            },
            NameRg: {
                required: true
            },
            PasswordRg: {
                required: true
            },
            RepPassRg: {
                required: true,
                equalTo: "#PasswordRg"
            },
        },
        messages: {
            UsernameRg: {
                required: "Tên đăng nhập không thể bỏ trống.",
                pattern: "Tên đăng nhập có tối đa 30 kí tự, chỉ bao gồm chữ số và chữ cái."
            },
            NameRg: {
                required: "Tên không thể bỏ trống.",
                pattern: "Tên có 1-40 kí tự."
            },
            NickNameRg: {
                pattern: "Bút danh có tối đa 40 kí tự."
            },
            PasswordRg: {
                required: "Mật khẩu không thể bỏ trống.",
                pattern: "Mật khẩu có từ 8-16 kí tự, bao gồm ít nhất 1 chữ in hoa và 1 chữ in thường."
            },
            RepPassRg: {
                required: "Mật khẩu không được bỏ trống",
                pattern: "Mật khẩu có từ 8-16 kí tự, bao gồm ít nhất 1 chữ in hoa và 1 chữ in thường.",
                equalTo: "Nhập lại mật khẩu không trùng"
            }
        },
        submitHandler: function () {
            if (($('#DepartmentRg').val() === "") && $('#RoleRg').val() === "Phóng viên") {
                $('#DepartmentUpdt-exist').html("Chưa chọn đơn vị không thể tạo mới");
            } else if ($('#Username-exist').html() !== "") {
                $('#DepartmentUpdt-exist').html("");
            } else {
                $('#DepartmentUpdt-exist').html("");
                createAccount();
            }
        }
    });
    var validator_update = $('#form-acc-updt').validate({
        rules: {
            NameUpdt: {
                required: true
            }
        },
        messages: {
            NameUpdt: {
                required: "Tên không thể bỏ trống.",
                pattern: "Tên có 1-40 kí tự."
            },
            NickNameUpdt: {
                pattern: "Bút danh có tối đa 40 kí tự."
            }
        },
        submitHandler: function () {
            if (($('#DepartmentUpdt').val() === "" || $('#DepartmentUpdt').val() === null) && $('#RoleUpdt').val() === "Phóng viên") {
                $('#DepartmentUpdt-exist').html("Chưa chọn đơn vị không thể cập nhật");
            } else {
                $('#DepartmentUpdt-exist').html("");
                UpdateAccount();
            }
        }
    });
    $('#modalUpdtAccForm').on('click', '.close', function () {
        validator_update.resetForm();
    });
    $("#modalUpdtAccForm").on("hidden.bs.modal", function () {
        validator_update.resetForm();
    });
    var validator_pass = $('#form-pass-updt').validate({
        rules: {
            PasswordUpdt: {
                required: true
            },
            RepPassUpdt: {
                required: true,
                equalTo: "#PasswordUpdt"
            },
        },
        messages: {
            PasswordUpdt: {
                required: "Mật khẩu không thể bỏ trống.",
                pattern: "Mật khẩu có từ 8-16 kí tự, bao gồm ít nhất 1 chữ in hoa và 1 chữ in thường."
            },
            RepPassUpdt: {
                required: "Mật khẩu không được bỏ trống",
                pattern: "Mật khẩu có từ 8-16 kí tự, bao gồm ít nhất 1 chữ in hoa và 1 chữ in thường.",
                equalTo: "Nhập lại mật khẩu không trùng"
            }
        },
        submitHandler: function () {
            ChangePass();
        }
    });
    $('#modalUpdtPassForm').on('click', '.close', function () {
        validator_pass.resetForm();
    });
    $("#modalUpdtPassForm").on("hidden.bs.modal", function () {
        validator_pass.resetForm();
    });
});