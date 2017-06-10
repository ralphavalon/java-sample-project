package com.conscious.it.service;


import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ObjectArrayArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.conscious.it.model.User;

@DisplayName("Testing the logic of UserService")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@BeforeEach
	public void setUp() {
		List<User> userList = userService.getAll();
		if(userList.size() < 2) {
			userService.save(userOne());
			userService.save(userTwo());
		}
	}
	
	@DisplayName("Testing parameterized users")
	@ParameterizedTest
	@MethodSource(names="createUsers")
	public void testParameterizedUser(User user, Integer id) {
		Assertions.assertEquals(user, userService.getById(id));
	}
	
	@DisplayName("Testing exception")
	@Test
	public void testException() {
		Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { userService.getAll().get(15); });
		Assertions.assertEquals("Index: 15, Size: 2", exception.getMessage());
	}
	
	protected static Stream<Arguments> createUsers() {
	    return Stream.of(
	            ObjectArrayArguments.create(userOne(), 1),
	            ObjectArrayArguments.create(userTwo(), 2)
        );
	}
	
	private static User userOne() {
		User user = new User();
		user.setId(1);
		user.setName("First User");
		user.setAge(20);
		user.setCity("Rio de Janeiro");
		return user;
	}
	
	private static User userTwo() {
		User user = new User();
		user.setId(2);
		user.setName("Second User");
		user.setAge(70);
		user.setCity("Calgary");
		return user;
	}

}
