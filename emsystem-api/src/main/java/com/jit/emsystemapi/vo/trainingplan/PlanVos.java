package com.jit.emsystemapi.vo.trainingplan;

import lombok.Data;

import java.util.List;

@Data
public class PlanVos {
    private List<PlanVo> planData;

    public PlanVos(List<PlanVo> plans) {
        this.planData = plans;
    }
}
