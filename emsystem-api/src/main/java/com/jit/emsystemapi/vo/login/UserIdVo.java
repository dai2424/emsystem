package com.jit.emsystemapi.vo.login;

import lombok.Data;

@Data
public class UserIdVo {
    private String userId;

    public UserIdVo(Integer userId) {
        this.userId = String.valueOf(userId);
    }
}
