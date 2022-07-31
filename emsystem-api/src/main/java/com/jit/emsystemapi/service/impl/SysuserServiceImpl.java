package com.jit.emsystemapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jit.emsystemapi.dao.mapper.SysuserMapper;
import com.jit.emsystemapi.dao.pojo.Sysuser;
import com.jit.emsystemapi.service.SysuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysuserServiceImpl implements SysuserService {
    @Autowired
    private SysuserMapper sysuserMapper;

    @Override
    public Sysuser findSysuser(String username, String password) {
        LambdaQueryWrapper<Sysuser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Sysuser::getUsername, username);
        queryWrapper.eq(Sysuser::getPassword, password);
        queryWrapper.select(Sysuser::getUsername, Sysuser::getPassword, Sysuser::getUserId);
        queryWrapper.last("limit 1");
        return  sysuserMapper.selectOne(queryWrapper);
    }

    @Override
    public Sysuser findSysuserByUsername(String username) {
        LambdaQueryWrapper<Sysuser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Sysuser::getUsername, username);
        queryWrapper.select(Sysuser::getUsername, Sysuser::getPassword, Sysuser::getUserId);
        queryWrapper.last("limit 1");
        return sysuserMapper.selectOne(queryWrapper);
    }

    @Override
    public void save(Sysuser sysuser) {
        sysuserMapper.insert(sysuser);
    }
}
