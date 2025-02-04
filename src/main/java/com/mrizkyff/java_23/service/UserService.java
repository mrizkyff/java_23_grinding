package com.mrizkyff.java_23.service;

import com.mrizkyff.java_23.model.User;

public interface UserService {
    User registerUser(String name, String email, String password, String username);
}
