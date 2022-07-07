package com.jit.emsystemapi.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Sysuser {

    @TableId(type = IdType.AUTO)
    private Integer Id;

    private String username;

    private String password;

    public Sysuser(String username, String password) {
        this.password = password;
        this.username = username;
    }
}
