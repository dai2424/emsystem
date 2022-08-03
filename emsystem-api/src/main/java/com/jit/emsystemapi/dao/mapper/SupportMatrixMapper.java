package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.SupportMatrix;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SupportMatrixMapper extends BaseMapper<SupportMatrix> {

    @Insert({"insert into support_matrix(user_id, course_no, tp_id, support_degree) values(#{userId}, #{courseNo}, #{pointId}, #{supportNum});"})
    void addCourse(@Param("userId") String userId,
                   @Param("courseNo") String courseNo,
                   @Param("pointId") String pointId,
                   @Param("supportNum") String supportNum);

    @Update({"update support_matrix set support_degree = #{supportNum} where user_id = #{userId} and course_no = #{courseNo} and tp_id = #{pointId};"})
    int UpdateCourse(@Param("userId") String userId,
                      @Param("courseNo") String courseNo,
                      @Param("pointId") String pointId,
                      @Param("supportNum") String supportNum);

    @Select({"select count(*) from support_matrix where user_id = #{userId} and course_no = #{courseNo} and tp_id = #{pointId}; "})
    int selectExist(@Param("userId") String userId,
                    @Param("courseNo") String courseNo,
                    @Param("pointId") String pointId);

    @Delete({"delete from support_matrix where user_id = #{userId} and course_no = #{courseNo} and tp_id = #{pointId};"})
    int deleteCourse(@Param("userId") String userId,
                     @Param("courseNo") String courseNo,
                     @Param("pointId") String pointId);

    @Select({"<script> " +
            "select * from support_matrix " +
                "<where> " +
                    "<if test = 'userId != null and userId != \"\"' > "+
                        "and user_id = #{userId} " +
                    "</if>" +
                    "<if test = 'tpId != null and tpId != \"\"' > "+
                        "and tp_id = #{tpId} " +
                    "</if>" +
                    "<if test = 'courseNo != null and courseNo != \"\"' > "+
                        "and course_no = #{courseNo} " +
                    "</if>" +
                "</where> " +
            "</script>"})
    List<SupportMatrix> selectCourse(@Param("userId") String userId,
                                     @Param("tpId") String tpId,
                                     @Param("courseNo") String courseNo);
}
