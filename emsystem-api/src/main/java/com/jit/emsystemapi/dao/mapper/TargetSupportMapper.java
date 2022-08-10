package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.TargetSupport;
import com.jit.emsystemapi.vo.support.SupportGradeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TargetSupportMapper extends BaseMapper<TargetSupport> {

    @Select({"select type_encoding as typeEncoding, rank_num as gradeNum from target_support where user_id = #{userId}; "})
    List<SupportGradeVo> findByUserId(@Param("userId") String userId);

    @Insert({"insert into target_support(user_id, type_encoding) values(#{userId}, #{typeEncoding})"})
    void addDataByUserId(@Param("userId") String userId, @Param("typeEncoding") String typeEncoding);

    @Update({"update target_support set rank_num = #{gradeNum} where user_id = #{userId} and type_encoding = #{typeEncoding}"})
    Integer updateGradeNum(@Param("userId") String userId,
                        @Param("typeEncoding") String typeEncoding,
                        @Param("gradeNum") String gradeNum);

    @Select({"select rank_num from target_support where user_id = #{userId} and type_encoding = '支撑数';"})
    int selectMaxDegree(@Param("userId") String userId);

    @Select({"select rank_num from target_support where user_id = #{userId} and type_encoding = '学生评分占比';"})
    Integer getStudentPercent(@Param("userId") String userId);
}
