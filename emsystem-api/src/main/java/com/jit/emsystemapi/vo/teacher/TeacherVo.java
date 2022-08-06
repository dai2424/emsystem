package com.jit.emsystemapi.vo.teacher;

import lombok.Data;

@Data
public class TeacherVo {
    private String teacherNo;

    private String teacherName;

    private String teacherPassword;

    private boolean status;
}
