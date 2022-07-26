package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.AddClassParam;
import com.jit.emsystemapi.vo.param.AddMajorParam;
import com.jit.emsystemapi.vo.param.DeleteClassParam;
import com.jit.emsystemapi.vo.param.MajorClassParam;

public interface MajorClassService {
    public Result getAllMajorClass(MajorClassParam majorClassParam);

    Result getAllGrade();

    Result getMajorByGradeId(String gradeId);

    Result addMajor(AddMajorParam addMajorParam);

    Result addClass(AddClassParam addClassParam);

    Result deleteClass(DeleteClassParam deleteClassParam);
}
