package com.cbl.backend.mapper;

import com.cbl.backend.entity.Good;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodMapper {

    @Select("SELECT * FROM good_info WHERE businessId = #{businessId} ORDER BY goodId desc;")
    List<Good> getGoodByBusinessId(@Param("businessId") int businessId);

}
