package com.andi.twitter.controller;

import com.andi.twitter.model.User;
import com.andi.twitter.service.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.RequestEntity.get;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerShouldTest {
    public static final String JSON_CONTEXT_TYPE = "application/json";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService service;

    @Test void returnUserWhenGetById() throws Exception{
        User user = new User();

        user.setId("drew");
        user.setEmail("raa@gmail.com");
        user.setFirstname("Andi");
        user.setLastname("Robu");
        user.setPassword("pass");

//        mockMvc.perform(get("/users/drew")) TODO
//                .andExpect(status().isOk())
//                .andExpect(content()
//                                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect()

    }

    @Test
    void postUser() {
    }

    @Test
    void deleteUserById() {
    }
}