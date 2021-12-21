<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Blog Posts</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>


    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container" style="float: right;">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/blogposts/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/blogposts/register">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Login</a>
                </li>
            </ul>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="text" placeholder="Search">
                <button class="btn btn-success" type="submit">Search</button>
            </form>
        </div>
    </nav>



    <div class="container">
        <h1>Login</h1>
        <form action="/blogposts/login" method='POST'>
            <div class="form-group">
                <label for="username">UserName:</label>
                <input type="username" class="form-control" id="username" placeholder="Username" name="username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="password">
            </div>
            <div class="form-group form-check">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="remember"> Remember me
                </label>
            </div>
            <p style="color:red;">${message}</p>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>



</body>

</html>