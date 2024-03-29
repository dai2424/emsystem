package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.ClassCourseAchieve;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ClassCourseAchieveMapper extends BaseMapper<ClassCourseAchieve> {
    @Insert({"insert into class_course_achieve(user_id, t_no, class_id, major_id, course_no, tp_id, arrange_term) " +
            "values(#{userId}, #{teacherNo}, #{classId}, #{majorId}, #{courseNo}, #{tpId}, #{arrangeTerm})"})
    void addData(@Param("userId") String userId,
                 @Param("teacherNo") String teacherNo,
                 @Param("classId") String classId,
                 @Param("majorId") String majorId,
                 @Param("courseNo") String courseNo,
                 @Param("tpId") Integer tpId,
                 @Param("arrangeTerm") String arrangeTerm);

    @Select({"select achievement is not null from class_course_achieve " +
            "where user_id = #{userId} and t_no = #{tNo} and class_id = #{classId} and course_no = #{cNo} limit 1"})
    Boolean getStatus(@Param("userId") String userId,
                      @Param("tNo") String tNo,
                      @Param("classId") Integer classId,
                      @Param("cNo") String cNo);

    @Delete({"delete from class_course_achieve where user_id = #{userId} and t_no = #{tNo} and course_no = #{cNo} and class_id = #{classId}"})
    void deleteData(@Param("userId") String userId,
                    @Param("tNo") String teacherNo,
                    @Param("cNo") String courseNo,
                    @Param("classId") String classId);

    @Update("update class_course_achieve set achievement = #{achievement} where user_id = #{userId} and class_id = #{classId} and course_no = #{courseNo} and tp_id = #{tpId};")
    void updateAchieve(@Param("userId") String userId,
                       @Param("classId") String classId,
                       @Param("courseNo") String courseNo,
                       @Param("tpId") String tpId,
                       @Param("achievement") Integer achievement);

    @Select({"select count(*) from class_course_achieve where user_id = #{userId} and class_id = #{classId} and tp_id = #{tpId} and achievement is NULL;"})
    int getAchieveIsNull(@Param("userId") String userId,
                         @Param("classId") String classId,
                         @Param("tpId") String tpId);

    @Select({"select sum(achievement) from class_course_achieve where user_id = #{userId} and tp_id = #{tpId} and class_id = #{classId};"})
    Integer getAchieveVectorDegree(@Param("userId") String userId,
                                   @Param("classId") String classId,
                                   @Param("tpId") String tpId);
}
