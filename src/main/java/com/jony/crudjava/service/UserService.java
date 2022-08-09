package com.jony.crudjava.service;

import com.jony.crudjava.model.User;
import com.jony.crudjava.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return userOptional.get();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

}
