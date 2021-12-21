package com.springmvc.blogposts.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.blogposts.service.AuthorsService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AuthorsService authorsService;

	@RequestMapping("/listusers")
	public String posts(Model model) {

		model.addAttribute("listUsers", authorsService.findAll());
		return "admin";
	}

}
