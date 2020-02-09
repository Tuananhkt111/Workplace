function setMarkInputUpdt(oldEditorValue, oldManagerValue) {
    let selectedOption = $('#CategoryUpdt').children("option:selected");
    let minMark = selectedOption.data("min");
    let maxMark = selectedOption.data("max");
    let initValue = oldManagerValue !== "_" ? oldManagerValue : oldEditorValue;
    if (minMark > initValue) {
        initValue = minMark;
    } else if (maxMark < initValue) {
        initValue = maxMark;
    }
    $('#MarkUpdt').attr({
        "max": maxMark,
        "min": minMark,
        "value": initValue,
    });
    $("label[for='MarkUpdt']").html("<strong>Điểm (" + minMark + " - " + maxMark + ")</strong><strong>BTV chấm: " + oldEditorValue + "</strong>");
};
$(document).ready(function () {
    $.datetimepicker.setLocale('vi');
    $('#timeSearch').datetimepicker({
        timepicker: false,
        format: 'm/Y',
        onChangeMonth: function (cur, $i) {
            $('#timeSearch').val(moment(new Date(cur)).format("MM/YYYY"));
        },
        weeks: false
    });
    $('#toggle1').on('click', function () {
        $('#timeSearch').datetimepicker('toggle')
    });
});
$(document).ready(function () {
    $.fn.dataTable.moment('DD-MM-YYYY');
    var t = $('#dataTable').DataTable({
        "ajax": {
            url: "/Article/LoadAllArticlesByMonth",
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
                data: null,
                defaultContent: "",
                "orderable": false,
                "searchable": false,
                "className": "select-checkbox",
            },
            {
                "data": "articleId",
                "visible": false,
            },
            {
                "data": "content",
                "render": function (data) {
                    let dataDiv = document.createElement("div");
                    dataDiv.classList = "truncate";
                    dataDiv.setAttribute("data-toggle", "tooltip");
                    dataDiv.setAttribute("data-placement", "top");
                    dataDiv.setAttribute("title", data);
                    dataDiv.innerHTML = data;
                    return dataDiv.outerHTML;
                }
            },
            {
                "data": "categoryId",
                "visible": false
            },
            {
                "data": "categoryName",
                "render": function (data) {
                    let dataDiv = document.createElement("div");
                    dataDiv.classList = "truncate";
                    dataDiv.setAttribute("data-toggle", "tooltip");
                    dataDiv.setAttribute("data-placement", "top");
                    dataDiv.setAttribute("title", data);
                    dataDiv.innerHTML = data;
                    return dataDiv.outerHTML;
                }
            },
            {
                "data": "executor"
            },
            {
                "data": "status",
                "visible": true
            },
            {
                "data": "timeBroadcast",
                "render": function (data) {
                    let date = new Date(data);
                    return data ? moment(date).format('DD/MM/YYYY') : '';
                }
            },
            {
                "data": "marker"
            },
            {
                "data": "editorMark"
            },
            {
                "data": "managerMark",
                "visible": true
            },
            {
                "data": function (row) {
                    let linkDiv = document.createElement("div");
                    let editLink = document.createElement("a");
                    let br = document.createElement("span");
                    br.innerHTML = "/";
                    editLink.setAttribute("data-toggle", "modal");
                    editLink.href = 'javascript: void (0)';
                    editLink.setAttribute("data-target", "#modalUpdtArticleForm");
                    editLink.setAttribute("data-id", row.articleId);
                    editLink.setAttribute("data-category", row.categoryId);
                    editLink.setAttribute("data-content", row.content);
                    editLink.setAttribute("data-executor", row.executor);
                    editLink.setAttribute("data-time-broadcast", row.timeBroadcast);
                    editLink.setAttribute("data-editor-mark", row.editorMark);
                    editLink.setAttribute("data-manager-mark", row.managerMark);
                    editLink.setAttribute("data-marker", row.marker);
                    editLink.setAttribute("data-id", row.articleId);
                    editLink.setAttribute("class", "updtArticle");
                    editLink.style = "cursor: pointer";
                    editLink.innerHTML = "Chỉnh sửa";
                    let deleteLink = document.createElement("a");
                    deleteLink.href = 'javascript: void (0)';
                    deleteLink.setAttribute("class", "delArticle");
                    deleteLink.setAttribute("data-id", row.articleId);
                    deleteLink.style = "cursor: pointer";
                    deleteLink.innerHTML = "Xóa";
                    linkDiv.appendChild(editLink);
                    linkDiv.appendChild(br);
                    linkDiv.appendChild(deleteLink);
                    return linkDiv.outerHTML;
                }
            }
        ],
        "select": {
            "style": "os",
            "selector": "td:first-child"
        },
        "aaSorting": [[7, "desc"], [6, "asc"]],
        "language": {
            "emptyTable": "Không có tin bài nào có sẵn",
            "lengthMenu": "Hiển thị _MENU_ tin bài mỗi trang",
            "zeroRecords": "Không tìm thấy tin bài nào",
            "info": "Hiển thị trang _PAGE_ trên _PAGES_",
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
            },
            "select": {
                "rows": {
                    "_": "%d hàng đã chọn",
                    "0": "",
                    "1": "%d hàng đã chọn"
                }
            }
        },
        "stateSave": true,
        "pagingType": "full_numbers"
    });
    function approveAll() {
        let selectedRows = t.rows({ selected: true }).data();
        let ids = [];
        for (var i = 0; i < selectedRows.length; i++) {
            ids.push(selectedRows[i].articleId);
        }
        if (ids.length > 0) {
            $.ajax({
                type: "POST",
                url: "/Article/ApproveAll",
                dataType: "json",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(ids),
                success: function (result) {
                    if (result === "") {
                        showMessage("Duyệt các tin bài thành công");
                        t.ajax.reload();
                        $('#approveBtn').prop("disabled", true);
                        $('#selectBtn').prop("checked", false);
                    } else {
                        showMessage(result);
                        $('#approveBtn').prop("disabled", true);
                    }
                }
            });
        }
    };
    $('#approveBtn').on('click', function () {
        approveAll();
    });
    $("#selectBtn").on("click", function (e) {
        let indexes = t.rows().eq(0).filter(function (rowIdx) {
            return t.cell(rowIdx, 6).data() === 'Chưa duyệt' ? true : false;
        });
        if ($(this).is(":checked")) {
            t.rows(indexes).select();

        } else {
            t.rows().deselect();
            $('#approveBtn').prop("disabled", true);
        }
    });
    $('body').on('DOMSubtreeModified', '#dataTable_info', function () {
        let selectedRows = t.rows({ selected: true }).data();
        if (selectedRows.length > 0)
            $('#approveBtn').prop("disabled", false);
        else {
            t.rows().deselect();
            $('#approveBtn').prop("disabled", true);
        }
    })
    $('#dataTable tbody').on('click', '.updtArticle', function () {
        let x = $(this);
        $('#CategoryUpdt').val($(this).data("category"));
        setMarkInputUpdt(x.data("editorMark"), x.data("managerMark"));
        $('#CategoryUpdt').on('change', function () {
            setMarkInputUpdt(x.data("editorMark"), x.data("managerMark"));
        });
        $('#ArticleIdUpdt').val($(this).data("id"));
        $('#ContentUpdt').val($(this).data("content"));
        $('#ExecutorUpdt').val($(this).data("executor"));
        let date = new Date($(this).data("time-broadcast"));
        let dateValue = moment(date).format('DD/MM/YYYY');
        $('#TimeBroadcastUpdt').val(dateValue);
        $('#TimeBroadcastUpdt').datetimepicker({
            timepicker: false,
            datepicker: true,
            format: 'd/m/Y',
            weeks: false,
            defaultDate: dateValue
        });
    });
    $('#dataTable tbody').on('click', '.delArticle', function () {
        let id = $(this).data("id");
        $("#confirmDeleteModal").modal("show");
        $('#delArticleBtn').on('click', function () {
            deleteArticle(id);
        });
    });
    function updateArticle() {
        let obj = {
            ArticleId: $('#ArticleIdUpdt').val(),
            Content: $('#ContentUpdt').val(),
            CategoryId: $('#CategoryUpdt').val(),
            EditorMark: 1,
            ManagerMark: parseInt($('#MarkUpdt').val()),
            Status: 0,
            Executor: $('#ExecutorUpdt').val(),
            TimeBroadcast: $('#TimeBroadcastUpdt').val(),
            Marker: "",
        }
        $.ajax({
            type: "POST",
            url: "/Article/UpdateArticleByManager",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    $("#modalUpdtArticleForm").modal("hide");
                    showMessage("Cập nhật tin bài thành công");
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    function deleteArticle(id) {
        $.ajax({
            type: "POST",
            url: "/Article/deleteArticle",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(id),
            success: function (result) {
                if (result === "") {
                    $("#confirmDeleteModal").modal("hide");
                    showMessage("Xóa tin bài thành công");
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    var validator_update = $('#form-acc-updt').validate({
        rules: {
            ContentUpdt: {
                required: true
            },
            TimeBroadcastUpdt: {
                required: true
            },
            MarkUpdt: {
                required: true
            },
        },
        messages: {
            ContentUpdt: {
                required: "Nội dung tin bài không thể bỏ trống.",
                pattern: "Nội dung tin bài có 1 - 400 kí tự."
            },
            TimeBroadcastUpdt: {
                required: "Ngày phát sóng không thể bỏ trống."
            },
            MarkUpdt: {
                required: "Điểm không được bỏ trống",
                min: "Điểm lớn hơn hoặc bằng {0}",
                max: "Điểm nhỏ hơn hoặc bằng {0}",
                step: "Điểm không có phần thập phân",
                number: "Vui lòng nhập số"
            }
        },
        submitHandler: function () {
            updateArticle();
        }
    });
    $('#modalUpdtArticleForm').on('click', '.close', function () {
        validator_update.resetForm();
    });
    $("#modalUpdtArticleForm").on("hidden.bs.modal", function () {
        validator_update.resetForm();
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