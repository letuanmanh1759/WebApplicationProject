package com.springmvc.blogposts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(@RequestParam(name = "error", required = false) String error, Model model) {
		if(error != null) {
			model.addAttribute("message", error);
		}
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication athentication = SecurityContextHolder.getContext().getAuthentication();
		if(athentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, athentication);
		}
		return "home";
	}
}
