package com.jit.emsystemapi.vo.param.teachar;

import lombok.Data;

@Data
public class AddTeacherParam {
    private String userId;

    private String teacherName;

    private String teacherNo;

    private String teacherPassword;
}
