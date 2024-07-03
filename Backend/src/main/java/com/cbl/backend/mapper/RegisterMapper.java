package com.cbl.backend.mapper;

import com.cbl.backend.entity.User;
import org.apache.ibatis.annotations.Insert;

public interface RegisterMapper {


    @Insert("INSERT INTO `user`(userid,username,password) VALUES(#{userid},#{username},#{password})")
    void save(User user);
}
