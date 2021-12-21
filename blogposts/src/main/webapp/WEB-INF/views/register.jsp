<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Blog Posts</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>


	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container" style="float: right;">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/blogposts/home">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">About</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Register</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/blogposts/login">Login</a></li>
			</ul>
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="text" placeholder="Search">
				<button class="btn btn-success" type="submit">Search</button>
			</form>
		</div>
	</nav>



	<div class="container">
		<h1>Register</h1>
		<form action="/blogposts/register" method="POST">
			<div class="form-group">
				<label for="username">UserName:</label> <input type="username"
					class="form-control" id="username" placeholder="Username"
					name="username">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Password"
					name="password">
			</div>
			<div class="form-group">
				<label for="fullname">FullName:</label> <input type="fullname"
					class="form-control" id="fullname" placeholder="Fullname"
					name="fullname">
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
			<p style="color:red;">${message}</p>
		</form>
	</div>



</body>

</html>