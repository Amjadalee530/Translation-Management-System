package com.test.translation_management_service.userDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

