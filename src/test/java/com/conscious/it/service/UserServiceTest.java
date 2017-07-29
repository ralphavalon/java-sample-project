package com.conscious.it.service;


import static java.time.Duration.ofMillis;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.conscious.it.model.User;

@DisplayName("Testing the logic of UserService")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Tag("all")
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
	@MethodSource(value="createUsers")
	public void testParameterizedUser(User user, Integer id) {
		Assertions.assertEquals(user, userService.getById(id));
	}
	
	@DisplayName("Testing exception")
	@Test
	@RepeatedTest(value=2, name="{displayName} {currentRepetition}/{totalRepetitions}") //it will repeat twice, running 3 times at total
	public void testException() {
		Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { userService.getAll().get(15); });
		Assertions.assertEquals("Index: 15, Size: 2", exception.getMessage());
	}
	
	@Test
	@Tag("example")
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
		final User user = userService.getById(1);
        Assertions.assertAll("user",
            () -> Assertions.assertEquals("First User", user.getName()),
            () -> Assertions.assertEquals(new Integer(1), user.getId()),
            () -> Assertions.assertEquals(new Integer(20), user.getAge()),
            () -> Assertions.assertEquals("Rio de Janeiro", user.getCity())
        );
    }
	
	@Test
    @Disabled("For demonstration purposes")
    public void skippedTest() {
        // not executed
		Assertions.assertTrue(false);
    }
	
	@Test
	@Tag("example")
    void timeoutExceeded() {
        Assertions.assertTimeout(ofMillis(100), () -> {
            // Simulate task that takes less than 100 ms.
            Thread.sleep(99); // If more than 100, it will fail due timeout assert
        });
    }
	
	@Nested
    @DisplayName("when new")
    class WhenNew {

        @Test
        @DisplayName("whatever")
        void isNotEmpty() {
        	//do your inner tests
            Assertions.assertTrue(Boolean.TRUE);
        }
	}
	
	protected static Stream<Arguments> createUsers() {
	    return Stream.of(
	            Arguments.of(userOne(), 1),
	            Arguments.of(userTwo(), 2)
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
