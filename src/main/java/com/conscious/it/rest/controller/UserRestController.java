package com.conscious.it.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conscious.it.model.User;
import com.conscious.it.service.UserService;

@RestController
@RequestMapping("/rest")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public User create(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getById(@PathVariable("id") Integer id) {
		return userService.getById(id);
	}
	

}