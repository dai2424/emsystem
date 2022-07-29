package com.jit.emsystemapi.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.jit.emsystemapi.dao.mapper.SysuserMapper;
import com.jit.emsystemapi.dao.pojo.Sysuser;
import com.jit.emsystemapi.service.LoginService;
import com.jit.emsystemapi.service.SysuserService;
import com.jit.emsystemapi.utils.JWTUtils;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.login.LoginParam;
import com.jit.emsystemapi.vo.login.LoginResult;
import com.jit.emsystemapi.vo.param.login.RegisterParam;
import com.jit.emsystemapi.vo.param.login.UpDataPasswordParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysuserService sysUserService;

    @Autowired
    private SysuserMapper sysuserMapper;

    private static final String slat = "@jit";
    @Override
    public Result login(LoginParam loginParam) {
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return  Result.fail(400, "参数错误！");
        }

        password = DigestUtils.md5Hex(password + slat);

        Sysuser sysUser = sysUserService.findSysuser(username, password);

        if(sysUser == null) {
            return Result.fail(400,"用户不存在！");
        }

        String userId = String.valueOf(sysUser.getId());
        String token = JWTUtils.createToken(Long.valueOf(sysUser.getId()));

        return Result.success(new LoginResult(username, token, userId), "登录成功！");
    }

    @Override
    public Result register(RegisterParam registerParam) {
        String username = registerParam.getUsername();
        String password = registerParam.getPassword();

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return  Result.fail(400, "参数错误!");
        }
        Sysuser sysuser = sysUserService.findSysuserByUsername(username);

        if(sysuser != null) {
            return Result.fail(422, "用户已存在！！！");
        }
        password = DigestUtils.md5Hex(password + slat);

        sysuser = new Sysuser(username, password);

        sysUserService.save(sysuser);

        return Result.success(username,"注册成功");
    }

    @Override
    public Result upDataPassword(UpDataPasswordParam upDataPasswordParam) {
        String password = upDataPasswordParam.getPassword();
        String newPassword = upDataPasswordParam.getNewPassword();
        String username = upDataPasswordParam.getUsername();

        password = DigestUtils.md5Hex(password + slat);
        newPassword = DigestUtils.md5Hex(newPassword + slat);
        if(ObjectUtils.isEmpty(sysuserMapper.findUserByNamePass(username, password))) {
            return Result.success(null, "用户不存在，或原密码错误");
        }

        sysuserMapper.updatePassword(username, password, newPassword);

        return Result.success(null, "修改成功");
    }

//    public static void main(String[] args) {
//        System.out.println(DigestUtils.md5Hex("admin@jit"));
//    }
}
