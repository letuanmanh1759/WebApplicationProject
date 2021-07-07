package com.nt.rookie.post.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.rookie.post.data.DaoFactory;
import com.nt.rookie.post.data.PostDao;
import com.nt.rookie.post.domain.Post;

@SuppressWarnings("serial")
public class SearchPostServlet extends HttpServlet {
	PostDao postDao = DaoFactory.getPostDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchTerm = request.getParameter("searchTerm");
		//
		List<Post> posts = postDao.searchByAnythingOfPost(searchTerm);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("posts", posts);
		String encodeRedirectURL = response.encodeURL("/searchpost.jsp");
		response.sendRedirect(encodeRedirectURL);
		
	}

}
