package com.jony.crudjava.service;

import com.jony.crudjava.model.User;
import com.jony.crudjava.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Test
    public void getUserById() throws Exception {
        UserService userService = new UserService(userRepository);

        Optional<User> user = Optional.of(new User().withId(1L).withName("Batsu"));

        when(userRepository.findById(1L)).thenReturn(user);

        Optional<User> foundUser = userService.findUserById(1L);

        assertThat(foundUser).isEqualTo(user.get());

        verify(userRepository).findById(1L);

    }

    @Test
    public void getCatByIdNotFound() {
        UserService userService = new UserService(userRepository);

        Optional<User> user = Optional.empty();

        when(userRepository.findById(1L)).thenReturn(user);

        assertThrows(UsernameNotFoundException.class, () -> {
            Optional<User> foundUser = userService.findUserById(1L);
        });

        verify(userRepository).findById(1L);
    }

}