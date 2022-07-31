package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.TargetPoint;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TargetPointMapper extends BaseMapper<TargetPoint> {

    @Insert({"insert into target_point(user_id, uid, tp_no, content) values(#{userId}, #{uid}, #{pointNo}, #{content})"})
    void addByUid(@Param("userId") String userId,
                  @Param("uid") String uid,
                  @Param("pointNo") String pointNo,
                  @Param("content") String content );

    @Update({"update target_point set tp_no = #{pointNo}, content = #{content}, uid = #{uid} where user_id = #{userId} and tp_id = #{pointId}"})
    void updateByUid(@Param("userId") String userId,
                     @Param("pointId") String pointId,
                     @Param("uid") String uid,
                     @Param("content") String content,
                     @Param("pointNo") String pointNo);

    @Delete({"delete from target_point where user_id = #{userId} and tp_id = #{pointId}"})
    void deleteById(@Param("userId") String userId,@Param("pointId") String pointId);

    @Select({"<script> " +
                "select * from target_point " +
                    "<where> " +
                        "<if test = 'userId != null and userId != \"\"' > "+
                            "and user_id = #{userId} " +
                        "</if>" +
                        "<if test = 'uid != null and userId != \"\"' > "+
                            "and uid = #{uid} " +
                        "</if>" +
                        "<if test = 'pointNo != null and pointNo != \"\"' > "+
                            "and tp_no = #{pointNo} " +
                        "</if>" +
                        "<if test= 'content != null and content != \"\" '>"+
                        " and content  LIKE  CONCAT('%',#{content},'%') "+
                        "</if>"+
                    "</where>" +
            "</script>"})
    List<TargetPoint> selectByUNC(@Param("userId") String userId,
                                  @Param("uid") String uid,
                                  @Param("pointNo") String pointNo,
                                  @Param("content") String pointContent);
}
