package com.springmvc.blogposts.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.blogposts.model.Authors;
import com.springmvc.blogposts.service.AuthorsService;

@Controller
public class RegisterController {

	private static final Logger logger = Logger.getLogger(RegisterController.class);
	@Autowired
	AuthorsService authorService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleRegister(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("fullname") String fullname, Model model) {

		Authors author = new Authors();
		author.setUsername(username);
		author.setPassword(password);
		author.setFullName(fullname);
		author.setJoinedDate(Date.valueOf(LocalDate.now()));
		author.setRoleCode(6);
		author.setEnabled(1);
		authorService.insertAuthor(author);
		model.addAttribute("message", "Sign Up Success");

		return "register";
	}

}
