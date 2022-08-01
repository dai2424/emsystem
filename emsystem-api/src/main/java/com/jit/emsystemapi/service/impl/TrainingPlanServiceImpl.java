package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.TrainingPlanMapper;
import com.jit.emsystemapi.service.TrainingPlanService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.trainingplan.AddPlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.DeletePlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.EditPlanParam;
import com.jit.emsystemapi.vo.param.trainingplan.GetAllPlanParam;
import com.jit.emsystemapi.vo.trainingplan.PlanVo;
import com.jit.emsystemapi.vo.trainingplan.PlanVos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainingPlanServiceImpl implements TrainingPlanService {
    @Autowired
    private TrainingPlanMapper trainingPlanMapper;

    @Override
    public Result addPlan(AddPlanParam addPlanParam) {
        String userId = addPlanParam.getUserId();
        String courseNo = addPlanParam.getCourseNo();
        String courseName = addPlanParam.getCourseName();
        String creditHour = addPlanParam.getCreditHour();
        String arrangeTerm = addPlanParam.getArrangeTerm();

        if (trainingPlanMapper.selectByNo(userId, courseNo) < 1) {
            trainingPlanMapper.addPlan(userId, courseNo, courseName, creditHour, arrangeTerm);
        }
        else {
            return Result.success(null,"该课程编号已存在");
        }

        return Result.success(null,"添加成功");
    }

    @Override
    public Result editPlanParam(EditPlanParam editPlanParam) {
        String userId = editPlanParam.getUserId();
        String courseNo = editPlanParam.getCourseNo();
        String courseName = editPlanParam.getCourseName();
        String creditHour = editPlanParam.getCreditHour();
        String arrangeTerm = editPlanParam.getArrangeTerm();

        if (trainingPlanMapper.selectByNo(userId, courseNo) > 0) {
            trainingPlanMapper.editPlan(userId, courseNo, courseName, creditHour, arrangeTerm);
        }
        else {
            return Result.success(null,"该课程编号不存在");
        }
        return Result.success(null,"修改成功");
    }

    @Override
    public Result deletePlan(DeletePlanParam deletePlanParam) {
        String userId = deletePlanParam.getUserId();
        List<String> courseArrays = deletePlanParam.getCourseArray();

        int cnt = 0;
        for(int i = 0; i < courseArrays.size(); i++ ) {
            if(trainingPlanMapper.deletePlan(userId, courseArrays.get(i)) > 0)
                cnt++;
        }
        return Result.success(null,"删除" + cnt + "条");
    }

    @Override
    public Result getAllPlan(GetAllPlanParam getAllPlanParam) {
        String userId = getAllPlanParam.getUserId();
        String courseNo = getAllPlanParam.getCourseNo();
        String courseName = getAllPlanParam.getCourseName();
        String arrangeTerm = getAllPlanParam.getArrangeTerm();

        List<PlanVo> plans = trainingPlanMapper.selectAll(userId, courseNo, courseName, arrangeTerm);
        return Result.success(new PlanVos(plans), "获取成功");
    }
}
