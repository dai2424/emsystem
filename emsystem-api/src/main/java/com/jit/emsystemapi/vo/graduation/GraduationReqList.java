package com.jit.emsystemapi.vo.graduation;

import lombok.Data;

import java.util.List;

@Data
public class GraduationReqList {
    private List<GraduationReqVo> tableData;

    public GraduationReqList(List<GraduationReqVo> tableData) {
        this.tableData = tableData;
    }
}
