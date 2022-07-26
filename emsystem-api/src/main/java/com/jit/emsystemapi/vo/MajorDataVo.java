package com.jit.emsystemapi.vo;

import lombok.Data;

import java.util.List;

@Data
public class MajorDataVo {
    private List<MajorVo> majorData;

    public MajorDataVo(List<MajorVo> majorVos) {
        this.majorData = majorVos;
    }
}
