package com.jit.emsystemapi.vo.param.trainingplan;

import lombok.Data;

@Data
public class AddPlanParam {
    private String userId;

    private String courseNo;

    private String courseName;

    private String creditHour;

}
