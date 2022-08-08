package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.ClassMapper;
import com.jit.emsystemapi.dao.mapper.GradeMajorMapper;
import com.jit.emsystemapi.service.GradeMajorSercive;
import com.jit.emsystemapi.service.MajorClassService;
import com.jit.emsystemapi.vo.*;
import com.jit.emsystemapi.vo.GMC.*;
import com.jit.emsystemapi.vo.param.GMC.*;
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
        String userId = majorClassParam.getUserId();

        String gradeId = majorClassParam.getGradeSearch();

        String majorName = majorClassParam.getMajorSearch();

        String className = majorClassParam.getClassSearch();

        List<MajorClassVo> majorClassVos = classMapper.selectAllMajorClass(userId, gradeId, majorName, className);

        return Result.success(new TableDataVo(majorClassVos),"获取成功");
    }

    @Override
    public Result getAllGrade(GetAllgrade getAllgrade) {
        String userId = getAllgrade.getUserId();


        List<String> allGrade = gradeMajorMapper.getAllGrade(userId);

        List<GradeVo> gradeVos = new ArrayList<>();

        for (String gradeId : allGrade) {
            gradeVos.add(new GradeVo(gradeId + "级", gradeId));
        }
        return Result.success(new GradeArrayVo(gradeVos), "获取成功");
    }

    @Override
    public Result getMajorByGradeId(GetMajorParam getMajorParam) {
        String gradeId = getMajorParam.getGradeId();
        String userId = getMajorParam.getUserId();
        List<MajorVo> majorVos = gradeMajorMapper.getMajorByGradeId(userId, gradeId);
        return Result.success(new MajorDataVo(majorVos), "获取成功");
    }

    @Override
    public Result addMajor(AddMajorParam addMajorParam) {
        String userId = addMajorParam.getUserId();
        String gradeId = addMajorParam.getGradeId();
        List<String> majorNames = addMajorParam.getMajorArray();

        for (String majorName: majorNames) {
            if(gradeMajorSercive.selectByGradeIdMajorName(userId, gradeId, majorName).isEmpty())
            {
                gradeMajorMapper.addMajor(userId, gradeId, majorName);
            }
        }
        return Result.success(null, "添加成功");
    }

    @Override
    public Result addClass(AddClassParam addClassParam) {
        String userId = addClassParam.getUserId();
        String gradeId = addClassParam.getGradeId();
        String majorId = addClassParam.getMajorId();
        List<String> classNames = addClassParam.getClassArray();

        if(gradeMajorMapper.selectByGradeIdMajorId(userId, gradeId, majorId) != null)
        {
            for(String classname:classNames) {
                if(classMapper.selectClassByName(userId, classname, majorId) == null)
                {
                    classMapper.addClassByName(userId, majorId,classname);
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
        String userId = deleteClassParam.getUserId();

        List<String> classIds = deleteClassParam.getClassArray();

        for(String classId : classIds) {
            if(classMapper.selectClassById(userId, classId) != null) {
                classMapper.deleteClassById(userId,classId);
            }
        }
        return Result.success(null,"删除成功");
    }

}
