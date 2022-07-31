package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.GMC.*;

public interface MajorClassService {
    Result getAllMajorClass(MajorClassParam majorClassParam);

    Result getAllGrade(GetAllgrade getAllgrade);

    Result getMajorByGradeId(GetMajorParam getMajorParam);

    Result addMajor(AddMajorParam addMajorParam);

    Result addClass(AddClassParam addClassParam);

    Result deleteClass(DeleteClassParam deleteClassParam);
}
