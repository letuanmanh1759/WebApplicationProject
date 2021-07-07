package com.nt.rookie.post.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.rookie.post.data.DaoFactory;
import com.nt.rookie.post.data.PostDao;
import com.nt.rookie.post.domain.Post;

@SuppressWarnings("serial")
public class PostDetailsServlet extends HttpServlet {
	PostDao postDao = DaoFactory.getPostDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("PostDetailsServlet::" + id);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		Post post = postDao.find(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("post", post);
		String encodeRedirectURL = response.encodeURL("/postdetail.jsp");
		response.sendRedirect(encodeRedirectURL);
		
	
	
	}
}