package com.cbl.backend.mapper;

import com.cbl.backend.entity.Address;
import com.cbl.backend.entity.Good;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AddressMapper {
    @Select("SELECT * FROM address WHERE userid = #{userid} ORDER BY id desc")
    List<Address> getAddressByUId(@Param("userid") String userid);

    @Insert("INSERT INTO `address`(address,userid) VALUES(#{address},#{userid})")
    void save(Address address);

    @Delete("DELETE FROM address WHERE id = #{id}")
    void delete(@Param("id") int id);
}
