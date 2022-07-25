package com.jit.emsystemapi.vo;

import lombok.Data;

import java.util.List;

@Data
public class tableDataVo {
    private List<MajorClassVo> tableData;

    public tableDataVo(List<MajorClassVo> majorClassVos) {
        this.tableData = majorClassVos;
    }
}
