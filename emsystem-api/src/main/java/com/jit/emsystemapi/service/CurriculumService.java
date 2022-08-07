package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.curriculum.*;

public interface CurriculumService {
    Result getGradeMajorClass(GetGMCParam getGMCParam);

    Result getTeacherId(GetTeacherIdParam getTeacherIdParam);

    Result addCurriculum(AddCurriculumParam addCurriculumParam);

    Result getAllCurriculum(GetAllCurriculumParam getAllCurriculumParam);

    Result deleteCurriculum(DeleteCurriculumParam deleteCurriculumParam);

}
