package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.GraduationService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.graduation.AddGraduationReqParam;
import com.jit.emsystemapi.vo.param.graduation.DeleteNoParam;
import com.jit.emsystemapi.vo.param.graduation.GetAllGraduationReqParam;
import com.jit.emsystemapi.vo.param.graduation.UpdataGraduationReqParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class GraduationController {

    @Autowired
    private GraduationService graduationService;

    @PostMapping("getAllGraduationReq")
    public Result getAllGraduationReq(@RequestBody GetAllGraduationReqParam getAllGraduationReqParam) {
        return graduationService.getAllGraduationReq(getAllGraduationReqParam);
    }

    @PostMapping("deleteGraduationReq")
    public Result deleteGraduationReq(@RequestBody DeleteNoParam deleteNoParam) {
        return graduationService.deleteGraduationReq(deleteNoParam);
    }

    @PostMapping("editGraduationReq")
    public Result editGraduationReq(@RequestBody UpdataGraduationReqParam updataGraduationReqParam) {
        return graduationService.editGraduationReq(updataGraduationReqParam);
    }

    @PostMapping("addGraduationReq")
    public Result addGraduationReq(@RequestBody AddGraduationReqParam addGraduationReqParam) {
        return graduationService.addGraduationReq(addGraduationReqParam);
    }
}
