package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.TargetPointService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.targetpoint.AddTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.DeleteTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.EditTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.GetAllTP;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class TargetPointController {
    @Autowired
    private TargetPointService targetPointService;

    @PostMapping("addTargetPoint")
    public Result addTargetPoint(@RequestBody AddTPParam addTPParam) {
        return targetPointService.addTargetPoint(addTPParam);
    }

    @PostMapping("editTargetPoint")
    public Result editTargetPoint(@RequestBody EditTPParam editTPParam) {
        return targetPointService.editTargetPoint(editTPParam);
    }

    @PostMapping("deleteTargetPoint")
    public Result deleteTargetPoint(@RequestBody DeleteTPParam deleteTPParam) {
        return targetPointService.deleteTargetPoint(deleteTPParam);
    }

    @PostMapping("getAlltarget")
    public Result getAlltarget(@RequestBody GetAllTP getAllTP) {
        return targetPointService.getAllTarget(getAllTP);
    }
}
