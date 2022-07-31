package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.ClassMapper;
import com.jit.emsystemapi.dao.mapper.GradeMajorMapper;
import com.jit.emsystemapi.service.GradeMajorSercive;
import com.jit.emsystemapi.service.MajorClassService;
import com.jit.emsystemapi.vo.*;
import com.jit.emsystemapi.vo.GMC.*;
import com.jit.emsystemapi.vo.param.GMC.AddClassParam;
import com.jit.emsystemapi.vo.param.GMC.AddMajorParam;
import com.jit.emsystemapi.vo.param.GMC.DeleteClassParam;
import com.jit.emsystemapi.vo.param.GMC.MajorClassParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MajorClassServiceImpl implements MajorClassService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private GradeMajorMapper gradeMajorMapper;
    @Autowired
    private GradeMajorSercive gradeMajorSercive;

    @Override
    public Result getAllMajorClass(MajorClassParam majorClassParam) {

        String gradeId = majorClassParam.getGradeSearch();

        String majorName = majorClassParam.getMajorSearch();

        String className = majorClassParam.getClassSearch();

        List<MajorClassVo> majorClassVos = classMapper.selectAllMajorClass(gradeId, majorName, className);

        return Result.success(new TableDataVo(majorClassVos),"获取成功");
    }

    @Override
    public Result getAllGrade() {
        List<String> allGrade = gradeMajorMapper.getAllGrade();

        List<GradeVo> gradeVos = new ArrayList<>();

        for (String gradeId : allGrade) {
            gradeVos.add(new GradeVo(gradeId + "级", gradeId));
        }
        return Result.success(new GradeArrayVo(gradeVos), "获取成功");
    }

    @Override
    public Result getMajorByGradeId(String gradeId) {
        List<MajorVo> majorVos = gradeMajorMapper.getMajorByGradeId(gradeId);
        return Result.success(new MajorDataVo(majorVos), "获取成功");
    }

    @Override
    public Result addMajor(AddMajorParam addMajorParam) {
        String userId = addMajorParam.getUserId();
        String gradeId = addMajorParam.getGradeId();
        List<String> majorNames = addMajorParam.getMajorArray();

        for (String majorName: majorNames) {
            if(gradeMajorSercive.selectByGradeIdMajorName(userId, gradeId, majorName) == null)
            {
                gradeMajorMapper.addMajor(gradeId, majorName);
            }
        }
        return Result.success(null, "添加成功");
    }

    @Override
    public Result addClass(AddClassParam addClassParam) {
        String gradeId = addClassParam.getGradeId();
        String majorId = addClassParam.getMajorId();
        List<String> classNames = addClassParam.getClassArray();

        if(gradeMajorMapper.selectByGradeIdMajorId(gradeId, majorId) != null)
        {
            for(String classname:classNames) {
                if(classMapper.selectClassByName(classname, majorId) == null)
                {
                    classMapper.addClassByName(majorId,classname);
                }
            }
        }
        else {
            return Result.success(null,"专业不存在！");
        }

        return Result.success(null,"添加成功");
    }

    @Override
    public Result deleteClass(DeleteClassParam deleteClassParam) {

        List<String> classIds = deleteClassParam.getClassArray();

        for(String classId : classIds) {
            if(classMapper.selectClassById(classId) != null) {
                classMapper.deleteClassById(classId);
            }
        }
        return Result.success(null,"删除成功");
    }

}
