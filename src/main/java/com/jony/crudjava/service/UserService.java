package com.jony.crudjava.service;

import com.jony.crudjava.model.User;
import com.jony.crudjava.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findById(long id) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return userOptional.get();
    }

}
