package com.jit.emsystemapi.vo.curriculum;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 年级id
 * 年级名
 * 年级下的专业
 */

@Data
public class GVo {
    private String label;

    private String value;

    private List<MVo> children;

    public GVo() {
        this.children = new ArrayList<>();
    }
}
