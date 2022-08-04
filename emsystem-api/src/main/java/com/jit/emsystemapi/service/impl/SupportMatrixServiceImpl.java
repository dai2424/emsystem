package com.jit.emsystemapi.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.jit.emsystemapi.dao.mapper.SupportMatrixMapper;
import com.jit.emsystemapi.dao.mapper.TargetPointMapper;
import com.jit.emsystemapi.dao.mapper.TargetSupportMapper;
import com.jit.emsystemapi.dao.mapper.TrainingPlanMapper;
import com.jit.emsystemapi.dao.pojo.SupportMatrix;
import com.jit.emsystemapi.dao.pojo.TargetPoint;
import com.jit.emsystemapi.service.SupportMatrixService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.matrix.MatrixVo;
import com.jit.emsystemapi.vo.param.matrix.AssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.DeleteAssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.EditAssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.GetAllCourseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SupportMatrixServiceImpl implements SupportMatrixService {
    @Autowired
    private SupportMatrixMapper supportMatrixMapper;

    @Autowired
    private TrainingPlanMapper trainingPlanMapper;

    @Autowired
    private TargetSupportMapper targetSupportMapper;

    @Autowired
    private TargetPointMapper targetPointMapper;

    private int max_degree = 0;

    @Override
    public Result assignCourse(AssignCourseParam assignCourseParam) {
        String userId = assignCourseParam.getUserId();
        String courseName = assignCourseParam.getCourseName();
        String supportNum = assignCourseParam.getSupportNum();
        String pointId = assignCourseParam.getPointId();

        String courseNo = trainingPlanMapper.selectNobyName(userId, courseName);

        if(max_degree == 0) {
            max_degree = targetSupportMapper.selectMaxDegree(userId);
        }

        if(Integer.parseInt(supportNum) > max_degree || Integer.parseInt(supportNum) < 1) {
            return Result.success(null, "支撑度范围越界");
        }

        if(StringUtils.isBlank(courseNo)) {
            return Result.success(null,"课程名不存在");
        }
        else {
            if (supportMatrixMapper.selectExist(userId, courseNo, pointId) > 0)
            {
                return Result.success(null,"课程已分配");
            }

            supportMatrixMapper.addCourse(userId, courseNo, pointId, supportNum);

            return Result.success(null,"分配成功");
        }
    }

    @Override
    public Result editAssignCourse(EditAssignCourseParam editAssignCourseParam) {
        String userId = editAssignCourseParam.getUserId();
        String courseName = editAssignCourseParam.getCourseName();
        String supportNum = editAssignCourseParam.getSupportNum();
        String pointId = editAssignCourseParam.getPointId();

        String courseNo = trainingPlanMapper.selectNobyName(userId, courseName);

        if(max_degree == 0) {
            max_degree = targetSupportMapper.selectMaxDegree(userId);
        }

        if(Integer.parseInt(supportNum) > max_degree || Integer.parseInt(supportNum) < 1) {
            return Result.success(null, "支撑度范围越界");
        }

        if(StringUtils.isBlank(courseNo)) {
            return Result.success(null,"课程名不存在");
        }
        else {
            int cnt = supportMatrixMapper.UpdateCourse(userId, courseNo, pointId, supportNum);

            return Result.success(null,"修改" + cnt + "条");
        }
    }

    @Override
    public Result deleteAssignCourse(DeleteAssignCourseParam deleteAssignCourseParam) {
        String userId = deleteAssignCourseParam.getUserId();
        String courseName = deleteAssignCourseParam.getCourseName();
        String pointId = deleteAssignCourseParam.getPointId();

        String courseNo = trainingPlanMapper.selectNobyName(userId, courseName);

        if(StringUtils.isBlank(courseNo)) {
            return Result.success(null,"课程名不存在");
        }
        else {
            int cnt = supportMatrixMapper.deleteCourse(userId, courseNo, pointId);

            return Result.success(null,"删除" + cnt + "条");
        }
    }

    @Override
    public Result getAllCourse(GetAllCourseParam getAllCourseParam) {
        String courseName = getAllCourseParam.getCourseName();
        String userId = getAllCourseParam.getUserId();
        String pointContent = getAllCourseParam.getPointContent();

        List<String> courseNos = new ArrayList<>();
        if(!StringUtils.isBlank(courseName))
            courseNos.addAll(trainingPlanMapper.selectNosbyName(userId, courseName));

        if(courseNos.isEmpty() && !StringUtils.isBlank(courseName))
        {
            return Result.success(null,"课程名关键字不存在");
        }

        List<TargetPoint> tps = targetPointMapper.selectByContent(userId, pointContent);

        List<MatrixVo> mxs = new ArrayList<>();

        for (TargetPoint tp : tps) {
            String tpContent = tp.getContent();
            String tpId = String.valueOf(tp.getTpId());

            List<SupportMatrix> sms = new ArrayList<>();

            for(String courseNo : courseNos) {
                sms.addAll(supportMatrixMapper.selectCourse(userId, tpId, courseNo));
            }

            /* 如果没有传课程名的话数据的话，不会查出courseNo*/
            if(courseNos.isEmpty()) sms.addAll(supportMatrixMapper.selectCourse(userId, tpId, null));

            for (SupportMatrix sm : sms) {
                String cname = trainingPlanMapper.selectName(userId, sm.getCourseNo());
                mxs.add(new MatrixVo(sm.getCourseNo(), tpContent, sm.getSupportDegree(), tpId, cname));
            }

        }

        return Result.success(mxs,"查询成功");
    }
}
