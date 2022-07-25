package com.jit.emsystemapi.controller;


import com.jit.emsystemapi.service.LoginService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.LoginParam;
import com.jit.emsystemapi.vo.param.RegisterParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public Result login(@RequestBody LoginParam loginParam) {
        return loginService.login(loginParam);
    }

    @PostMapping("register")
    public Result register(@RequestBody RegisterParam registerParam) {
        return loginService.register(registerParam);
    }


}
