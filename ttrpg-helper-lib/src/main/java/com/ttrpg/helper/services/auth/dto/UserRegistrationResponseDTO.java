package com.ttrpg.helper.services.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistrationResponseDTO {
    private String username;
    private String email;
    private String token;
    private String message;
}
