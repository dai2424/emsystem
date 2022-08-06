package com.jit.emsystemapi.controller;


import com.jit.emsystemapi.service.LoginService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.login.LoginParam;
import com.jit.emsystemapi.vo.param.login.RegisterParam;
import com.jit.emsystemapi.vo.param.login.TeacherLoginParam;
import com.jit.emsystemapi.vo.param.login.UpDataPasswordParam;
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

    @PostMapping("updatePassword")
    public Result updatePassword(@RequestBody UpDataPasswordParam upDataPasswordParam) {
        return loginService.upDataPassword(upDataPasswordParam);
    }

    @PostMapping("teacherLogin")
    public Result teacherLogin(@RequestBody TeacherLoginParam teacherLoginParam){
        return loginService.teacherLogin(teacherLoginParam);
    }
}
