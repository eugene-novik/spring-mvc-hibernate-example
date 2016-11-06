$(function () {

    var PostCtrl = (function () {
        var posts;
        var methods = {
            init: function () {
                this.showUser();
                this.bindEvents();
            },
            showUser: function () {
                var userId = getUrlParam("user_id");
                PostService.loadPost(userId, function (data) {
                    posts = data;
                    render(posts);
                });
            },
            bindEvents: function () {
                $('#container').delegate('button.remove', 'click', function () {
                    var id = this.getAttribute("post-id");
                    PostService.removePost(id, removePanel('panel' + id));
                });

                $('#addPost').submit(function (e) {
                    e.preventDefault();
                    var userId = getUrlParam("user_id");
                    var name = $("#name").val();
                    PostService.addPost(userId, name, render);
                });

            }

        };

        function createPanel(name, id) {
            var $panel = $('<div>', {class: 'panel panel-default', id: 'panel' + id});
            var $body = $('<div>', {class: 'panel-body'});
            var $content = $('<div>', {class: 'col-md-11'});
            var $button = $('<button>', {type: "button", class: "close remove"});
            var $symbol = String.fromCharCode(215);
            var $span = $('<span aria-hidden="true">');

            $span.append($symbol);

            $button.append($span);
            $button.attr("post-id", id);

            $content.append(name);

            $body.append($content);
            $body.append($button);

            $panel.append($body);
            return $panel;
        }

        function render(posts) {
            posts.forEach(function (post) {
                var panel = createPanel(post.name, post.id);
                $('#container').append(panel);
            });
        }

        function removePanel(id) {
            $('#' + id).remove();
        }

        function getUrlParam(name) {
            var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
            return results[1] || 0;
        }

        return methods;
    }());

    PostCtrl.init();

});