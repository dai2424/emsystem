package com.jit.emsystemapi.vo.param.trainingplan;

import lombok.Data;

import java.util.List;

@Data
public class DeletePlanParam {
    private String userId;

    private List<String> courseArray;
}
