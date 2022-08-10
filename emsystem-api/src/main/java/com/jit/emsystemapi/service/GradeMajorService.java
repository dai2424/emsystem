package com.jit.emsystemapi.service;

import com.jit.emsystemapi.dao.pojo.GradeMajor;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.GMC.GetGradeMajorParam;

import java.util.List;

public interface GradeMajorService {
    List<GradeMajor> selectByGradeIdMajorName(String userId, String gradeId, String majorName);

    Result getGradeMajor(GetGradeMajorParam getGradeMajorParam);
}
