package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.LoginParam;
import com.jit.emsystemapi.vo.param.RegisterParam;

public interface LoginService {
    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);


    Result register(RegisterParam registerParam);
}
