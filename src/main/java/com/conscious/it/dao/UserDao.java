package com.conscious.it.dao;

import java.util.ArrayList;
import java.util.List;

import com.conscious.it.model.User;

public class UserDao {
	
	static List<User> users = new ArrayList<User>();
	static int i = 0;
	
	public void save(User user) {
		user.setId(++i);
		users.add(user);
	}
	
	public List<User> getAll() {
		return users;
	}
	
	public User getById(Integer id) {
		for (User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

}