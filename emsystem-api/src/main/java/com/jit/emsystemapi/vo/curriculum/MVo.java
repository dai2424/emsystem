package com.jit.emsystemapi.vo.curriculum;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 专业id
 * 专业名
 * 专业下的班级
 */
@Data
public class MVo {
    private String value;

    private String label;

    private List<CVo> children;

    public MVo() {
        this.children = new ArrayList<>();
    }
}
