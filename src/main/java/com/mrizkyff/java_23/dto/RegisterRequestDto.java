// RegisterRequest.java
package com.mrizkyff.java_23.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String fullName;
    private String email;
    private String username;
    private String password;
}