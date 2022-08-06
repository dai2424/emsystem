package com.jit.emsystemapi.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.jit.emsystemapi.dao.mapper.TeacherMapper;
import com.jit.emsystemapi.dao.pojo.Teacher;
import com.jit.emsystemapi.service.TeacherService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.teachar.*;
import com.jit.emsystemapi.vo.teacher.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Result addTeacher(AddTeacherParam addTeacherParam) {
        String userId = addTeacherParam.getUserId();
        String teacherNo = addTeacherParam.getTeacherNo();
        String teacherPassword = addTeacherParam.getTeacherPassword();
        String teacherName = addTeacherParam.getTeacherName();

        if(StringUtils.isBlank(teacherPassword)) {
            teacherPassword = "JIT" + teacherNo;
        }

        if(teacherMapper.selectByNo(userId, teacherNo) == null) {
            teacherMapper.addTeacher(userId, teacherNo, teacherName, teacherPassword);
        }
        else {
            return Result.success(null, "教师号已存在");
        }
        return Result.success(null, "添加成功");
    }

    @Override
    public Result editTeacher(EditTeacherParam editTeacherParam) {
        String userId = editTeacherParam.getUserId();
        String teacherNo = editTeacherParam.getTeacherNo();
        String teacherPassword = editTeacherParam.getTeacherPassword();

        if(teacherMapper.selectByNo(userId, teacherNo) != null) {
            teacherMapper.editPassword(userId, teacherNo, teacherPassword);
        }
        else {
            return Result.success(null,"教师号不存在");
        }

        return Result.success(null,"修改成功");
    }

    @Override
    public Result deleteTeacher(DeleteTeacherParam deleteTeacherParam) {
        String userId = deleteTeacherParam.getUserId();
        String teacherNo = deleteTeacherParam.getTeacherNo();

        int cnt = teacherMapper.deleteTeacher(userId, teacherNo);

        return Result.success(null, "删除" + cnt + "条");
    }

    @Override
    public Result getAllTeacher(GetAllTeacher getAllTeacher) {
        String userId = getAllTeacher.getUserId();
        String teacherNo = getAllTeacher.getTeacherNo();
        String teacherName = getAllTeacher.getTeacherName();

        List<TeacherVo> teacherVos = teacherMapper.selectTeachers(userId, teacherNo, teacherName);
        return Result.success(teacherVos, "查询成功");
    }

    @Override
    public Result editStatus(EditStatusParam editStatusParam) {
        String userId = editStatusParam.getUserId();
        String teacherNo = editStatusParam.getTeacherNo();
        boolean status = Boolean.parseBoolean(editStatusParam.getStatus());

        if(teacherMapper.selectByNo(userId, teacherNo) != null) {
            teacherMapper.editStatus(userId, teacherNo, status);
        }
        else {
            Result.success(null, "用户不存在");
        }

        return Result.success(null, "修改成功");
    }

}
