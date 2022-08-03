package com.jony.crudjava.repository;

import com.jony.crudjava.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
