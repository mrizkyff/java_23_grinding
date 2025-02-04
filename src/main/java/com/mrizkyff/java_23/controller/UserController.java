package com.mrizkyff.java_23.controller;

import com.mrizkyff.java_23.dto.UserRequestDto;
import com.mrizkyff.java_23.dto.UserResponseDto;
import com.mrizkyff.java_23.model.User;
import com.mrizkyff.java_23.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        return new UserResponseDto().builder()
                .id(String.valueOf(user.getId()))
                .fullName(user.getFullName())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    @GetMapping("")
    public Page<UserResponseDto> getUsers(Pageable pageable) {
        Page<User> users = userService.getAllUsers(pageable);
        return users.map(user -> new UserResponseDto().builder()
                .id(String.valueOf(user.getId()))
                .fullName(user.getFullName())
                .email(user.getEmail())
                .username(user.getUsername())
                .build());
    }
}
