package com.mrizkyff.java_23.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String username;
    private String email;
    private String password;
    private String fullName;
}
