<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ page import="com.nt.rookie.post.domain.Post"%>
<%@ page import="com.nt.rookie.post.common.DateUtil"%>
<%@ page import="com.nt.rookie.post.common.BaseConstants"%>
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
	Post post = (Post) session.getAttribute("post");
	%>

	<section>
		<div>
			<form action="/postupdate" method="post">
				<label
					style="color: dimgray; font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; font-size: 30px;">Title:</label><br>
				<textarea name="title"
					style="font-size: 20px; width: 100%; height: 100%;"> <%=post.getTitle()%> </textarea>
				<br> <br> <label
					style="color: dimgray; font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; font-size: 30px;">Description:</label><br>
				<textarea name="description"
					style="font-size: 20px; width: 100%; height: 100%;"> <%=post.getDescription()%> </textarea>
				<br> <br> <label
					style="color: dimgray; font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; font-size: 30px;">Content:</label><br>
				<textarea name="content"
					style="font-size: 20px; width: 100%; height: 100%;" rows="10"> <%=post.getContent()%> </textarea>
				<br> <br> <input type="hidden" name="id"
					value="<%=String.valueOf(post.getId())%>"> <input
					type="submit" value="update">
			</form>
		</div>
		<hr />
	</section>



	<div class="div">
		<a class="btn" href="/home.jsp">VIEW ALL POSTS</a>
	</div>

	<jsp:include page="/footer.jsp" />



</body>

</html>