package com.jit.emsystemapi.vo.curriculum;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GMCVo {
    private List<GVo> options;

    public GMCVo() {
        this.options = new ArrayList<>();
    }
}
