package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.GradeMajor;
import com.jit.emsystemapi.vo.MajorVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GradeMajorMapper extends BaseMapper<GradeMajor> {

    @Select({"select distinct grade_id from grade_major"})
    List<String> getAllGrade();

    @Select({"select major_id as id, major_name as label from grade_major where grade_id = #{gradeId}"})
    List<MajorVo> getMajorByGradeId(String gradeId);

    @Select({"select * from grade_major where grade_id = #{gradeId} and major_name = #{majorName} limit 1"})
    GradeMajor selectByGradeIdMajorName(@Param("gradeId") String gradeId,@Param("majorName") String majorName);

    @Insert({"insert into grade_major(grade_id, major_name) values( #{gradeId}, #{majorName})"})
    int addMajor(@Param("gradeId") String gradeId,@Param("majorName") String majorName);

    @Select({"select * from grade_major where grade_id = #{gradeId} and major_id = #{majorId};"})
    GradeMajor selectByGradeIdMajorId(@Param("gradeId") String gradeId, @Param("majorId") String majorId);

    @Select({"select major_id from grade_major where grade_id = #{gradeId} and major_name = #{majorName}"})
    String selectMajorId(@Param("gradeId") String gradeId,@Param("majorName") String majorName);

//    @Select({"select count(*) from grade_major where grade_id = #{gradeId} and major_name = #{majorName}"})
//    Integer selectSize(@Param("gradeId") String gradeId,@Param("majorName") String majorName);
}
