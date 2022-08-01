package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.TrainingPlanService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.trainingplan.AddPlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.DeletePlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.EditPlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.GetAllPlanParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class PlanController {
    @Autowired
    private TrainingPlanService trainingPlanService;

    @PostMapping("addPlan")
    public Result addPlan(@RequestBody AddPlanParam addPlanParam) {
        return trainingPlanService.addPlan(addPlanParam);
    }

    @PostMapping("editPlan")
    public Result editPlan(@RequestBody EditPlanParam editPlanParam) {
        return trainingPlanService.editPlanParam(editPlanParam);
    }

    @PostMapping("deletePlan")
    public Result deletePlan(@RequestBody DeletePlanParam deletePlanParam) {
        return trainingPlanService.deletePlan(deletePlanParam);
    }

    @PostMapping("getAllPlan")
    public Result getAllPlan(@RequestBody GetAllPlanParam getAllPlanParam) {
        return trainingPlanService.getAllPlan(getAllPlanParam);
    }
}
