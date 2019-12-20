$(document).ready(function () {
    $('#dateExecuted').datetimepicker({
        timepicker: false,
        datepicker: true,
        format: 'd/m/Y',
        weeks: false
    });
    $('#toggle1').on('click', () => {
        $('#dateExecuted').datetimepicker('toggle')
    });
    $('[data-toggle="tooltip"]').tooltip();
    let validator_update = $('#form-acc-updt').validate({
        rules: {
            NameUpdt: {
                required: true
            },
        },
        messages: {
            NameUpdt: {
                required: "Tên không thể bỏ trống.",
                pattern: "Tên có 1-40 kí tự."
            },
        }
    });
    $('#modalUpdtAccForm').on('click', '.close', function () {
        let obj = $('#NameUpdt')
        obj.val(obj.data("original-value"));
        validator_update.resetForm();
    });
    $.fn.dataTable.moment('DD/MM/YYYY HH:mm:ss');
    var t = $('#dataTable').DataTable({
        "responsive": true,
        "ajax": {
            url: "/ActivityLog/LoadAllActivityLogByUsername",
            type: "POST",
            dataSrc: "",
            contentType: "application/json",
            dataType: "json",
            data: function (d) {
                return JSON.stringify($('#dateExecuted').val());
            }
        },
        'columns': [
            {
                "data": "actLogId",
            },
            { "data": "actType" },
            { "data": "longDes" },
            {
                "data": "timeExecuted",
                "render": function (data) {
                    let date = new Date(data);
                    return data ? moment(date).format('DD/MM/YYYY HH:mm:ss') : '';
                }
            },
        ],
        "order": [[3, "desc"]],
        "language": {
            "emptyTable": "Không có hoạt động nào có sẵn",
            "lengthMenu": "Hiển thị _MENU_ hoạt động mỗi trang",
            "zeroRecords": "Không tìm thấy hoạt động nào",
            "info": "Hiển thị trang _PAGE_ trên _PAGES_",
            "infoEmpty": "Hiển thị trang 0 trên 0",
            "infoFiltered": "(đã lọc từ tất cả _MAX_ hoạt động)",
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
                "sortAscending": ": Sắp xếp tăng dần",
                "sortDescending": ": Sắp xếp giảm dần"
            }
        },
        "stateSave": true,
        "pagingType": "full_numbers"
    });
    $('#search-log').validate({
        rules: {
            dateExecuted: {
                required: true
            },
        },
        messages: {
            dateExecuted: {
                required: "Ngày thực hiện không thể bỏ trống."
            },
        },
        submitHandler: function () {
            t.ajax.reload();
            $('#dataTable').hide();
            t.columns.adjust().draw();
            $('#dataTable').show();
        }
    });
    $('#form-change-pwd').validate({
        rules: {
            PasswordOld: {
                required: true
            },
            PasswordNew: {
                required: true
            },
            RepPassNew: {
                required: true,
                equalTo: "#PasswordNew"
            },
        },
        messages: {
            PasswordOld: {
                required: "Mật khẩu không thể bỏ trống.",
                pattern: "Mật khẩu có từ 8-16 kí tự, bao gồm ít nhất 1 chữ in hoa và 1 chữ in thường."
            },
            PasswordNew: {
                required: "Mật khẩu không thể bỏ trống.",
                pattern: "Mật khẩu có từ 8-16 kí tự, bao gồm ít nhất 1 chữ in hoa và 1 chữ in thường."
            },
            RepPassNew: {
                required: "Mật khẩu không thể bỏ trống.",
                pattern: "Mật khẩu có từ 8-16 kí tự, bao gồm ít nhất 1 chữ in hoa và 1 chữ in thường.",
                equalTo: "Nhập lại mật khẩu không khớp"
            },
        }
    });
});