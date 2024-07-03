package com.cbl.backend.mapper;

import com.cbl.backend.entity.Good;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodMapper {

    @Select("SELECT * FROM good_info WHERE businessId = #{businessId} ORDER BY goodId desc;")
    List<Good> getGoodByBusinessId(@Param("businessId") String businessId);

    @Insert("INSERT INTO good_info(goodName,goodPrice,businessId) VALUES(#{goodName},#{goodPrice},#{businessId})")
    void addGood(Good good);

    @Delete("DELETE FROM good_info WHERE goodId = #{goodId}")
    void deleteGoodByGoodId(@Param("goodId") int goodId);
}
