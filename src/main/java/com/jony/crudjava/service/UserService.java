package com.jony.crudjava.service;

import com.jony.crudjava.model.User;
import com.jony.crudjava.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Iterable<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    //public User findUserById(Long id) throws UsernameNotFoundException {
    //    Optional<User> userOptional = userRepository.findById(id);
    //    if(userOptional.isEmpty()){
    //        throw new UsernameNotFoundException("Usuário não encontrado");
    //    }
    //    return userOptional.get();
    //}

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
