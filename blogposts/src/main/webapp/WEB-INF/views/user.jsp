<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
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
			<security:authorize access="hasRole('ROLE_USER')">
				<security:authentication property="principal" var="user" />
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active disabled"
						href="#"> Wellcome, ${user.username}</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/blogposts/logout">Logout</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/blogposts/home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/blogposts/user/posts">MyPost</a></li>

				</ul>

			</security:authorize>
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="text" placeholder="Search">
				<button class="btn btn-success" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h1>MyPosts</h1>

		<div class="container">
			<div class="row">
				<c:if test="${not empty listPosts}">
					<c:forEach var="post" items="${listPosts}">
						<div class="col-sm-4">
							<a class="nav-link" style="color: black;"
								href="/blogposts/postdetails?id=${post.id}">
								<h3>${post.title}</h3>
							</a>
							<p>${post.description}</p>
							<hr />
						</div>
					</c:forEach>
				</c:if>

			</div>

		</div>
</body>

</html>