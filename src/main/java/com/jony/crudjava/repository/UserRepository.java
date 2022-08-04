package com.jony.crudjava.repository;

import com.jony.crudjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // User findByUser(@Param("id") Long id);
}
