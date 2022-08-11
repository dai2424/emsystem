package com.jit.emsystemapi.vo.GMC;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GradeViewVo {
    private String value;

    private String label;

    private List<ViewMajorVo> children;

    public GradeViewVo(String value, String label) {
        this.value = value;
        this.label = label;
        this.children = new ArrayList<>();
    }
}
