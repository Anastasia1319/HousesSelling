package com.oleshko.HousesSelling.data.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class House {

    private Long id;
    private HouseAddress address;
    private Double houseArea;
    private Integer yearBuilt;
    private Integer floorCount;
    private BigDecimal price;
}
