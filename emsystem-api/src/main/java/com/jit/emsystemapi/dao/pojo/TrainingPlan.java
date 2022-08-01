package com.jit.emsystemapi.dao.pojo;

import lombok.Data;

@Data
public class TrainingPlan {
    private Integer userId;

    private String courseNo;

    private String courseName;

    private Integer creditHour;

    private Integer arrangeTerm;
}
