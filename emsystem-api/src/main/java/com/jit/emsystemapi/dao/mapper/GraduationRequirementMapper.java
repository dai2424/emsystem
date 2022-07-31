package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.GraduationRequirement;
import com.jit.emsystemapi.vo.graduation.GraduationReqVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GraduationRequirementMapper extends BaseMapper<GraduationRequirement> {

    @Select({"<script>"+
                "select grade_id as gradeId, major_name as majorName, `no` as noSearch, content as contentSearch, uid " +
                    "from grade_major natural join graduation_requirement "+
                    "<where>" +
                        "<if test= 'gradeId != null and gradeId != \"\"'>"+
                            "and grade_id = #{gradeId} "+
                        "</if>"+
                        "<if test= 'majorName != null and majorName != \"\"'>"+
                            "and major_name = #{majorName} "+
                        "</if>"+
                        "<if test= 'no != null and no != \"\" '>"+
                            "and `no` = #{no} "+
                        "</if>"+
                        "<if test= 'content != null and content != \"\" '>"+
                            " and content  LIKE  CONCAT('%',#{content},'%') "+
                        "</if>"+
                    "</where>"+
            "</script>"})
    List<GraduationReqVo> getAllGraduationReq(@Param("gradeId") String gradeId,
                                              @Param("majorName") String majorName,
                                              @Param("no") String no,
                                              @Param("content") String content);

    @Delete({"delete from graduation_requirement where uid = #{uid}"})
    int deleteByNo(@Param("uid") String uid);

    @Update({"update graduation_requirement set content = #{content} where uid = #{uid}"})
    Integer updateById(@Param("uid") String uid,@Param("content") String content);

    @Select({"select count(*) from graduation_requirement where major_id = #{majorId}"})
    Integer selectSizeByMajorId(@Param("majorId") String majorId);

    @Insert({"insert into graduation_requirement(grade_id, major_id, content, no) values(#{gradeId}, #{majorId}, #{content}, #{no})"})
    void addReq(@Param("gradeId") String gradeId,
                @Param("majorId") String majorId,
                @Param("content") String content,
                @Param("no") Integer size);

    @Select({"<script>"+
            "select * " +
            "from graduation_requirement "+
                "<where>" +
                    "<if test= 'userId != null and userId != \"\"'>"+
                        "and user_id = #{userId} "+
                    "</if>"+
                    "<if test= 'majorId != null '>"+
                        "and major_id = #{majorId} "+
                    "</if>"+
                    "<if test= 'no != null and no != \"\" '>"+
                        "and `no` = #{no} "+
                    "</if>"+
                "</where>"+
            "</script>"})
    List<GraduationRequirement> selectUids(@Param("userId") String userId,@Param("majorId") Integer majorId,@Param("no") String graduationNo);
}
