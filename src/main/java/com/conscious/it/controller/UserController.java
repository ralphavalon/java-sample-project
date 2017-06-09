package com.conscious.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conscious.it.model.User;
import com.conscious.it.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAll() {
		return "home";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(Model model, User user) {
		userService.save(user);
		model.addAttribute("user", user);
		return "success";
	}
	

}