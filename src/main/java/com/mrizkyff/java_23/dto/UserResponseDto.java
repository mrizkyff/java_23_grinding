package com.mrizkyff.java_23.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String id;
    private String username;
    private String email;
    private String fullName;
}
