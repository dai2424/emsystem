package com.jit.emsystemapi.vo.param;

import lombok.Data;

import java.util.List;

@Data
public class AddMajorParam {
    private String gradeId;

    private List<String> majorArray;
}
