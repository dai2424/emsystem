package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.targetpoint.*;

public interface TargetPointService {
    Result addTargetPoint(AddTPParam addTPParam);

    Result editTargetPoint(EditTPParam editTPParam);

    Result deleteTargetPoint(DeleteTPParam deleteTPParam);

    Result getAllTarget(GetAllTP getAllTP);

    Result getCourseTargetPoint(GetCourseTpParam getCourseTpParam);
}
