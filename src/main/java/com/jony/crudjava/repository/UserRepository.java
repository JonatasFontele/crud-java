package com.jony.crudjava.repository;

import com.jony.crudjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<User> findUserByName(String name);
}
