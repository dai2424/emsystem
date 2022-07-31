package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.MajorClassService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.GMC.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class MajorController {

    @Autowired
    private MajorClassService majorClassService;

    @PostMapping("getAllMajorClass")
    public Result getAllMajorClass(@RequestBody MajorClassParam majorClassParam)
    {
        return majorClassService.getAllMajorClass(majorClassParam);
    }

    @PostMapping("getMajor")
    public Result getMajorByGradeId(@RequestBody GetMajorParam getMajorParam)
    {
        return majorClassService.getMajorByGradeId(getMajorParam);
    }

    @PostMapping("getAllGrade")
    public Result getAllGrade(@RequestBody GetAllgrade getAllgrade ){
        return majorClassService.getAllGrade(getAllgrade);
    }

    @PostMapping("addMajor")
    public Result addMajor(@RequestBody AddMajorParam addMajorParam)
    {
        return majorClassService.addMajor(addMajorParam);
    }

    @PostMapping("addClass")
    public Result addClass(@RequestBody AddClassParam addClassParam)
    {
        return majorClassService.addClass(addClassParam);
    }

    @PostMapping ("deleteClass")
    public Result deleteClass(@RequestBody DeleteClassParam deleteClassParam)
    {
        return majorClassService.deleteClass(deleteClassParam);
    }
}
