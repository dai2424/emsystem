package com.jit.emsystemapi.vo;

import lombok.Data;

import java.util.List;

@Data
public class TableDataVo {
    private List<MajorClassVo> tableData;

    public TableDataVo(List<MajorClassVo> majorClassVos) {
        this.tableData = majorClassVos;
    }
}
