function getParameter(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
//alert("The URL of this page is: " + window.location.href);
var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
        $('#btn-sign').on('click', function () {
            _this.sign();
        });
        $('#btn-find').on('click', function () {
                    _this.find();
        });
    },
    find : function () {
            var keyword = $('#keyword').val();
            window.location.href = '/search/'+keyword;
            alert('검색되었습니다.');
        },
    sign : function () {
        var data = {
            id: $('#id').val(),
            name: $('#name').val(),
            password: $('#password').val(),
            email: $('#email').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/user',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    save : function () {
        var num = window.location.href;
        num = num.slice(-1);
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
            boardnumber: num,
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            if(num==1) {
                window.location.href = '/';
            }
            else{
                window.location.href = '/board2';
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val(),
            boardnumber: $('#boardnumber').val(),
        };
        var id = $('#id').val();
        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};
console.log("s");
var main2 = {
    init : function () {
        var _this = this;
        $('#rbtn-save').on('click', function () {
            _this.save();
        });

        $('#rbtn-update').on('click', function () {
            _this.update();
        });

        $('#rbtn-delete').on('click', function () {
            _this.delete();
        });
        $('#btn-find2').on('click', function () {
                    _this.find();
        });
    },
     find : function () {
        var keyword = $('#keyword').val();
        window.location.href = '/board2/search/'+keyword;
        alert('검색되었습니다.');
    },
    save : function () {
        var data = {
            content: $('#rcontent').val(),
            author: $('#rauthor').val(),
            boardId: $('#id').val(),
        };
        console.log(data);
        $.ajax({
            type: 'POST',
            url: '/api/v1/reply',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('댓글이 등록되었습니다.');
            window.location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            content: $('#rcontent').val()
        };
        var id = $('#id').val();
        $.ajax({
            type: 'PUT',
            url: '/api/v1/reply/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('댓글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/reply/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('댓글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};
main.init();
main2.init();