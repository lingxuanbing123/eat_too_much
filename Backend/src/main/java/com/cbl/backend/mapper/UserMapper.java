package com.cbl.backend.mapper;

import com.cbl.backend.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * from user where username = #{username} and password = #{password}")
    User getUserByNameAndPasswd(@Param("username") String username, @Param("password")String password);
}
