list = {
    findById : function (id) {
        $.ajax({
            url: '/find',
            type: 'post',
            data: JSON.stringify(id),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function (user) {
            $('#updateModal').show();
            $('#updateModal').data('id', id);
            $('#updateUserName').val(user.userName);
            $('#updateUserId').val(user.userId);
        }).fail(function () {
            console.log('fail');
        });
    },

    update : function () {
        var user = {
            id: $('#updateModal').data('id'),
            userId: $('#updateUserId').val(),
            userName: $('#updateUserName').val(),
            password: $('#updatePassword').val()
        };

        $.ajax({
            url: '/update',
            type: 'put',
            data: JSON.stringify(user),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            location.reload();
        }).fail(function () {
            alert('Please try again');
        });
    },

    deleteById : function (id) {
        $.ajax({
            url: '/delete',
            type: 'delete',
            data: JSON.stringify(id),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            location.reload();
        }).fail(function () {
            alert('Please try again');
        });
    }
}


function update() {
    list.update();
}

function deleteById(id) {
    list.deleteById(id);
}

function findById(id) {
    list.findById(id);
}