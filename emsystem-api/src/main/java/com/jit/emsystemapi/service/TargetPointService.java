package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.targetpoint.AddTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.DeleteTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.EditTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.GetAllTP;

public interface TargetPointService {
    Result addTargetPoint(AddTPParam addTPParam);

    Result editTargetPoint(EditTPParam editTPParam);

    Result deleteTargetPoint(DeleteTPParam deleteTPParam);

    Result getAllTarget(GetAllTP getAllTP);
}
