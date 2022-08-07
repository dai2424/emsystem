package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.Curriculum;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CurriculumMapper extends BaseMapper<Curriculum> {
    @Insert({"insert into curriculum(user_id, t_no, course_no, class_id, arrange_term, major_id) values(#{userId}, #{teacherNo}, #{courseNo}, #{classId}, #{arrangeTerm}, #{majorId})"})
    void addPlan(@Param("userId") String userId,
                 @Param("teacherNo") String teacherNo,
                 @Param("courseNo") String courseNo,
                 @Param("classId") String classId,
                 @Param("arrangeTerm") String arrangeTerm,
                 @Param("majorId") String majorId);
}
