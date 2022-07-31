package com.jit.emsystemapi.service;

import com.jit.emsystemapi.dao.pojo.GradeMajor;

import java.util.List;

public interface GradeMajorSercive {
    List<GradeMajor> selectByGradeIdMajorName(String userId, String gradeId, String majorName);
}
