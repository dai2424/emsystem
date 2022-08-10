package com.jit.emsystemapi.vo.GMC;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ViewGMVo {
    private List<GradeViewVo> options;

    public ViewGMVo() {
        this.options = new ArrayList<>();
    }
}
