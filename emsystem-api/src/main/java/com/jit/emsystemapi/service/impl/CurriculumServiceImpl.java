package com.jit.emsystemapi.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.jit.emsystemapi.dao.mapper.*;
import com.jit.emsystemapi.dao.pojo.Class;
import com.jit.emsystemapi.dao.pojo.GradeMajor;
import com.jit.emsystemapi.dao.pojo.SupportMatrix;
import com.jit.emsystemapi.dao.pojo.Teacher;
import com.jit.emsystemapi.service.CurriculumService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.curriculum.*;
import com.jit.emsystemapi.vo.param.curriculum.AddCurriculumParam;
import com.jit.emsystemapi.vo.param.curriculum.GetGMCParam;
import com.jit.emsystemapi.vo.param.curriculum.GetTeacherIdParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CurriculumServiceImpl implements CurriculumService {
    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private GradeMajorMapper gradeMajorMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TrainingPlanMapper trainingPlanMapper;

    @Autowired
    private SupportMatrixMapper supportMatrixMapper;

    @Autowired
    private ClassCourseAchieveMapper classCourseAchieveMapper;

    @Override
    public Result getGradeMajorClass(GetGMCParam getGMCParam) {
        String userId = getGMCParam.getUserId();
        List<String> gradeIds = gradeMajorMapper.getAllGrade(userId);

        GMCVo gmcVo = new GMCVo();
        //遍历年级数组，当没有班级时不返回此年级的数据
        for(String gradeId : gradeIds) {
            GVo gVo = new GVo();
            gVo.setValue(gradeId);
            gVo.setLabel(gradeId + "级");

            List<GradeMajor> majors = gradeMajorMapper.getAllMajor(userId, gradeId);

            //遍历专业数组，当没有班级时不返回此专业的数据
            if(!majors.isEmpty()) {
                for(GradeMajor major: majors) {
                    MVo mVo = new MVo();
                    mVo.setValue(String.valueOf(major.getMajorId()));
                    mVo.setLabel(major.getMajorName());

                    List<Class> classes = classMapper.getClassByMajorId(userId, major.getMajorId());
                    if(!classes.isEmpty()) {
                        for(Class cs : classes) {
                            CVo cVo = new CVo();
                            cVo.setValue(String.valueOf(cs.getClassId()));
                            cVo.setLabel(cs.getClassName());

                            mVo.getChildren().add(cVo);
                        }
                    }

                    if(!mVo.getChildren().isEmpty()) {
                        gVo.getChildren().add(mVo);
                    }
                }

                if(!gVo.getChildren().isEmpty()) {
                    gmcVo.getOptions().add(gVo);
                }
            }
        }
        return Result.success(gmcVo,"查询成功");
    }

    @Override
    public Result getTeacherId(GetTeacherIdParam getTeacherIdParam) {
        String teacherName = getTeacherIdParam.getTeacherName();
        String userId = getTeacherIdParam.getUserId();
        List<Teacher> teachers = teacherMapper.getTeacherByName(userId, teacherName);

        List<TeacherVo> tVos = new ArrayList<>();
        for(Teacher teacher: teachers) {
            tVos.add(new TeacherVo(teacher.getTNo(), teacher.getTName()));
        }

        return Result.success(tVos, "获取成功");
    }

    @Override
    public Result addCurriculum(AddCurriculumParam addCurriculumParam) {
        String userId = addCurriculumParam.getUserId();
        String classId = addCurriculumParam.getClassId();
        String arrangeTerm = addCurriculumParam.getArrangeTerm();
        String courseName = addCurriculumParam.getCourseName();
        String teacherNo = addCurriculumParam.getTeacherNo();

        String majorId = classMapper.getMajorId(userId, classId);
        String courseNo = trainingPlanMapper.selectNobyName(userId, courseName);
        if(StringUtils.isBlank(courseNo)) {
            return Result.success(null,"课程名异常");
        }

        curriculumMapper.addPlan(userId, teacherNo, courseNo, classId, arrangeTerm, majorId);

        /* 为创建课程达成度的记录，达成度默认为null */
        List<SupportMatrix> sms = supportMatrixMapper.selectCourse(userId,null, courseNo);
        for(SupportMatrix sm : sms) {
            Integer tpId = sm.getTpId();
            classCourseAchieveMapper.addData(userId, teacherNo, classId, majorId, courseNo, tpId, arrangeTerm);
        }

        return Result.success(null,"添加成功");
    }
}
