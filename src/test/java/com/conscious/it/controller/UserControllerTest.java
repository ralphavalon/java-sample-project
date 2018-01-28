package com.conscious.it.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.conscious.it.model.User;
import com.conscious.it.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void shouldPrintTheUserNameAfterCreated() throws Exception {
        doNothing().when(userService).save(any(User.class) );
        mockMvc.perform(
        		post("/create")
        		.contentType(MediaType.APPLICATION_FORM_URLENCODED)
        		.param("name", "Ralph")
        		.param("birthdate", "18/04/1992")
        		.param("city", "Rio de Janeiro")
        		.param("email", "myemail@email.com")
        		.param("password", "123456")
        		.param("gender", "MALE")
    		)
        	.andDo(print())
        	.andExpect(status().isOk())
            .andExpect(content().string(containsString("<span>User</span> <span>Ralph</span> <span>added with success</span>")));
    }

}
