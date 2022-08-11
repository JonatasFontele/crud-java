package com.jony.crudjava.controller;

import com.jony.crudjava.model.User;
import com.jony.crudjava.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class) // To make this a full Spring test that creates the Spring context
@WebMvcTest(UserController.class) // To give us the ability to mock our HTTP requests.
class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetById() throws Exception {
        User user = new User().withId(1L).withName("Batsu");

        when(userService.findUserById(1L)).thenReturn(Optional.ofNullable(user));

        ResultActions result = mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Batsu"));

        // "verify" statement ensures that the Controller invokes the Service to get this value.
        verify(userService).findUserById(1L);
    }

    @Test
    public void testGetByIdNotFound() throws Exception {
        when(userService.findUserById(1L)).thenThrow(new UsernameNotFoundException("Usuário não encontrado"));

        ResultActions result = mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isNotFound());

        verify(userService).findUserById(1L);
    }
}