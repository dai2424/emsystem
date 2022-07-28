package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.GMC.AddClassParam;
import com.jit.emsystemapi.vo.param.GMC.AddMajorParam;
import com.jit.emsystemapi.vo.param.GMC.DeleteClassParam;
import com.jit.emsystemapi.vo.param.GMC.MajorClassParam;

public interface MajorClassService {
    public Result getAllMajorClass(MajorClassParam majorClassParam);

    Result getAllGrade();

    Result getMajorByGradeId(String gradeId);

    Result addMajor(AddMajorParam addMajorParam);

    Result addClass(AddClassParam addClassParam);

    Result deleteClass(DeleteClassParam deleteClassParam);
}
