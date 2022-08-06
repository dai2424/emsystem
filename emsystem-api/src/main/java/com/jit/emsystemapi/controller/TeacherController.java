package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.TeacherService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.teachar.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("addTeacher")
    public Result addTeacher(@RequestBody AddTeacherParam addTeacherParam) {
        return teacherService.addTeacher(addTeacherParam);
    }

    @PostMapping("editTeacher")
    public Result editTeacher(@RequestBody EditTeacherParam editTeacherParam) {
        return teacherService.editTeacher(editTeacherParam);
    }

    @PostMapping("deleteTeacher")
    public Result deleteTeacher(@RequestBody DeleteTeacherParam deleteTeacherParam) {
        return teacherService.deleteTeacher(deleteTeacherParam);
    }

    @PostMapping("getAllTeacher")
    public Result getAllTeacher(@RequestBody GetAllTeacher getAllTeacher) {
        return teacherService.getAllTeacher(getAllTeacher);
    }

    @PostMapping("editStatus")
    public Result editStatus(@RequestBody EditStatusParam editStatusParam) {
        return teacherService.editStatus(editStatusParam);
    }
}
