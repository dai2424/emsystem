package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.GradeMajorService;
import com.jit.emsystemapi.service.TargetPointService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.GMC.GetGradeMajorParam;
import com.jit.emsystemapi.vo.param.viewachievement.ViewClassParam;
import com.jit.emsystemapi.vo.param.viewachievement.ViewMajorParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class ViewController {
    @Autowired
    private GradeMajorService gradeMajorService;
    @Autowired
    private TargetPointService targetPointService;

    @PostMapping("getGradeMajor")
    public Result getGradeMajor(@RequestBody GetGradeMajorParam getGradeMajorParam) {
        return gradeMajorService.getGradeMajor(getGradeMajorParam);
    }

    @PostMapping("viewMajorAchievement")
    private Result viewMajorAchievement(@RequestBody ViewMajorParam viewMajorParam){
        return targetPointService.viewMajorAchievement(viewMajorParam);
    }

    @PostMapping("viewClassAchievement")
    private Result viewClassAchievement(@RequestBody ViewClassParam viewClassParam){
        return targetPointService.viewClassAchievement(viewClassParam);
    }

}
