package com.cbl.backend.mapper;

import com.cbl.backend.entity.Good;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AddressMapper {
    @Select("SELECT * FROM address WHERE userid = #{userid} ORDER BY id desc;")
    Good getAddressByUId(@Param("userId") String userId);
}
