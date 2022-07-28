package com.jit.emsystemapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.emsystemapi.dao.pojo.Sysuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SysuserMapper extends BaseMapper<Sysuser> {

    @Select({"select * from sysuser where username = #{username} and password = #{password}"})
    Sysuser findUserByNamePass(@Param("username") String username,@Param("password") String password);

    @Update(("update sysuser set password = #{newPassword} where username = #{username} and password = #{password}"))
    void updatePassword(@Param("username") String username,@Param("password") String password,@Param("newPassword") String newPassword);
}
