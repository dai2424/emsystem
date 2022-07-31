package com.jit.emsystemapi.vo.param.GMC;

import lombok.Data;

import java.util.List;

@Data
public class AddMajorParam {
    private String userId;

    private String gradeId;

    private List<String> majorArray;
}
