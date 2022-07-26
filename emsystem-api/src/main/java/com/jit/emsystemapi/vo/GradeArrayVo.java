package com.jit.emsystemapi.vo;

import lombok.Data;

import java.util.List;

@Data
public class GradeArrayVo {
    private List<GradeVo> gradeArray;

    public GradeArrayVo(List<GradeVo> gradeArray) {
        this.gradeArray = gradeArray;
    }
}
