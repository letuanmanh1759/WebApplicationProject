<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ page import="com.nt.rookie.post.domain.Post"%>
<%@ page import="com.nt.rookie.post.common.DateUtil"%>
<%@ page import="com.nt.rookie.post.common.BaseConstants"%>
<%@ page import="com.nt.rookie.post.data.PostDao"%>
<%@ page import="com.nt.rookie.post.data.DaoFactory"%>
<html>

<head>
<title>Blog Posts</title>
<link rel="stylesheet" href="/view/css/header.css">
<link rel="stylesheet" href="/view/css/reset.css">
<link rel="stylesheet" href="/view/css/body.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/view/css/footer.css">
</head>

<body>

	<jsp:include page="/header.jsp" />

	<%
	PostDao postDao = DaoFactory.getPostDao();
	int id = (int) session.getAttribute("id");
	Post post = postDao.find(id);
	%>
	<section>
		<div>

			<h2><%=post.getTitle()%></h2>
			<br />
			<h3><%=post.getDescription()%></h3>
			<br />
			<p>
				<%=post.getContent()%>
			</p>
		</div>
		<hr />
	</section>



	<div class="div">
		<a class="btn" href="/home.jsp">VIEW ALL POSTS</a>
	</div>

	<jsp:include page="/footer.jsp" />



</body>

</html>