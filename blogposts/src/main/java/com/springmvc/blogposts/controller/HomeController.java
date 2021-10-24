package com.springmvc.blogposts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.blogposts.model.Posts;
import com.springmvc.blogposts.service.PostsService;

@Controller
public class HomeController {
	@Autowired
	private PostsService postsService;

	@RequestMapping(value = { "/", "/home" })
	public String home(@RequestParam(name = "id", required = false) Integer id, Model model) {
		if (id != null) {
			List<Posts> listPost = new ArrayList<>();
			listPost.add(postsService.findById(id));
			model.addAttribute("listPosts", listPost);
		} else {
			model.addAttribute("listPosts", postsService.findAll());
		}

		return "home";
	}

	@RequestMapping("/postdetails")
	public String postDetails(@RequestParam("id") int id, Model model) {
		model.addAttribute("post", postsService.findById(id));
		return "postdetails";
	}

	@RequestMapping("/search")
	public String search(@RequestParam(name = "id") int id, Model model) {
		model.addAttribute("post", postsService.findById(id));
		return "home";
	}
}
