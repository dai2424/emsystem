package com.jit.emsystemapi.vo.param.targetpoint;

import lombok.Data;

import java.util.List;

@Data
public class RecordParam {
    private String userId;

    private String courseNo;

    private String classId;

    private List<TPoint> tps;
}
