package com.jit.emsystemapi.vo.login;

import lombok.Data;

@Data
public class LoginResult {

    private String username;

    private String token;

    private String userId;

    public LoginResult(String username, String token, String userId) {
        this.username = username;
        this.token = token;
        this.userId = userId;
    }
}
