package com.oleshko.HousesSelling.data.entity;

import lombok.Data;

import java.util.List;

@Data
public class RealEstateAgency {
    private Long id;
    private String agencyName;
    private String phoneNumber;
    private String website;
    private String email;
    private List<House> houses;
}
