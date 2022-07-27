package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.graduation.AddGraduationReqParam;
import com.jit.emsystemapi.vo.param.graduation.DeleteNoParam;
import com.jit.emsystemapi.vo.param.graduation.GetAllGraduationReqParam;
import com.jit.emsystemapi.vo.param.graduation.UpdataGraduationReqParam;

public interface GraduationService {
    Result getAllGraduationReq(GetAllGraduationReqParam getAllGraduationReqParam);

    Result deleteGraduationReq(DeleteNoParam deleteNoParam);

    Result editGraduationReq(UpdataGraduationReqParam updataGraduationReqParam);

    Result addGraduationReq(AddGraduationReqParam addGraduationReqParam);
}
