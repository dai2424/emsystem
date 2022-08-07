package com.jit.emsystemapi.vo.param.curriculum;

import lombok.Data;

@Data
public class DeleteCurriculumParam {
    private String userId;

    private String teacherNo;

    private String classId;

    private String courseNo;
}
