package com.jit.emsystemapi.vo.GMC;

import lombok.Data;

@Data
public class ViewMajorVo {
    private String value;

    private String label;

    public ViewMajorVo(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
