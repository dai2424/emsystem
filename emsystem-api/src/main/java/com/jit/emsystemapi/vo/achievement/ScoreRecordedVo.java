package com.jit.emsystemapi.vo.achievement;

import lombok.Data;

@Data
public class ScoreRecordedVo {
    private String teacherNo;

    private String teacherName;

    private String courseNo;

    private String courseName;

    private String teacherClass;

    private String arrangeNum;

    private String classId;

    private Boolean status;

    public ScoreRecordedVo(String tNo, String tName, String cNo, String cName, String className, Integer arrangeTerm, Boolean status, Integer classId) {
        this.teacherNo = tNo;
        this.teacherName = tName;
        this.courseNo = cNo;
        this.courseName = cName;
        this.teacherClass = className;
        this.arrangeNum = String.valueOf(arrangeTerm);
        this.status = status;
        this.classId = String.valueOf(classId);
    }
}
