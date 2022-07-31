package com.jit.emsystemapi.vo.param.graduation;

import lombok.Data;

@Data
public class GetAllGraduationReqParam {
    private String userId;

    private String gradeSearch;

    private String majorSearch;

    private String noSearch;

    private String contentSearch;

}
