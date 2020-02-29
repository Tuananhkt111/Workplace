$(document).ready(function () {
    $.datetimepicker.setLocale('vi');
    $('#timeSearch').datetimepicker({
        timepicker: false,
        format: 'm/Y',
        onChangeMonth: function (cur, $i) {
            $('#timeSearch').val(moment(new Date(cur)).format("MM/YYYY"));
        },
        weeks: false,
        scrollInput: false
    });
    $('#toggle1').on('click', function () {
        $('#timeSearch').datetimepicker('toggle')
    });
});
// Call the dataTables jQuery plugin
$(document).ready(function () {
    $.fn.dataTable.moment('DD-MM-YYYY');
    var t = $('#dataTable').DataTable({
        "ajax": {
            url: "/Article/LoadAllArticlesByReporterAndMonth",
            type: "POST",
            dataSrc: "",
            contentType: "application/json",
            dataType: "json",
            data: function () {
                return JSON.stringify($('#timeSearch').val());
            }
        },

        'columns': [
            {
                "data": "content",
                "render": function (data) {
                    let dataDiv = document.createElement("div");
                    //dataDiv.classList = "truncate";
                    dataDiv.setAttribute("data-toggle", "tooltip");
                    dataDiv.setAttribute("data-placement", "top");
                    dataDiv.setAttribute("title", data);
                    dataDiv.innerHTML = data;
                    return dataDiv.outerHTML;
                }
            },
            {
                "data": "unitType",
                "visible": false
            },
            {
                "data": "categoryName",
                "visible": false
            },
            {
                "data": function (row) {
                    let dataDiv = document.createElement("div");
                    let unit = document.createElement("p");
                    let catName = document.createElement("span");
                    //dataDiv.classList = "truncate";
                    dataDiv.setAttribute("data-toggle", "tooltip");
                    dataDiv.setAttribute("data-placement", "top");
                    dataDiv.setAttribute("title", row.categoryName);
                    catName.innerHTML = row.categoryName;
                    let unitName;
                    if (row.unitType === 0) {
                        unitName = "Truyền hình";
                        unit.setAttribute("style", "color: red");
                    }
                    else {
                        unitName = "Phát thanh";
                        unit.setAttribute("style", "color: blue");
                    }
                    unit.innerHTML = unitName;
                    dataDiv.appendChild(unit);
                    dataDiv.appendChild(catName);
                    return dataDiv.outerHTML;
                }
            },
            {
                "data": "timeBroadcast",
                "render": function (data) {
                    let date = new Date(data);
                    return data ? moment(date).format('DD/MM/YYYY') : '';
                }
            },
            {
                "data": "marker",
                "visible": false
            },
            {
                "data": "markerName",
                "visible": false
            },
            {
                "data": function (row) {
                    let dataDiv = document.createElement("div");
                    let username = document.createElement("p");
                    let name = document.createElement("p");
                    username.setAttribute("style", "color: blue");
                    //dataDiv.classList = "truncate";
                    dataDiv.setAttribute("data-toggle", "tooltip");
                    dataDiv.setAttribute("data-placement", "top");
                    dataDiv.setAttribute("title", "Tên đăng nhập: " + row.marker + ", tên: " + row.markerName);
                    username.innerHTML = row.marker;
                    name.innerHTML = row.markerName;
                    dataDiv.appendChild(username);
                    dataDiv.appendChild(name);
                    return dataDiv.outerHTML;
                }
            },
            {
                "data": "mark"
            }
        ],
        "order": [[4, "desc"]],
        "language": {
            "emptyTable": "Không có tin bài nào có sẵn",
            "lengthMenu": "Hiển thị _MENU_ tin bài mỗi trang",
            "zeroRecords": "Không tìm thấy tin bài nào",
            "info": "Hiển thị trang _PAGE_ trên _PAGES_ từ tất cả _MAX_ tin bài",
            "infoEmpty": "Hiển thị trang 0 trên 0",
            "infoFiltered": "(đã lọc từ tất cả _MAX_ tin bài)",
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
    $('#search-log').validate({
        rules: {
            timeSearch: {
                required: true,
                maxlength: 10
            },
        },
        messages: {
            timeSearch: {
                required: "Tháng không thể bỏ trống.",
                maxlength: "Tháng có format mm/yyyy."
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
