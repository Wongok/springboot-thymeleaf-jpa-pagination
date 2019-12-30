function signup() {
    var user = {
        userName : $('#userName').val(),
        userId : $('#userId').val(),
        password : $('#password').val()
    };

    $.ajax({
        url: '/signup',
        type: 'post',
        data: JSON.stringify(user),
        dataType: 'json',
        contentType: 'application/json; charset=utf-8'
    }).done(function (id) {
        location.href="/list";
        findById(id);
    }).fail(function () {
        console.log('fail');
    });
}

function findById(id) {
    $.ajax({
        url: '/find',
        type: 'post',
        data: JSON.stringify(id),
        dataType: 'json',
        contentType: 'application/json; charset=utf-8'
    }).done(function (user) {
        $('#userLoginId').val(user.userId);
    }).fail(function () {
        console.log('fail');
    });
}