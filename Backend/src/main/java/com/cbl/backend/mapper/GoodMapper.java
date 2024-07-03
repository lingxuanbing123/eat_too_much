package com.cbl.backend.mapper;

import com.cbl.backend.entity.Good;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GoodMapper {

    @Select("SELECT * FROM good_info WHERE businessId = #{businessId} ORDER BY goodId desc;")
    Good getGoodByBuId(@Param("businessId") String businessId);
}
