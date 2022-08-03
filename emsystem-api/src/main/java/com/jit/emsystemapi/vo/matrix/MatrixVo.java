package com.jit.emsystemapi.vo.matrix;

import lombok.Data;

@Data
public class MatrixVo {
    private String courseNo;

    private String pointContent;

    private String supportNum;

    private String pointId;

    private String courseName;

    public MatrixVo(String courseNo, String tpContent, Integer supportDegree, String tpId, String cname) {
            this.courseNo = courseNo;
            this.pointContent = tpContent;
            this.supportNum = String.valueOf(supportDegree);
            this.pointId = tpId;
            this.courseName = cname;
    }
}
