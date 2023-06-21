package com.oleshko.HousesSelling.data.entity;

import lombok.Data;

@Data
public class HouseAddress {
    private Long id;
    private String region;
    private LocalityType localityType;
    private String localityName;
    private String street;
    private String houseNumber;


    public enum LocalityType {
        CITY, VILLAGE, FARM
    }
}
