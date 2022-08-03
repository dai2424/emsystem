package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.SupportMatrixService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.matrix.AssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.DeleteAssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.EditAssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.GetAllCourseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class MatrixController {

    @Autowired
    private SupportMatrixService supportMatrixService;

    @PostMapping("assignCourse")
    public Result assignCourse(@RequestBody AssignCourseParam assignCourseParam) {
        return supportMatrixService.assignCourse(assignCourseParam);
    }

    @PostMapping("editAssignCourse")
    public Result editAssignCourse(@RequestBody EditAssignCourseParam editAssignCourseParam) {
        return supportMatrixService.editAssignCourse(editAssignCourseParam);
    }

    @PostMapping("deleteAssignCourse")
    public Result deleteAssignCourse(@RequestBody DeleteAssignCourseParam deleteAssignCourseParam) {
        return supportMatrixService.deleteAssignCourse(deleteAssignCourseParam);
    }


    @PostMapping("getAllCourse")
    public Result getAllCourse(@RequestBody GetAllCourseParam getAllCourseParam) {
        return supportMatrixService.getAllCourse(getAllCourseParam);
    }
}
