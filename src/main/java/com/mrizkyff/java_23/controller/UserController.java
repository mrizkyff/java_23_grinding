package com.mrizkyff.java_23.controller;

import com.mrizkyff.java_23.dto.UserRequestDto;
import com.mrizkyff.java_23.dto.UserResponseDto;
import com.mrizkyff.java_23.model.User;
import com.mrizkyff.java_23.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public UserResponseDto createUserWithGet(@RequestBody UserRequestDto userRequestDto) {
        User newUser = userService.registerUser(userRequestDto.getFullName(), userRequestDto.getEmail(), userRequestDto.getPassword(), userRequestDto.getUsername());
        return new UserResponseDto().builder()
                .id(String.valueOf(newUser.getId()))
                .fullName(newUser.getFullName())
                .email(newUser.getEmail())
                .username(newUser.getUsername())
                .build();
    }
}
