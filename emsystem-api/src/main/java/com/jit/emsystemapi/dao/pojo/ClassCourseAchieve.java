package com.jit.emsystemapi.dao.pojo;

import lombok.Data;

@Data
public class ClassCourseAchieve {
    private Integer userId;

    private String tNo;

    private Integer classId;

    private Integer majorId;

    private String courseNo;

    private Integer arrangeTerm;

    private Integer tpId;

    private Integer achievement;
}
