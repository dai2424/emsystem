package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.*;
import com.jit.emsystemapi.dao.pojo.Curriculum;
import com.jit.emsystemapi.dao.pojo.Teacher;
import com.jit.emsystemapi.dao.pojo.TrainingPlan;
import com.jit.emsystemapi.service.ClassCourseAchieveService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.achievement.ScoreRecordedVo;
import com.jit.emsystemapi.vo.param.achievement.GetScoreRecordedParam;
import com.jit.emsystemapi.vo.param.achievement.GetTeacherScoreRecordedParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassCourseAchieveServiceImpl implements ClassCourseAchieveService {
    @Autowired
    private ClassCourseAchieveMapper classCourseAchieveMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private TrainingPlanMapper trainingPlanMapper;

    @Autowired
    private ClassMapper classMapper;

    @Override
    public Result getScoreRecorded(GetScoreRecordedParam getScoreRecordedParam) {
        String courseName = getScoreRecordedParam.getCourseName();
        String teacherName = getScoreRecordedParam.getTeacherName();
        String userId = getScoreRecordedParam.getUserId();
        String arrangeNum = getScoreRecordedParam.getArrangeNum();

        List<Teacher> teachers = teacherMapper.getTeacherByName(userId, teacherName);
        List<TrainingPlan> courses = trainingPlanMapper.selectCoursesByName(userId, courseName);

        List<ScoreRecordedVo> srVos = new ArrayList<>();

        for(Teacher teacher : teachers) {
            String tNo = teacher.getTNo();
            String tName = teacher.getTName();

            for(TrainingPlan course : courses) {
                String cNo = course.getCourseNo();
                String cName = course.getCourseName();
                List<Curriculum> plans = curriculumMapper.getPlan(userId, tNo, cNo, arrangeNum);

                for (Curriculum plan : plans) {
                    Integer classId = plan.getClassId();
                    String className = classMapper.getNameById(userId, classId);
                    Boolean status = classCourseAchieveMapper.getStatus(userId, tNo, classId, cNo);
                    srVos.add(new ScoreRecordedVo(tNo, tName, cNo, cName, className, plan.getArrangeTerm(), status, classId));
                }
            }
        }
        return Result.success(srVos, "获取成功");
    }

    @Override
    public Result getTeacherScoreRecorded(GetTeacherScoreRecordedParam getTeacherScoreRecordedParam) {
        String teacherNo = getTeacherScoreRecordedParam.getTeacherNo();
        String userId = getTeacherScoreRecordedParam.getUserId();
        String courseName = getTeacherScoreRecordedParam.getCourseName();
        String arrangeNum = getTeacherScoreRecordedParam.getArrangeNum();

        Teacher teacher = teacherMapper.selectByNo(userId, teacherNo);
        String teacherName = teacher.getTName();

        List<TrainingPlan> courses = trainingPlanMapper.selectCoursesByName(userId, courseName);
        List<ScoreRecordedVo> srVos = new ArrayList<>();

        for(TrainingPlan course : courses) {
            String cNo = course.getCourseNo();
            String cName = course.getCourseName();
            List<Curriculum> plans = curriculumMapper.getPlan(userId, teacherNo, cNo, arrangeNum);

            for (Curriculum plan : plans) {
                Integer classId = plan.getClassId();
                String className = classMapper.getNameById(userId, classId);
                Boolean status = classCourseAchieveMapper.getStatus(userId, teacherNo, classId, cNo);
                srVos.add(new ScoreRecordedVo(teacherNo, teacherName, cNo, cName, className, plan.getArrangeTerm(), status, classId));
            }
        }
        
        return Result.success(srVos, "获取成功");
    }
}
