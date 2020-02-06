$(document).ready(function () {
    $('#dateExecuted').datetimepicker({
        timepicker: false,
        datepicker: true,
        format: 'd/m/Y',
        weeks: false
    });
    $('#toggle1').on('click', function () {
        $('#dateExecuted').datetimepicker('toggle')
    });
    $.fn.dataTable.moment('DD/MM/YYYY HH:mm:ss');
    var t = $('#dataTable').DataTable({
        "ajax": {
            url: "/ActivityLog/LoadAllActivityLog",
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
                "visible": false
            },
            { "data": "actType" },
            {
                "data": function (row) {
                    let sp = document.createElement("span");
                    sp.setAttribute("class", "longDes");
                    sp.setAttribute("id", row.actLogId);
                    sp.setAttribute("data-toggle", "tooltip");
                    sp.setAttribute("data-placement", "top");
                    sp.setAttribute("title", row.longDes);
                    sp.innerHTML = row.shortDes;
                    return sp.outerHTML;
                }
            },
            { "data": "username" },
            { "data": "name" },
            { "data": "role" },
            {
                "data": "timeExecuted",
                "render": function (data) {
                    let date = new Date(data);
                    return data ? moment(date).format('DD/MM/YYYY HH:mm:ss') : '';
                }
            },
        ],
        "order": [[6, "desc"]],
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
    $('body').tooltip({ selector: '[data-toggle="tooltip"]' });
});