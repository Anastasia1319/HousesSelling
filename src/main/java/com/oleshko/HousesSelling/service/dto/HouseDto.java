package com.oleshko.HousesSelling.service.dto;

import com.oleshko.HousesSelling.data.entity.HouseAddress;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HouseDto {
    private Long id;

    private HouseAddress address;

    private Double houseArea;

    private Integer yearBuilt;

    private Integer floorCount;

    private BigDecimal price;

    private String realEstateAgency;
}
