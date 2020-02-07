function setMarkInput() {
    let selectedOption = $('#CategoryAdd').children("option:selected");
    let minMark = selectedOption.data("min");
    let maxMark = selectedOption.data("max")
    $('#MarkAdd').attr({
        "max": maxMark,
        "min": minMark,
        "value": minMark,
    });
    $("label[for='MarkAdd']").html("<strong>Điểm (" + minMark + " - " + maxMark + ")</strong>");
};
function setMarkInputUpdt(oldValue) {
    let selectedOption = $('#CategoryUpdt').children("option:selected");
    let minMark = selectedOption.data("min");
    let maxMark = selectedOption.data("max")
    $('#MarkUpdt').attr({
        "max": maxMark,
        "min": minMark,
        "value": minMark > oldValue ? minMark : oldValue,
    });
    $("label[for='MarkUpdt']").html("<strong>Điểm (" + minMark + " - " + maxMark + ")</strong>");
};
function resetForm() {
    $('#ContentAdd').val("");
};
$(document).ready(function () {
    $.datetimepicker.setLocale('vi');
    $('#TimeBroadcastAdd').datetimepicker({
        timepicker: false,
        datepicker: true,
        format: 'd/m/Y',
        weeks: false
    });
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
    $('#CategoryAdd').on('change', function () {
        setMarkInput();
    });
    setMarkInput();
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
                "visible": false
            },
            {
                "data": "timeBroadcast",
                "render": function (data) {
                    let date = new Date(data);
                    return data ? moment(date).format('DD/MM/YYYY') : '';
                }
            },
            {
                "data": "editorMark"
            },
            {
                "data": "marker"
            },
            {
                "data": "managerMark",
                "visible": false
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
        "order": [[6, "desc"]],
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
            }
        },
        "stateSave": true,
        "pagingType": "full_numbers"
    });
    $('#dataTable tbody').on('click', '.updtArticle', function () {
        let x = $(this);
        $('#CategoryUpdt').val($(this).data("category"));
        setMarkInputUpdt(x.data("editorMark"));
        $('#CategoryUpdt').on('change', function () {
            setMarkInputUpdt(x.data("editorMark"));
        });
        $('#ArticleIdUpdt').val($(this).data("id"));
        console.log($('#ArticleIdUpdt').val());
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
    function createArticle() {
        let obj = {
            ArticleId: "A" + new Date().getTime(),
            Content: $('#ContentAdd').val(),
            CategoryId: $('#CategoryAdd').val(),
            EditorMark: parseInt($('#MarkAdd').val()),
            ManagerMark: 1,
            Status: 0,
            Executor: $('#ExecutorAdd').val(),
            TimeBroadcast: $('#TimeBroadcastAdd').val(),
            Marker: "",
        }
        $.ajax({
            type: "POST",
            url: "/Article/InsertArticle",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(obj),
            success: function (result) {
                if (result === "") {
                    showMessage("Tạo tin bài thành công");
                    resetForm();
                    t.ajax.reload();
                } else {
                    showMessage(result);
                }
            }
        });
    }
    function updateArticle() {
        let obj = {
            ArticleId: $('#ArticleIdUpdt').val(),
            Content: $('#ContentUpdt').val(),
            CategoryId: $('#CategoryUpdt').val(),
            EditorMark: parseInt($('#MarkUpdt').val()),
            ManagerMark: 1,
            Status: 0,
            Executor: $('#ExecutorUpdt').val(),
            TimeBroadcast: $('#TimeBroadcastUpdt').val(),
            Marker: "",
        }
        $.ajax({
            type: "POST",
            url: "Article/UpdateArticle",
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
    $('#form-article-add').validate({
        rules: {
            ContentAdd: {
                required: true
            },
            TimeBroadcastAdd: {
                required: true,
                maxlength: 10
            },
            MarkAdd: {
                required: true
            },
        },
        messages: {
            ContentAdd: {
                required: "Nội dung tin bài không thể bỏ trống.",
                pattern: "Nội dung tin bài có 1 - 400 kí tự."
            },
            TimeBroadcastAdd: {
                required: "Ngày phát sóng không thể bỏ trống.",
                maxlength: "Ngày phát sóng có format dd/mm/yyyy."
            },
            MarkAdd: {
                required: "Điểm không được bỏ trống",
                min: "Điểm lớn hơn hoặc bằng {0}",
                max: "Điểm nhỏ hơn hoặc bằng {0}",
                step: "Điểm không có phần thập phân",
                number: "Vui lòng nhập số"
            }
        },
        submitHandler: function () {
            createArticle();
        }
    });
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