package com.jit.emsystemapi.vo;

import lombok.Data;

@Data
public class MajorVo {
    private String label;

    private String id;

    public MajorVo(String label, String id) {
        this.label = label;
        this.id = id;
    }
}
