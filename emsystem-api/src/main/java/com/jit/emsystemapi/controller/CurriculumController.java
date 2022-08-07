package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.CurriculumService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.curriculum.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class CurriculumController {
    @Autowired
    private CurriculumService curriculumService;

    @PostMapping("getGradeMajorClass")
    public Result getGradeMajorClass(@RequestBody GetGMCParam getGMCParam) {
        return curriculumService.getGradeMajorClass(getGMCParam);
    }

    @PostMapping("getTeacherId")
    public Result getTeacherId(@RequestBody GetTeacherIdParam getTeacherIdParam) {
        return curriculumService.getTeacherId(getTeacherIdParam);
    }

    @PostMapping("addCurriculum")
    public Result addCurriculum(@RequestBody AddCurriculumParam addCurriculumParam) {
        return curriculumService.addCurriculum(addCurriculumParam);
    }

    @PostMapping("getAllCurriculum")
    public Result getAllCurriculum(@RequestBody GetAllCurriculumParam getAllCurriculumParam){
        return curriculumService.getAllCurriculum(getAllCurriculumParam);
    }

    @PostMapping("deleteCurriculum")
    public Result deleteCurriculum(@RequestBody DeleteCurriculumParam deleteCurriculumParam){
        return curriculumService.deleteCurriculum(deleteCurriculumParam);
    }
}
