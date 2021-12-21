package com.springmvc.blogposts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.blogposts.service.PostsService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	PostsService postsService;

	@RequestMapping("/posts")
	public String posts(Model model) {
		Authentication athentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("listPosts", postsService.findByUsername(athentication.getName()));
		return "user";
	}

}
