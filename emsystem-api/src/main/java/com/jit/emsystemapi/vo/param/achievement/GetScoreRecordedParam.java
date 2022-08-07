package com.jit.emsystemapi.vo.param.achievement;

import lombok.Data;

@Data
public class GetScoreRecordedParam {
    private String userId;

    private String teacherName;

    private String courseName;

    private String arrangeNum;
}
