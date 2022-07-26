package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.Class;
import com.jit.emsystemapi.vo.MajorClassVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper extends BaseMapper<Class> {
    @Select({"<script>"+
                "select grade_id as gradeId, major_name as majorName, class_id as classId, class_name as className"+
                " from class natural join grade_major"+
                "<where>" +
                    "<if test= 'gradeId != null and gradeId != \"\"'>"+
                        "and grade_id = #{gradeId} "+
                    "</if>"+
                    "<if test= 'majorName != null and majorName != \"\"'>"+
                        "and major_name = #{majorName} "+
                    "</if>"+
                    "<if test= 'classId != null and classId != \"\" '>"+
                        "and `class_id` = #{classId} "+
                    "</if>"+
                "</where>"+
            "</script>"})
    List<MajorClassVo> selectAllMajorClass(@Param("gradeId") String gradeId, @Param("majorName") String majorName, @Param("classId") String classId);

    @Select({"select * from class where class_name = #{className} and major_id = #{majorId};"})
    Class selectClassByName(@Param("className") String className,@Param("majorId") String majorId);

    @Insert({"insert into class(major_id, class_name) values(#{majorId}, #{className});"})
    int addClassByName(@Param("majorId") String majorId, @Param("className") String classname);

    @Select({"select * from class where class_id = #{classId}"})
    Class selectClassById(@Param("classId") String classId);

    @Delete({"delete from class where class_id = #{classId};"})
    int deleteClassById(@Param("classId") String classId);
}
