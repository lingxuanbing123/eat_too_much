package com.cbl.backend.mapper;

import com.cbl.backend.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * from user where user_name = #{user_name} and password = #{password}")
    User getUserByNameAndPasswd(@Param("user_name") String user_name, @Param("password")String password);
}
