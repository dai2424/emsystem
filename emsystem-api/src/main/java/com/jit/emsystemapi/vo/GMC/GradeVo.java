package com.jit.emsystemapi.vo.GMC;

import lombok.Data;

@Data
public class GradeVo {
    private String label;

    private String id;

    public GradeVo(String label, String id) {
        this.label = label;
        this.id = id;
    }
}
