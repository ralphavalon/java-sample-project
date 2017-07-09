package com.conscious.it.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        		.param("age", "25")
        		.param("city", "Rio de Janeiro")
    		)
        	.andDo(print())
        	.andExpect(status().isOk())
            .andExpect(content().string(containsString("User <span>Ralph</span> added with success.")));
    }

}
