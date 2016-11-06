<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring 4 MVC</title>
    <link rel='stylesheet' href='<c:url value="/resources/css/bootstrap.min.css" />' type='text/css' media='all'/>
    <link rel='stylesheet' href='<c:url value="/resources/css/bootstrap-theme.min.css" />' type='text/css' media='all'/>
    <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-3.1.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/app/service/post-service.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/app/controller/post-ctrl.js" />"></script>
</head>
<body>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="/Sample/" class="navbar-brand">All user</a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-9" id="container">

        </div>
        <div class="col-md-3">
            <form id="addPost">
                <div class="form-group">
                    <label for="name">Post Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                </div>
                <button type="submit" class="btn btn-default">Add Post</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>