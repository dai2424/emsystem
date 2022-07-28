package com.jit.emsystemapi.vo.support;

import lombok.Data;

@Data
public class SupportGradeVo {

    private String typeEncoding;

    private String gradeNum;

    public SupportGradeVo(String typeEncoding) {
        this.typeEncoding = typeEncoding;
        this.gradeNum = null;
    }
}
