package com.cbl.backend.mapper;

import com.cbl.backend.entity.Business;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BusinessMapper {
    @Select("SELECT * FROM `business_info`")
    List<Business> getAll();
}
