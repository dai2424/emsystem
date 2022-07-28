package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.SupportGradeService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.support.EditDataParam;
import com.jit.emsystemapi.vo.param.support.GetSupportParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class SupportGradeController {
    @Autowired
    private SupportGradeService supportGradeService;

    @PostMapping("getAllSupport")
    public Result getAllSupport(@RequestBody GetSupportParam getSupportParam) {
        return supportGradeService.getAllSupport(getSupportParam);
    }

    @PostMapping("editAllNum")
    public Result editAllNum(@RequestBody EditDataParam editDataParam) {
        return supportGradeService.editAllNum(editDataParam);
    }
}
