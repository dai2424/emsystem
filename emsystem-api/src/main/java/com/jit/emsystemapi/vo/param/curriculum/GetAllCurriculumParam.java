package com.jit.emsystemapi.vo.param.curriculum;

import lombok.Data;

@Data
public class GetAllCurriculumParam {
    private String userId;

    private String teacherName;

    private String courseName;

    private String arrangeNum;
}
