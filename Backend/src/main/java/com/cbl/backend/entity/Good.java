package com.cbl.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Good {
    private String goodName;
    private double goodPrice;
    private int goodId;
    private int businessId;
}
