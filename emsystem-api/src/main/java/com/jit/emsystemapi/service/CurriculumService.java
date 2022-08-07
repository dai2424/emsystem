package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.curriculum.AddCurriculumParam;
import com.jit.emsystemapi.vo.param.curriculum.GetGMCParam;
import com.jit.emsystemapi.vo.param.curriculum.GetTeacherIdParam;

public interface CurriculumService {
    Result getGradeMajorClass(GetGMCParam getGMCParam);

    Result getTeacherId(GetTeacherIdParam getTeacherIdParam);

    Result addCurriculum(AddCurriculumParam addCurriculumParam);
}
