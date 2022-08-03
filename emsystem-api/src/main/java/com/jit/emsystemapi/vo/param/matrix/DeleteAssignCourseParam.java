package com.jit.emsystemapi.vo.param.matrix;

import lombok.Data;

@Data
public class DeleteAssignCourseParam {
    private String userId;

    private String courseName;

    private String pointId;
}
