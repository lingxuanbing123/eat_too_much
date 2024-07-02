package com.cbl.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartInfo {
    Integer id;
    String user_id;
    Integer good_id;
    String good_name;
    Double good_price;
    Integer good_num;
    Integer business_id;
}
