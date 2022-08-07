package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.GradeMajor;
import com.jit.emsystemapi.vo.GMC.MajorVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GradeMajorMapper extends BaseMapper<GradeMajor> {

    @Select({"select distinct grade_id from grade_major where user_id = #{userId}"})
    List<String> getAllGrade(@Param("userId") String userId);

    @Select({"select major_id as id, major_name as label from grade_major where grade_id = #{gradeId} and user_id = #{userId}"})
    List<MajorVo> getMajorByGradeId(@Param("userId") String userId,@Param("gradeId")  String gradeId);

//    "<script>"+
//            "select grade_id as gradeId, major_name as majorName, class_id as classId, class_name as className"+
//            " from class natural join grade_major"+
//            "<where>" +
//            "<if test= 'gradeId != null and gradeId != \"\"'>"+
//            "and grade_id = #{gradeId} "+
//            "</if>"+
//            "<if test= 'majorName != null and majorName != \"\"'>"+
//            "and major_name = #{majorName} "+
//            "</if>"+
//            "<if test= 'className != null and className != \"\" '>"+
//            "and `class_name` = #{className} "+
//            "</if>"+
//            "</where>"+
//    "</script>"
//    @Select({"<script>" +
//            "select * from grade_major " +
//                "<where> " +
//                    "grade_id = #{gradeId} and major_name = #{majorName} and user_id = #{userId}" +
//                "</where>" +
//            "</script>"})
//    GradeMajor selectByGradeIdMajorName(@Param("userId") String userId,  @Param("gradeId") String gradeId,@Param("majorName") String majorName);

    @Insert({"insert into grade_major(user_id, grade_id, major_name) values(#{userId}, #{gradeId}, #{majorName})"})
    int addMajor(@Param("userId") String userId, @Param("gradeId") String gradeId, @Param("majorName") String majorName);

    @Select({"select * from grade_major where grade_id = #{gradeId} and major_id = #{majorId} and user_id = #{userId};"})
    GradeMajor selectByGradeIdMajorId(@Param("userId") String userId, @Param("gradeId") String gradeId, @Param("majorId") String majorId);

    @Select({"select major_id from grade_major where grade_id = #{gradeId} and major_name = #{majorName} and user_id = #{userId}"})
    String selectMajorId(@Param("userId") String userId, @Param("gradeId") String gradeId, @Param("majorName") String majorName);

    /**
     * 根据用户id和年级id查询专业
     * @param userId
     * @param gradeId
     * @return
     */
    @Select({"select * from grade_major where user_id = #{userId} and grade_id = #{gradeId}"})
    List<GradeMajor> getAllMajor(@Param("userId") String userId,@Param("gradeId") String gradeId);

//    @Select({"select count(*) from grade_major where grade_id = #{gradeId} and major_name = #{majorName}"})
//    Integer selectSize(@Param("gradeId") String gradeId,@Param("majorName") String majorName);
}
