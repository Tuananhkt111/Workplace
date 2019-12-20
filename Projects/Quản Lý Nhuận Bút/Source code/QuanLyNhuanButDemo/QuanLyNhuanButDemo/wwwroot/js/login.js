$(function () {
    $('#form-login').validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            },
        },
        messages: {
            username: {
                required: "Tên đăng nhập không thể bỏ trốngg.",
                pattern: "Tên đăng nhập có tối đa 30 kí tự, chỉ bao gồm chữ số và chữ cái."
            },
            password: {
                required: "Mật khẩu không thể bỏ trống.",
                pattern: "Mật khẩu có từ 8-16 kí tự, bao gồm ít nhất 1 chữ in hoa và 1 chữ in thường."
            },
        }
    });
});