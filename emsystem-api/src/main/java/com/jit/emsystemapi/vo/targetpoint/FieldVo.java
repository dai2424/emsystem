package com.jit.emsystemapi.vo.targetpoint;

import lombok.Data;

@Data
public class FieldVo {
    private String label;

    private String prop;

    public FieldVo(String label, String prop) {
        this.label = label;
        this.prop = prop;
    }
}
