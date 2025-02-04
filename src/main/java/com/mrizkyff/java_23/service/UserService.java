package com.mrizkyff.java_23.service;

import com.mrizkyff.java_23.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    User registerUser(String name, String email, String password, String username);

    User getUserById(String id);

    Page<User> getAllUsers(Pageable pageable);
}
