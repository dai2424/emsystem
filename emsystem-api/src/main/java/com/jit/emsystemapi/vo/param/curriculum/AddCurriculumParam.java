package com.jit.emsystemapi.vo.param.curriculum;

import lombok.Data;

@Data
public class AddCurriculumParam {
    private String userId;

    private String teacherNo;

    private String classId;

    private String courseName;

    private String arrangeTerm;
}
