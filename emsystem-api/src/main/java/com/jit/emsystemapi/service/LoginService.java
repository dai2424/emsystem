package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.login.LoginParam;
import com.jit.emsystemapi.vo.param.login.RegisterParam;
import com.jit.emsystemapi.vo.param.login.TeacherLoginParam;
import com.jit.emsystemapi.vo.param.login.UpDataPasswordParam;

public interface LoginService {
    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);


    Result register(RegisterParam registerParam);

    Result upDataPassword(UpDataPasswordParam upDataPasswordParam);

    Result teacherLogin(TeacherLoginParam teacherLoginParam);
}
