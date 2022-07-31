package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.GraduationRequirementMapper;
import com.jit.emsystemapi.dao.pojo.GraduationRequirement;
import com.jit.emsystemapi.service.GraduationRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GraduationRequirementServiceImpl implements GraduationRequirementService {
    @Autowired
    private GraduationRequirementMapper graduationRequirementMapper;

    @Override
    public List<GraduationRequirement> selectUidByMajorIdNo(String userId, Integer majorId, String graduationNo) {
//        LambdaQueryWrapper<GraduationRequirement> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(GraduationRequirement::getUserId, userId);
//        queryWrapper.eq(GraduationRequirement::getMajorId, majorId);
//        queryWrapper.eq(StringUtils.isBlank(graduationNo), GraduationRequirement::getNo, graduationNo);
//        queryWrapper.select(GraduationRequirement::getUid);
        return graduationRequirementMapper.selectUids(userId, majorId, graduationNo);
    }
}
