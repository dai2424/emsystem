package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.MajorGrAchieve;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MajorGrAchieveMapper extends BaseMapper<MajorGrAchieve> {

    @Select({"select * from major_gr_achieve where user_id = #{userId} and uid = #{uid} and major_id = #{majorId}"})
    MajorGrAchieve getMGA(@Param("userId") String userId,
                          @Param("uid") String uid,
                          @Param("majorId") String majorId);

    @Insert({"insert into major_gr_achieve(user_id, uid, achievement, major_id) " +
                "values(#{userId}, #{uid}, #{achievement}, #{majorId})"})
    void addData(@Param("userId") String userId,
                 @Param("uid") String uid,
                 @Param("achievement") Integer grAchievement,
                 @Param("majorId") String majorId);

    @Update({"update major_gr_achieve set achievement = #{achievement} where user_id = #{userId} and uid = #{uid} and major_id = #{majorId};"})
    void upDate(@Param("userId") String userId,
                @Param("uid") String uid,
                @Param("achievement") Integer grAchievement,
                @Param("majorId") String majorId);

    @Select({"select * from major_gr_achieve where user_id = #{userId} and major_id = #{majorId}"})
    List<MajorGrAchieve> getMGAs(@Param("userId") String userId,@Param("majorId") String majorId);
}
