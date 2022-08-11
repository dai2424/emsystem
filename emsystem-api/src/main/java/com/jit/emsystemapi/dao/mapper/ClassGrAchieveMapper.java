package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.ClassGrAchieve;
import com.jit.emsystemapi.dao.pojo.MajorGrAchieve;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassGrAchieveMapper extends BaseMapper<ClassGrAchieve> {

    @Select({"select * from class_gr_achieve where user_id = #{userId} and uid = #{uid} and class_id = #{classId}"})
    ClassGrAchieve getCGA(@Param("userId") String userId,
                          @Param("uid") String uid,
                          @Param("classId") String classId);

    @Insert({"insert into class_gr_achieve(user_id, major_id, class_id, uid, achievement) " +
                "values(#{userId}, #{majorId}, #{classId}, #{uid}, #{achievement})"})
    void addData(@Param("userId") String userId,
                 @Param("classId") String classId,
                 @Param("uid") String uid,
                 @Param("achievement") Integer grAchievement,
                 @Param("majorId") String majorId);

    @Update({"update class_gr_achieve set achievement = #{achievement} where user_id = #{userId} and class_id = #{classId} and uid = #{uid}"})
    void upDate(@Param("userId") String userId,
                @Param("classId") String classId,
                @Param("uid") String uid,
                @Param("achievement") Integer grAchievement);


    @Select({"select * from class_gr_achieve where user_id = #{userId} and class_id = #{classId}"})
    List<ClassGrAchieve> getMGAs(@Param("userId") String userId,
                                 @Param("classId") String classId);
}
