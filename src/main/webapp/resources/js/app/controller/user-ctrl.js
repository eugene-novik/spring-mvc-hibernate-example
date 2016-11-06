$(function () {

    var userCtrl = (function () {
        var users;
        var methods = {
            init: function () {
                this.showUser();
                this.bindEvents();
            },
            showUser: function () {
                UserService.loadUsers(function (data) {
                    users = data;
                    render(users);
                });
            },
            bindEvents: function () {
                $('#container').delegate('button.remove', 'click', function () {
                    var id = this.getAttribute("user-id");
                    UserService.removeUser(id, removePanel('panel' + id));
                });

                $('#addUser').submit(function (e) {
                    e.preventDefault();

                    UserService.addUser($(this).serialize(), render);
                });
            }

        };

        function createPanel(name, id) {
            var $panel = $('<div>', {class: 'panel panel-default', id: 'panel' + id});
            var $body = $('<div>', {class: 'panel-body'});
            var $content = $('<a>', {href: "/../Sample/user?user_id=" + id});
            var $button = $('<button>', {type: "button", class: "close remove"});
            var $symbol = String.fromCharCode(215);
            var $span = $('<span aria-hidden="true">');

            $span.append($symbol);

            $button.append($span);
            $button.attr("user-id", id);

            $content.append(name);

            $body.append($content);
            $body.append($button);

            $panel.append($body);
            return $panel;
        }

        function render(users) {
            users.forEach(function (user) {
                var panel = createPanel(user.firstName + " " + user.lastName, user.id);
                $('#container').append(panel);
            });
        }

        function removePanel(id) {
            $('#' + id).remove();
        }

        return methods;
    }());

    userCtrl.init();

});