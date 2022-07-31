package com.jit.emsystemapi.vo.param.graduation;

import lombok.Data;

@Data
public class UpdataGraduationReqParam {
    private String userId;

    private String uid;

    private String gradeSearch;

    private String majorSearch;

    private String noSearch;

    private String contentSearch;
}
