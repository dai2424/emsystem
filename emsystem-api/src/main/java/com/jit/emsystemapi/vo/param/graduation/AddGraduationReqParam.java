package com.jit.emsystemapi.vo.param.graduation;

import lombok.Data;

@Data
public class AddGraduationReqParam {
    private String userId;

    private String gradeSearch;

    private String majorSearch;

    private String contentSearch;
}
