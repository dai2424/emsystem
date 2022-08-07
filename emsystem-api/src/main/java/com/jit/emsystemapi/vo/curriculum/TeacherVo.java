package com.jit.emsystemapi.vo.curriculum;

import lombok.Data;

@Data
public class TeacherVo {
    private String value;
    private String label;

    public TeacherVo(String value, String name) {
        this.value = value;
        this.label = name + " " + value;
    }
}
