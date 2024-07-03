package com.cbl.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartInfo {
    Integer id;
    String userId;
    Integer goodId;
    String goodName;
    Double goodPrice;
    Integer goodNum;
    Integer businessId;
}
