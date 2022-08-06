package com.jit.emsystemapi.dao.pojo;

import lombok.Data;

@Data
public class Teacher {
    private Integer userId;

    private String tNo;

    private String tName;

    private String tPassword;

    private Boolean status;
}
