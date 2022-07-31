package com.jit.emsystemapi.service;

import com.jit.emsystemapi.dao.pojo.GraduationRequirement;

import java.util.List;

public interface GraduationRequirementService {
    List<GraduationRequirement> selectUidByMajorIdNo(String userId, Integer majorId, String graduationNo);
}
