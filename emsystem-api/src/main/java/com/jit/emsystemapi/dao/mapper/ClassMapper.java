package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.Class;
import com.jit.emsystemapi.vo.GMC.MajorClassVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper extends BaseMapper<Class> {
    @Select({"<script>"+
                "select grade_id as gradeId, major_name as majorName, class_id as classId, class_name as className"+
                " from class natural join grade_major"+
                "<where>" +
                    "<if test= 'userId != null and userId != \"\"'>"+
                        "and user_id = #{userId} "+
                    "</if>"+
                    "<if test= 'gradeId != null and gradeId != \"\"'>"+
                        "and grade_id = #{gradeId} "+
                    "</if>"+
                    "<if test= 'majorName != null and majorName != \"\"'>"+
                        "and major_name = #{majorName} "+
                    "</if>"+
                    "<if test= 'className != null and className != \"\" '>"+
                        "and `class_name` = #{className} "+
                    "</if>"+
                "</where>"+
            "</script>"})
    List<MajorClassVo> selectAllMajorClass(@Param("userId") String userId, @Param("gradeId") String gradeId, @Param("majorName") String majorName, @Param("className") String className);

    @Select({"select * from class where class_name = #{className} and major_id = #{majorId} and user_id = #{userId};"})
    Class selectClassByName(@Param("userId") String userId, @Param("className") String className, @Param("majorId") String majorId);

    @Insert({"insert into class(user_id, major_id, class_name) values(#{userId}, #{majorId}, #{className});"})
    int addClassByName(@Param("userId") String userId, @Param("majorId") String majorId, @Param("className") String classname);

    @Select({"select * from class where class_id = #{classId} and user_id = #{userId}"})
    Class selectClassById(@Param("userId") String id, @Param("classId") String classId);

    @Delete({"delete from class where class_id = #{classId} and user_id = #{userId};"})
    int deleteClassById(@Param("userId") String userId, @Param("classId") String classId);

    @Select({"select * from class where user_id = #{userId} and major_id = #{majorId}"})
    List<Class> getClassByMajorId(@Param("userId") String userId,@Param("majorId") Integer majorId);

    @Select({"select major_id from class where user_id = #{userId} and class_id = #{classId}"})
    String getMajorId(@Param("userId") String userId,@Param("classId") String classId);

    @Select({"select class_name from class where user_id = #{userId} and class_id = #{classId}"})
    String getNameById(@Param("userId") String userId,@Param("classId") Integer classId);

    @Select({"select count(*) from class where user_id = #{userId} and major_id = #{majorId}"})
    int getClassSize(@Param("userId") String userId,@Param("majorId") String majorId);
}
