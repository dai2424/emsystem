package com.jit.emsystemapi.vo.param.achievement;

import lombok.Data;

@Data
public class GetTeacherScoreRecordedParam {
    private String userId;

    private String teacherNo;

    private String courseName;

    private String arrangeNum;
}
