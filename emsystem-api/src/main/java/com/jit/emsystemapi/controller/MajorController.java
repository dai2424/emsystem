package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.MajorClassService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.MajorClassParam;
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
}
