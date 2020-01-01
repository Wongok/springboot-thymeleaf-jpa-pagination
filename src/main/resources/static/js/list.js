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

    update : function (page) {
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
            location.href="/list?page=" + page;
        }).fail(function () {
            alert('Please try again');
        });
    },

    deleteById : function (id, totalElements, size, page) {
        $.ajax({
            url: '/delete',
            type: 'delete',
            data: JSON.stringify(id),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            if(totalElements % size === 1) {
                location.href="/?page=" + page;
            }else {
                page++;
                location.href="/?page=" + page;
            }
        }).fail(function () {
            alert('Please try again');
        });
    }
}


function update(page) {
    list.update(page);
}

function deleteById(id, totalElements, size, page) {
    list.deleteById(id, totalElements, size, page);
}

function findById(id) {
    list.findById(id);
}