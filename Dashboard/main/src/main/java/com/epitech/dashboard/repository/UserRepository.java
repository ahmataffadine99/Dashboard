package com.epitech.dashboard.repository;

import com.epitech.dashboard.Models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

}
