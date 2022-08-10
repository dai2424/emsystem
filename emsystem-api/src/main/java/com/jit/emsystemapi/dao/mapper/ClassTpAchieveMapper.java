package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.ClassTpAchieve;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ClassTpAchieveMapper extends BaseMapper<ClassTpAchieve> {

    @Insert({"insert into class_tp_achieve(user_id, major_id, tp_id, class_id, achievement, uid) " +
                "values(#{userId}, #{majorId}, #{tpId}, #{classId}, #{achievement}, #{uid})"})
    void addDate(@Param("userId") String userId,
                 @Param("majorId") String majorId,
                 @Param("tpId") String tpId,
                 @Param("classId") String classId,
                 @Param("achievement") Integer tpAchievement,
                 @Param("uid") String uid);

    @Select({"select * from class_tp_achieve where user_id = #{userId} and tp_id = #{tpId} and class_id = #{classId}"})
    ClassTpAchieve getCTA(@Param("userId") String userId,
                          @Param("tpId") String tpId,
                          @Param("classId") String classId);

    @Update({"update class_tp_achieve set achievement = #{achievement} where user_id = #{userId} and tp_id = #{tpId} and class_id = #{classId}; "})
    void upDate(@Param("userId") String userId,
                @Param("tpId") String tpId,
                @Param("classId") String classId,
                @Param("achievement") Integer tpAchievement);

    @Select({"select count(*) from class_tp_achieve where user_id = #{userId} and uid = #{uid} and class_id = #{classId};"})
    int getGrSize(@Param("userId") String userId, @Param("uid") String uid, @Param("classId") String classId);

    @Select({"select min(achievement) from class_tp_achieve where user_id = #{userId} and uid = #{uid} and class_id = #{classId};"})
    Integer getGrAchievement(@Param("userId") String userId,
                             @Param("uid") String uid,
                             @Param("classId") String classId);

    @Select({"select count(*) from class_tp_achieve where user_id = #{userId} and tp_id = #{tpId} and major_id = #{majorId}"})
    int getTpSize(@Param("userId") String userId,
                  @Param("tpId") String tpId,
                  @Param("majorId") String majorId);

    @Select({"select avg(achievement) from class_tp_achieve where user_id = #{userId} and tp_id = #{tpId} and major_id = #{majorId}"})
    Integer getMajorAchieve(@Param("userId") String userId,
                        @Param("tpId") String tpId,
                        @Param("majorId") String majorId);
}
