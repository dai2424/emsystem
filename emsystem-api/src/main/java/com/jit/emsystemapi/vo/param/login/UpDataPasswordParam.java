package com.jit.emsystemapi.vo.param.login;


import lombok.Data;

@Data
public class UpDataPasswordParam {
    private String username;

    private String password;

    private String newPassword;
}
