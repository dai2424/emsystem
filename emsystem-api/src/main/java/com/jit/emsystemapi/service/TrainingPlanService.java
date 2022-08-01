package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.trainingplan.AddPlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.DeletePlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.EditPlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.GetAllPlanParam;

public interface TrainingPlanService {
    Result addPlan(AddPlanParam addPlanParam);

    Result editPlanParam(EditPlanParam editPlanParam);

    Result deletePlan(DeletePlanParam deletePlanParam);

    Result getAllPlan(GetAllPlanParam getAllPlanParam);
}
