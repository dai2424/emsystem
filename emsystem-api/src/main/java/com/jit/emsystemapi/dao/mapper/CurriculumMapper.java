package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.Curriculum;
import com.jit.emsystemapi.dao.pojo.TrainingPlan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CurriculumMapper extends BaseMapper<Curriculum> {
    @Insert({"insert into curriculum(user_id, t_no, course_no, class_id, arrange_term, major_id) values(#{userId}, #{teacherNo}, #{courseNo}, #{classId}, #{arrangeTerm}, #{majorId})"})
    void addPlan(@Param("userId") String userId,
                 @Param("teacherNo") String teacherNo,
                 @Param("courseNo") String courseNo,
                 @Param("classId") String classId,
                 @Param("arrangeTerm") String arrangeTerm,
                 @Param("majorId") String majorId);

    @Select({"<script>"+
            "select * from curriculum"+
                "<where>" +
                    "<if test= 'userId != null and userId != \"\"'>"+
                        "and user_id = #{userId} "+
                    "</if>"+
                    "<if test= 'tNo != null and tNo != \"\"'>"+
                        "and t_no = #{tNo} "+
                    "</if>"+
                    "<if test= 'courseNo != null and courseNo != \"\"'>"+
                        "and course_no = #{courseNo} "+
                    "</if>"+
                    "<if test= 'arrangeNum != null and arrangeNum != \"\" '>"+
                        "and `arrange_term` = #{arrangeNum} "+
                    "</if>"+
                "</where>"+
            "</script>"})
    List<Curriculum> getPlan(@Param("userId") String userId,
                             @Param("tNo") String tNo,
                             @Param("courseNo") String courseNo,
                             @Param("arrangeNum") String arrangeNum);

    @Delete({"delete from curriculum where user_id = #{userId} and t_no = #{tNo} and course_no = #{courseNo} and class_id = #{classId}"})
    void deleteData(@Param("userId") String userId,
                    @Param("tNo") String teacherNo,
                    @Param("courseNo") String courseNo,
                    @Param("classId") String classId);
}
