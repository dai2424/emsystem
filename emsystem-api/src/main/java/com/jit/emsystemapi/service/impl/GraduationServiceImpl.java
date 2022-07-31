package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.GradeMajorMapper;
import com.jit.emsystemapi.dao.mapper.GraduationRequirementMapper;
import com.jit.emsystemapi.service.GraduationService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.graduation.GraduationReqList;
import com.jit.emsystemapi.vo.graduation.GraduationReqVo;
import com.jit.emsystemapi.vo.graduation.UpdataGraduationReqVo;
import com.jit.emsystemapi.vo.param.graduation.AddGraduationReqParam;
import com.jit.emsystemapi.vo.param.graduation.DeleteNoParam;
import com.jit.emsystemapi.vo.param.graduation.GetAllGraduationReqParam;
import com.jit.emsystemapi.vo.param.graduation.UpdataGraduationReqParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GraduationServiceImpl implements GraduationService {

    @Autowired
    private GraduationRequirementMapper graduationRequirementMapper;

    @Autowired
    private GradeMajorMapper gradeMajorMapper;

    @Override
    public Result getAllGraduationReq(GetAllGraduationReqParam getAllGraduationReqParam) {

        String userid = getAllGraduationReqParam.getUserId();
        String gradeId = getAllGraduationReqParam.getGradeSearch();
        String content = getAllGraduationReqParam.getContentSearch();
        String majorName = getAllGraduationReqParam.getMajorSearch();
        String no = getAllGraduationReqParam.getNoSearch();

        List<GraduationReqVo> GraduationReqs = graduationRequirementMapper.getAllGraduationReq(userid, gradeId, majorName, no, content);

        return Result.success(new GraduationReqList(GraduationReqs), "获取成功");
    }

    @Override
    public Result deleteGraduationReq(DeleteNoParam deleteNoParam) {
        String userId = deleteNoParam.getUserId();
        List<String> uids = deleteNoParam.getReqArray();

        for(String uid : uids) {
            graduationRequirementMapper.deleteByNo(userId, uid);
        }
        return Result.success(null, "删除成功");
    }

    @Override
    public Result editGraduationReq(UpdataGraduationReqParam updataGraduationReqParam) {
        String userId = updataGraduationReqParam.getUserId();
        String gradeId = updataGraduationReqParam.getGradeSearch();
        String content = updataGraduationReqParam.getContentSearch();
        String no = updataGraduationReqParam.getNoSearch();
        String uid = updataGraduationReqParam.getUid();
        String majorName = updataGraduationReqParam.getMajorSearch();

        if(graduationRequirementMapper.updateById(userId, uid, content) < 1)
            return Result.success(null,"毕业要求不存在，更新失败");
        else {
            return Result.success(new UpdataGraduationReqVo(gradeId, majorName, no, content ,uid), "更新成功");
        }
    }

    @Override
    public Result addGraduationReq(AddGraduationReqParam addGraduationReqParam) {
        String userId = addGraduationReqParam.getUserId();
        String gradeId = addGraduationReqParam.getGradeSearch();
        String majorName = addGraduationReqParam.getMajorSearch();
        String content = addGraduationReqParam.getContentSearch();

        String majorId = gradeMajorMapper.selectMajorId(userId, gradeId, majorName);

        Integer size = graduationRequirementMapper.selectSizeByMajorId(userId, majorId) + 1;

        graduationRequirementMapper.addReq(userId, gradeId, majorId, content, size);

        return Result.success(null, "新增成功");
    }
}
