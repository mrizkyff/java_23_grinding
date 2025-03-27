package com.mrizkyff.java_23.service.impl;

import com.mrizkyff.java_23.model.User;
import com.mrizkyff.java_23.repository.UserRepository;
import com.mrizkyff.java_23.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        newUser.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        newUser.setUsername(username);
        newUser.setCreatedBy(UUID.randomUUID());

        return userRepository.save(newUser);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
