package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.Class;
import com.jit.emsystemapi.vo.MajorClassVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper extends BaseMapper<Class> {
    @Select({"<script>"+
                "select grade_id as gradeId, major_name as majorName, class_id as classId, class_name as className"+
                " from class, grade_major"+
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
}
