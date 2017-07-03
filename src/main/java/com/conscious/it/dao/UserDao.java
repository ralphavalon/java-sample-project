package com.conscious.it.dao;

import org.springframework.data.repository.CrudRepository;

import com.conscious.it.model.User;

public interface UserDao extends CrudRepository<User, Integer> {

}