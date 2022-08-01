package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.GradeMajorMapper;
import com.jit.emsystemapi.dao.mapper.TargetPointMapper;
import com.jit.emsystemapi.dao.pojo.GradeMajor;
import com.jit.emsystemapi.dao.pojo.GraduationRequirement;
import com.jit.emsystemapi.dao.pojo.TargetPoint;
import com.jit.emsystemapi.service.GradeMajorSercive;
import com.jit.emsystemapi.service.GraduationRequirementService;
import com.jit.emsystemapi.service.TargetPointService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.targetpoint.AddTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.DeleteTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.EditTPParam;
import com.jit.emsystemapi.vo.param.targetpoint.GetAllTP;
import com.jit.emsystemapi.vo.targetpoint.GetAllVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TargetPointServiceImpl implements TargetPointService {
    @Autowired
    private TargetPointMapper targetPointMapper;
    @Autowired
    private GradeMajorSercive gradeMajorSercive;
    @Autowired
    private GraduationRequirementService graduationRequirementService;

    @Override
    public Result addTargetPoint(AddTPParam addTPParam) {
        String userId = addTPParam.getUserId();
        String pointNo = addTPParam.getPointNo();
        String content = addTPParam.getPointContent();
        String uid = addTPParam.getUid();

        targetPointMapper.addByUid(userId, uid, pointNo, content);

        return Result.success(null, "新增成功");
    }

    @Override
    public Result editTargetPoint(EditTPParam editTPParam) {
        String userId = editTPParam.getUserId();
        String pointNo = editTPParam.getPointNo();
        String pointContent = editTPParam.getPointContent();
        String pointId = editTPParam.getPointId();
        String uid = editTPParam.getUid();

        targetPointMapper.updateByUid(userId, pointId, uid, pointContent, pointNo);
        return Result.success(null,"修改成功");
    }

    @Override
    public Result deleteTargetPoint(DeleteTPParam deleteTPParam) {
        String userId = deleteTPParam.getUserId();
        List<String> pointIds = deleteTPParam.getPointArray();

        for(String pointId : pointIds) {
            //System.out.println(pointId);
            targetPointMapper.deleteById(userId, pointId);
        }
        return Result.success(null,"删除成功");
    }

    /**
     *  1、yearId, majorName 为空时查询所有专业
     *
     */
    @Override
    public Result getAllTarget(GetAllTP getAllTP) {
        String userId = getAllTP.getUserId();
        String majorName = getAllTP.getMajorName();
        String gradeId = getAllTP.getYearId();
        String graduationNo = getAllTP.getGraduationNo();
        String pointNo = getAllTP.getPointNo();
        String pointContent = getAllTP.getPointContent();

        //gradeMajorMapper.selectByGradeIdMajorName(userId, gradeId, majorName);
        List<GradeMajor> gradeMajors = gradeMajorSercive.selectByGradeIdMajorName(userId, gradeId, majorName);

        List<GetAllVo> vos = new ArrayList<>();
        for (GradeMajor gradeMajor : gradeMajors) {
            List<GraduationRequirement> grs = graduationRequirementService.selectUidByMajorIdNo(userId, gradeMajor.getMajorId(), graduationNo);
            for (GraduationRequirement gr : grs) {
                String uid = String.valueOf(gr.getUid());
                String gradContent = gr.getContent();
                List<TargetPoint> tps = targetPointMapper.selectByUNC(userId, uid, pointNo, pointContent);
                for(TargetPoint tp : tps) {
                    vos.add(new GetAllVo(userId, gradeMajor.getGradeId(), gradeMajor.getMajorName(), uid, gradContent, gr.getNo(), tp.getTpNo(), tp.getTpId(), tp.getContent()));
                }
            }
        }

        return Result.success(vos, "获取成功");
    }
}
