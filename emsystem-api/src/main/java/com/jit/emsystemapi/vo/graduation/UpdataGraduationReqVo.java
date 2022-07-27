package com.jit.emsystemapi.vo.graduation;

import lombok.Data;

@Data
public class UpdataGraduationReqVo {
    private String gradeId;

    private String majorName;

    private String noSearch;

    private String contentSearch;

    private String uid;

    public UpdataGraduationReqVo(String gradeId, String majorName, String noSearch, String contentSearch, String uid) {
        this.gradeId = gradeId;
        this.majorName = majorName;
        this.noSearch = noSearch;
        this.contentSearch = contentSearch;
        this.uid = uid;
    }
}
