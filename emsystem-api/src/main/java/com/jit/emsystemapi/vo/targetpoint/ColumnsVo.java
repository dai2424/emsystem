package com.jit.emsystemapi.vo.targetpoint;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ColumnsVo {
    private List<TpVo> points;

    private List<FieldVo> column;

    public ColumnsVo() {
        this.column = new ArrayList<>();
        this.points = new ArrayList<>();
    }
}
