var UserService = (function () {

    var methods = {
        loadUsers: function (callback) {
            $.ajax({
                url: "/../Sample/api/user/",
                method: "get",
                success: function (data) {
                    callback(data);
                },
                error: function () {
                    console.error("cannot load users");
                }
            });
        },
        removeUser: function (id, callback) {
            $.ajax({
                url: "/../Sample/api/user/" + id,
                method: "delete",
                success: function (data) {
                    callback();
                },
                error: function () {
                    console.error("cannot remvoe user");
                }
            });
        },
        addUser: function (data, callback) {
            $.ajax({
                url: "/../Sample/api/user/",
                method: "post",
                data: data,
                success: function (data) {
                    var users = [];
                    users.push(data);
                    callback(users);
                },
                error: function () {
                    console.error("cannot add user");
                }
            });
        }
    };

    return methods;

}());
