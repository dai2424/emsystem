package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.ClassCourseAchieve;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
