package com.nt.rookie.post.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.rookie.post.data.DaoFactory;
import com.nt.rookie.post.data.PostDao;
import com.nt.rookie.post.domain.Post;

@SuppressWarnings("serial")
public class PostEditServlet extends HttpServlet {

	PostDao postDao = DaoFactory.getPostDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("PostEditServlet::" + id);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		Post post = postDao.find(id);

		HttpSession session = request.getSession();
		session.setAttribute("post", post);
		String encodeRedirectURL = response.encodeURL("/postedit.jsp");
		response.sendRedirect(encodeRedirectURL);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String newTitle = request.getParameter("title");
		String newDescription = request.getParameter("description");
		String newContent = request.getParameter("content");
		System.out.println("PostEditServlet::" + id);
		Post newPost = new Post();
		newPost.setId(id);
		newPost.setTitle(newTitle);
		newPost.setDescription(newDescription);
		newPost.setContent(newContent);
		postDao.update(newPost);

		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		String encodeRedirectURL = response.encodeURL("/posteditresult.jsp");
		response.sendRedirect(encodeRedirectURL);
	}
}