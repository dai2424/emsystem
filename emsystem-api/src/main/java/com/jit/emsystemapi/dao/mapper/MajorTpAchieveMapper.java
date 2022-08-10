package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.MajorTpAchieve;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MajorTpAchieveMapper extends BaseMapper<MajorTpAchieve> {

    @Select({"select * from major_tp_achieve where user_id = #{userId} and tp_id = #{tpId} and major_id = #{majorId}"})
    MajorTpAchieve getMTA(@Param("userId") String userId,
                          @Param("tpId") String tpId,
                          @Param("majorId") String majorId);

    @Insert({"insert into major_tp_achieve(user_id, uid, tp_id, major_id, achievement)" +
                "values(#{userId}, #{uid}, #{tpId}, #{majorId}, #{achievement})"})
    void addData(@Param("userId") String userId,
                 @Param("uid") String uid,
                 @Param("tpId") String tpId,
                 @Param("majorId") String majorId,
                 @Param("achievement") int majorAchieve);

    @Update({"update major_tp_achieve set achievement = #{achievement} where user_id = #{userId} and tp_id = #{tpId};"})
    void upDate(@Param("userId") String userId,
                @Param("tpId") String tpId,
                @Param("achievement") int majorAchieve);

    @Select({"select count(*) from major_tp_achieve where user_id = #{userId} and major_id = #{majorId} and uid = #{uid}"})
    int getGrSize(@Param("userId") String userId,
                  @Param("majorId") String majorId,
                  @Param("uid") String uid);

    @Select({"select min(achievement) from major_tp_achieve where user_id = #{userId} and uid = #{uid} and major_id = #{majorId}"})
    Integer getGrAchievement(@Param("userId") String userId,
                             @Param("uid") String uid,
                             @Param("majorId") String majorId);
}
