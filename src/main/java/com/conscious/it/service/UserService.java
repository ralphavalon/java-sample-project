package com.conscious.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conscious.it.dao.UserDao;
import com.conscious.it.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	public User getById(Integer id) {
		return userDao.getById(id);
	}
	

}