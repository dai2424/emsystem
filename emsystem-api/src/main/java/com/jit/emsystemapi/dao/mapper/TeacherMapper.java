package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.Teacher;
import com.jit.emsystemapi.vo.teacher.TeacherVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select({"select * from teacher where user_id = #{userId} and t_no = #{teacherNo}"})
    Teacher selectByNo(@Param("userId") String userId,@Param("teacherNo") String teacherNo);

    @Insert({"insert into teacher(user_id, t_no, t_name, t_password, status) values(#{userId}, #{teacherNo}, #{teacherName}, #{teacherPassword}, true) ;"})
    void addTeacher(@Param("userId") String userId,
                    @Param("teacherNo") String teacherNo,
                    @Param("teacherName") String teacherName,
                    @Param("teacherPassword") String teacherPassword);

    @Update({"update teacher set t_password = #{teacherPassword}, t_name = #{teacherName} where user_id = #{userId} and t_no = #{teacherNo}"})
    void editPassword(@Param("userId") String userId,
                      @Param("teacherNo") String teacherNo,
                      @Param("teacherName") String teacherName,
                      @Param("teacherPassword") String teacherPassword);

    @Delete({"delete from teacher where user_id = #{userId} and t_no = #{teacherNo};"})
    int deleteTeacher(@Param("userId") String userId,@Param("teacherNo") String teacherNo);

    @Select({"<script> " +
                "select t_no as teacherNo, t_name as teacherName, t_password as teacherPassword, status from teacher" +
                "<where> " +
                    "<if test = 'userId != null and userId != \"\"' > "+
                        "and user_id = #{userId} " +
                    "</if>" +
                    "<if test = 'teacherNo != null and teacherNo != \"\"' > "+
                        "and t_no = #{teacherNo} " +
                    "</if>" +
                    "<if test = 'teacherName != null and teacherName != \"\"' > "+
                        "and t_name LIKE  CONCAT('%',#{teacherName},'%') " +
                    "</if>" +
                "</where> " +
            "</script>"})
    List<TeacherVo> selectTeachers(@Param("userId") String userId,
                                   @Param("teacherNo") String teacherNo,
                                   @Param("teacherName") String teacherName);


    @Update({"update teacher set status = #{status} where user_id = #{userId} and t_no = #{teacherNo}; "})
    void editStatus(@Param("userId") String userId,@Param("teacherNo") String teacherNo,@Param("status") boolean status);

    @Select({"select * from teacher where t_no = #{teacherNo} and t_password = #{teacherPassword}"})
    Teacher selectUserId(@Param("teacherNo") String teacherNo,@Param("teacherPassword") String teacherPassword);

    @Select({"select * from teacher where user_id = #{userId} and t_name like concat('%', #{teacherName}, '%')"})
    List<Teacher> getTeacherByName(@Param("userId") String userId,@Param("teacherName") String teacherName);
}
