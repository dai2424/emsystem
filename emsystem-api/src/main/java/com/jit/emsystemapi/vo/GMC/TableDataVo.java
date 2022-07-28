package com.jit.emsystemapi.vo.GMC;

import com.jit.emsystemapi.vo.GMC.MajorClassVo;
import lombok.Data;

import java.util.List;

@Data
public class TableDataVo {
    private List<MajorClassVo> tableData;

    public TableDataVo(List<MajorClassVo> majorClassVos) {
        this.tableData = majorClassVos;
    }
}
