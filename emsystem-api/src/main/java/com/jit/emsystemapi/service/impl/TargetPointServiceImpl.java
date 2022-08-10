package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.*;
import com.jit.emsystemapi.dao.pojo.GradeMajor;
import com.jit.emsystemapi.dao.pojo.GraduationRequirement;
import com.jit.emsystemapi.dao.pojo.MajorGrAchieve;
import com.jit.emsystemapi.dao.pojo.TargetPoint;
import com.jit.emsystemapi.service.GradeMajorService;
import com.jit.emsystemapi.service.GraduationRequirementService;
import com.jit.emsystemapi.service.TargetPointService;
import com.jit.emsystemapi.vo.GMC.ViewGMVo;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.targetpoint.*;
import com.jit.emsystemapi.vo.param.viewachievement.ViewMajorParam;
import com.jit.emsystemapi.vo.targetpoint.ColumnsVo;
import com.jit.emsystemapi.vo.targetpoint.FieldVo;
import com.jit.emsystemapi.vo.targetpoint.GetAllVo;
import com.jit.emsystemapi.vo.targetpoint.TpVo;
import com.jit.emsystemapi.vo.viewachievement.GraduationReqAchievementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TargetPointServiceImpl implements TargetPointService {
    @Autowired
    private TargetPointMapper targetPointMapper;
    @Autowired
    private GradeMajorService gradeMajorService;
    @Autowired
    private GraduationRequirementService graduationRequirementService;
    @Autowired
    private SupportMatrixMapper supportMatrixMapper;
    @Autowired
    private TargetSupportMapper targetSupportMapper;
    @Autowired
    private ClassCourseAchieveMapper classCourseAchieveMapper;
    @Autowired
    private ClassTpAchieveMapper classTpAchieveMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private ClassGrAchieveMapper classGrAchieveMapper;
    @Autowired
    private MajorTpAchieveMapper majorTpAchieveMapper;
    @Autowired
    private MajorGrAchieveMapper majorGrAchieveMapper;
    @Autowired
    private GraduationRequirementMapper graduationRequirementMapper;

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
        List<GradeMajor> gradeMajors = gradeMajorService.selectByGradeIdMajorName(userId, gradeId, majorName);

        List<GetAllVo> vos = new ArrayList<>();
        for (GradeMajor gradeMajor : gradeMajors) {
            List<GraduationRequirement> grs = graduationRequirementService.selectUidByMajorIdNo(userId, gradeMajor.getMajorId(), graduationNo);
            for (GraduationRequirement gr : grs) {
                String uid = String.valueOf(gr.getUid());
                String gradContent = gr.getContent();
                List<TargetPoint> tps = targetPointMapper.selectByUNC(userId, uid, pointNo, pointContent);
                for(TargetPoint tp : tps) {
                    vos.add(new GetAllVo(userId, gradeMajor.getGradeId(), gradeMajor.getMajorName(), uid,  gr.getNo(), gradContent,tp.getTpNo(), tp.getTpId(), tp.getContent()));
                }
            }
        }

        return Result.success(vos, "获取成功");
    }

    @Override
    public Result getCourseTargetPoint(GetCourseTpParam getCourseTpParam) {
        String userId = getCourseTpParam.getUserId();
        String courseNo = getCourseTpParam.getCourseNo();

        List<String> TpIds = supportMatrixMapper.getTpIdByCourseNo(userId, courseNo);

        ColumnsVo columnsVo = new ColumnsVo();
        columnsVo.getColumn().add(new FieldVo("序号", "序号"));
        columnsVo.getColumn().add(new FieldVo("学号","学号"));
        columnsVo.getColumn().add(new FieldVo("姓名","姓名"));
        for(String TpId : TpIds) {
            String TpNo = targetPointMapper.getNoById(userId, TpId);
            columnsVo.getColumn().add(new FieldVo("指标点Id"  +"(" + TpId + ")", "指标点Id"  +"(" + TpId + ")"));
            columnsVo.getColumn().add(new FieldVo("指标点(" + TpNo + ")教师评成绩", "指标点(" + TpNo + ")教师评成绩"));
            columnsVo.getColumn().add(new FieldVo("指标点(" + TpNo + ")学生评成绩", "指标点(" + TpNo + ")学生评成绩"));
            columnsVo.getPoints().add(new TpVo(TpId, TpNo));
        }

        return Result.success(columnsVo, "查询成功");
    }

    @Override
    public Result recordCourseScore(RecordParam recordParam) {
        String userId = recordParam.getUserId();
        String courseNo = recordParam.getCourseNo();
        String classId = recordParam.getClassId();
        List<TPoint> tps = recordParam.getNeedArray();

        List<String> tpIds = supportMatrixMapper.getTpIdByCourseNo(userId, courseNo);
        /* 获取老师和学生的评价成绩占比 */
        Integer sPercent = targetSupportMapper.getStudentPercent(userId);
        Integer tPercent =  10 - sPercent;


        /* 获取支撑度*/
        Map<String, Integer> supportDegree = new HashMap<>();
        for(String tpId : tpIds) {
            supportDegree.put(tpId, supportMatrixMapper.getSupportDegree(userId, courseNo, tpId));
        }

        /* 解析传回来的指标点，合并教师和学生的评价成绩*/
        Integer maxEstimate = targetSupportMapper.getMaxEstimate(userId);
        Map<String, List<Integer>> tpScores = new HashMap<>();
        for(String tpId : tpIds) {
            tpScores.put(tpId, new ArrayList<>());
        }
        for(TPoint tPoint : tps) {
            String tpId = tPoint.getPointId();
            Integer studentEstimate = Integer.valueOf(tPoint.getStudentEstimate());
            Integer teacherEstimate = Integer.valueOf(tPoint.getTeacherEstimate());

            if(studentEstimate > maxEstimate
                || studentEstimate < 1
                || teacherEstimate > maxEstimate
                || teacherEstimate < 1
            ) {
                return Result.success(null, "评价等级越界");
            }

            Integer estimate = (studentEstimate * sPercent + teacherEstimate * tPercent) / 10;
            tpScores.get(tpId).add(estimate);
        }

        /*计算达成度 (评价等级 * 支撑度)/评价等级数 */
        for(String tpId : tpIds) {
            Integer sum = 0;
            for(Integer score : tpScores.get(tpId)) {
                sum += score;
            }
            Integer achievement = (sum / tpScores.get(tpId).size()) * supportDegree.get(tpId) / maxEstimate;
            classCourseAchieveMapper.updateAchieve(userId, classId, courseNo, tpId, achievement);

            /* 更新班级指标点达成情况 */
            classTargetPointAchieveUpdate(userId, classId, tpId);
        }

        return Result.success(null, "上传成功");
    }

    @Override
    public Result viewMajorAchievement(ViewMajorParam viewMajorParam) {
        String userId = viewMajorParam.getUserId();
        String majorId = viewMajorParam.getMajorId();

        List<MajorGrAchieve> mgras = majorGrAchieveMapper.getMGAs(userId, majorId);

        List<GraduationReqAchievementVo> grAchievements = new ArrayList<>();

        for (MajorGrAchieve mgra : mgras) {
            String grAchievement = String.valueOf(mgra.getAchievement());
            Integer uid = mgra.getUId();
            GraduationRequirement gr = graduationRequirementMapper.getGrByUid(userId, uid);

            GraduationReqAchievementVo gra = new GraduationReqAchievementVo(grAchievement, gr.getNo(), gr.getContent());


        }
        return  null;
    }

    private void classTargetPointAchieveUpdate(String userId, String classId, String tpId) {
        if(classCourseAchieveMapper.getAchieveIsNull(userId,classId,tpId) == 0 ){   //判断是否所有课程都计算出达成度
            Integer maxVector = supportMatrixMapper.getVectorDegree(userId, tpId);
            Integer achieveVector = classCourseAchieveMapper.getAchieveVectorDegree(userId, classId, tpId);

            Integer tpAchievement = (achieveVector * targetSupportMapper.getMaxAchievement(userId)) / maxVector;

            String majorId = classMapper.getMajorId(userId, classId);
            String uid = targetPointMapper.getUidByTpId(userId, tpId);

            if(classTpAchieveMapper.getCTA(userId, tpId, classId) == null)
                classTpAchieveMapper.addDate(userId, majorId, tpId, classId, tpAchievement, uid);
            else
                classTpAchieveMapper.upDate(userId, tpId, classId, tpAchievement);

            /* 更新班级毕节要求达成度 */
            classGraduationReqUpdate(userId, classId, uid, majorId);

            /* 更新年级指标点达成度 */
            majorTargetPointAchieveUpdate(userId,majorId, tpId, uid);
        }
    }

    private void majorTargetPointAchieveUpdate(String userId, String majorId, String tpId, String uid) {

        //如果全部的班级都已经计算出达成度
        if(classTpAchieveMapper.getTpSize(userId, tpId, majorId) == classMapper.getClassSize(userId, majorId)) {
            Integer majorAchieve = classTpAchieveMapper.getMajorAchieve(userId, tpId, majorId);

            if(majorTpAchieveMapper.getMTA(userId, tpId, majorId) == null) {
                majorTpAchieveMapper.addData(userId, uid, tpId, majorId, majorAchieve);
            }
            else {
                majorTpAchieveMapper.upDate(userId, tpId, majorAchieve);
            }

            /* 更新年级毕业要求达成度 */
            majorGraduationReqAchieveUpdate(userId, majorId, uid);
        }
    }

    private void majorGraduationReqAchieveUpdate(String userId, String majorId, String uid) {
        if(majorTpAchieveMapper.getGrSize(userId, majorId, uid) == targetPointMapper.getGrSize(userId, uid)) {

            //再毕业要求下的最小的指标点达成度就是毕业要求达成度
            Integer grAchievement = majorTpAchieveMapper.getGrAchievement(userId, uid, majorId);

            if(majorGrAchieveMapper.getMGA(userId, uid, majorId) == null) {
                majorGrAchieveMapper.addData(userId, uid, grAchievement, majorId);
            }
            else
                majorGrAchieveMapper.upDate(userId, uid, grAchievement, majorId);
        }
    }

    private void classGraduationReqUpdate(String userId, String classId, String uid, String majorId) {
        if(targetPointMapper.getGrSize(userId, uid) == classTpAchieveMapper.getGrSize(userId, uid, classId)) {

            //再毕业要求下的最小的指标点达成度就是毕业要求达成度
            Integer grAchievement = classTpAchieveMapper.getGrAchievement(userId, uid, classId);

            if(classGrAchieveMapper.getCGA(userId, uid, classId) == null) {
                classGrAchieveMapper.addData(userId,classId, uid, grAchievement, majorId);
            }
            else
                classGrAchieveMapper.upDate(userId, classId, uid, grAchievement);
        }
    }
}
