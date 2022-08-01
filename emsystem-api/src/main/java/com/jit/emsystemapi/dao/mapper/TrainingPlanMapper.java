package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.TrainingPlan;
import com.jit.emsystemapi.vo.trainingplan.PlanVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TrainingPlanMapper extends BaseMapper<TrainingPlan> {
    @Select({"select count(*) from training_plan where user_id = #{userId} and course_no =  #{courseNo}"})
    int selectByNo(@Param("userId") String userId, @Param("courseNo") String courseNo);

    @Insert({"insert into training_plan(user_id, course_no, course_name, credit_hour, arrange_term) " +
            "values(#{userId}, #{courseNo}, #{courseName}, #{creditHour}, #{arrangeTerm})"})
    void addPlan(@Param("userId") String userId,
                 @Param("courseNo") String courseNo,
                 @Param("courseName") String courseName,
                 @Param("creditHour") String creditHour,
                 @Param("arrangeTerm") String arrangeTerm);

    @Update({"update training_plan set course_name = #{courseName}, credit_hour = #{creditHour}, arrange_term = #{arrangeTerm} " +
            "where user_id = #{userId} and course_no = #{courseNo}"})
    void editPlan(@Param("userId") String userId,
                  @Param("courseNo") String courseNo,
                  @Param("courseName") String courseName,
                  @Param("creditHour") String creditHour,
                  @Param("arrangeTerm") String arrangeTerm);

    @Delete({"delete from training_plan where user_id = #{userId} and course_no = #{courseNo};"})
    int deletePlan(@Param("userId") String userId,@Param("courseNo") String courseNo);

    @Select({"<script> " +
            "select course_no as courseNo, course_name as courseName, credit_hour as creditHour, arrange_term as arrangeTerm from training_plan " +
                "<where> " +
                    "<if test = 'userId != null and userId != \"\"' > "+
                        "and user_id = #{userId} " +
                    "</if>" +
                    "<if test = 'courseNo != null and courseNo != \"\"' > "+
                        "and course_no = #{courseNo} " +
                    "</if>" +
                    "<if test = 'courseName != null and courseName != \"\"' > "+
                        "and course_name = #{courseName} " +
                    "</if>" +
                    "<if test= 'arrangeTerm != null and arrangeTerm != \"\" '>"+
                        " and arrange_term = #{arrangeTerm} "+
                    "</if>"+
                "</where>" +
            "</script>"})
    List<PlanVo> selectAll(@Param("userId") String userId,
                           @Param("courseNo") String courseNo,
                           @Param("courseName") String courseName,
                           @Param("arrangeTerm") String arrangeTerm);
}
