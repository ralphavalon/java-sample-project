package com.conscious.it.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conscious.it.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

}