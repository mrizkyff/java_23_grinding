package com.mrizkyff.java_23.service.impl;

import com.mrizkyff.java_23.model.User;
import com.mrizkyff.java_23.repository.UserRepository;
import com.mrizkyff.java_23.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String name, String email, String password, String username) {
        User newUser = new User();

        newUser.setFullName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setUsername(username);

        return userRepository.save(newUser);
    }
}
