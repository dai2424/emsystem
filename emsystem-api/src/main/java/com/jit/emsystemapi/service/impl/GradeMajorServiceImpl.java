package com.jit.emsystemapi.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jit.emsystemapi.dao.mapper.GradeMajorMapper;
import com.jit.emsystemapi.dao.pojo.GradeMajor;
import com.jit.emsystemapi.service.GradeMajorSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GradeMajorServiceImpl implements GradeMajorSercive {
    @Autowired
    private GradeMajorMapper gradeMajorMapper;

    @Override
    public List<GradeMajor> selectByGradeIdMajorName(String userId, String gradeId, String majorName) {
        LambdaQueryWrapper<GradeMajor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(!StringUtils.isBlank(userId), GradeMajor::getUserId, userId);
        queryWrapper.eq(!StringUtils.isBlank(gradeId), GradeMajor::getGradeId, gradeId);
        queryWrapper.eq(!StringUtils.isBlank(majorName), GradeMajor::getMajorName, majorName);
        List<GradeMajor> gradeMajors = gradeMajorMapper.selectList(queryWrapper);
        return gradeMajors;
    }

}
