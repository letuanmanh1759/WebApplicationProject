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
	List<Post> posts = postDao.search(" ");
	for (Post post : posts) {
	%>
	<section>
		<div>
			<a href="http://localhost:8080//postdetails?id=<%= String.valueOf(post.getId())%>">
				<h2><%=post.getTitle()%></h2> <br />
				<h3><%=post.getDescription()%></h3>
			</a><br />
			<p>
				Posted by <%=post.getAuthor().getFirstName()%> <%=post.getAuthor().getLastName()%> on <%=DateUtil.format(post.getDate(), BaseConstants.PATTERM_MONTH_DAY_YEAR)%> 8 mins read
			</p>
			<br />
            <div style="margin-left:90%;">
                <a href="http://localhost:8080//postedit?id=<%= String.valueOf(post.getId())%>"> <button type="button">Edit</button></a>
            </div>
		</div>
		<hr />
	</section>

	<%
	}
	%>

	<div class="div">
		<a class="btn" href="/home.jsp">VIEW ALL POSTS</a>
	</div>

	<jsp:include page="/footer.jsp" />



</body>

</html>