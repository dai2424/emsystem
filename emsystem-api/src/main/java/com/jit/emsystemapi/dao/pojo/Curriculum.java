package com.jit.emsystemapi.dao.pojo;

import lombok.Data;

@Data
public class Curriculum {
    private Integer userId;

    private String tNo;

    private Integer classId;

    private Integer majorId;

    private String courseNo;

    private Integer arrangeTerm;
}
