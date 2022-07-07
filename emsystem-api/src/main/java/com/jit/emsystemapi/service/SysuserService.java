package com.jit.emsystemapi.service;

import com.jit.emsystemapi.dao.pojo.Sysuser;

public interface SysuserService {

    Sysuser findSysuser(String sysUserNumber, String sysUserPassword);

    Sysuser findSysuserByUsername(String username);

    void save(Sysuser sysuser);
}
