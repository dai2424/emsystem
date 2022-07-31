package com.jit.emsystemapi.vo.param.GMC;

import lombok.Data;

import java.util.List;

@Data
public class AddClassParam {
    private String userId;

    private String gradeId;

    private String majorId;

    private List<String> classArray;
}
