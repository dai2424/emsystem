package com.jit.emsystemapi.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jit.emsystemapi.dao.mapper.GradeMajorMapper;
import com.jit.emsystemapi.dao.pojo.GradeMajor;
import com.jit.emsystemapi.service.GradeMajorService;
import com.jit.emsystemapi.vo.GMC.GradeViewVo;
import com.jit.emsystemapi.vo.GMC.MajorVo;
import com.jit.emsystemapi.vo.GMC.ViewGMVo;
import com.jit.emsystemapi.vo.GMC.ViewMajorVo;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.GMC.GetGradeMajorParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.View;
import java.util.List;

@Service
@Transactional
public class GradeMajorServiceImpl implements GradeMajorService {
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

    @Override
    public Result getGradeMajor(GetGradeMajorParam getGradeMajorParam) {
        String userId = getGradeMajorParam.getUserId();
        List<String> allGrade = gradeMajorMapper.getAllGrade(userId);

        ViewGMVo gmVo = new ViewGMVo();
        for(String gradeId : allGrade) {
            GradeViewVo gVo = new GradeViewVo(gradeId, gradeId + "级");

            List<MajorVo> majors = gradeMajorMapper.getMajorByGradeId(userId, gradeId);

            for (MajorVo majorVo : majors) {
                gVo.getChildren().add(new ViewMajorVo(majorVo.getId(), majorVo.getLabel()));
            }
            if(!gVo.getChildren().isEmpty()) {
                gmVo.getOptions().add(gVo);
            }
        }
        return Result.success(gmVo, "查询成功");
    }

}
