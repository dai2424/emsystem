package com.jit.emsystemapi.vo.curriculum;

import lombok.Data;

@Data
public class TeacherVo {
    private String label;
    private String value;

    public TeacherVo(String label, String name) {
        this.value = name + " " + label;
        this.label = label;
    }
}
