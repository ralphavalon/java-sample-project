package com.conscious.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conscious.it.model.User;
import com.conscious.it.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public User create(User user) {
		userService.save(user);
		return user;
	}
	

}