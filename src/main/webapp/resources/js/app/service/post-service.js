var PostService = (function () {

    var methods = {
        loadPost: function (id, callback) {
            $.ajax({
                url: "/../Sample/api/post/" + id,
                method: "get",
                success: function (data) {
                    callback(data);
                },
                error: function () {
                    console.error("cannot load posts");
                }
            });
        },
        removePost: function (id, callback) {
            $.ajax({
                url: "/../Sample/api/post/" + id,
                method: "delete",
                success: function (data) {
                    callback();
                },
                error: function () {
                    console.error("cannot remove post");
                }
            });
        },
        addPost: function (userId, name, callback) {
            $.ajax({
                url: "/../Sample/api/post/" + userId + "/" + name,
                method: "post",
                success: function (data) {
                    var users = [];
                    users.push(data);
                    callback(users);
                },
                error: function () {
                    console.error("cannot add post");
                }
            });
        }
    };


    return methods;

}());
