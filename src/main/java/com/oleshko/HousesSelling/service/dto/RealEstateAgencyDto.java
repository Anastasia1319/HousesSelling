package com.oleshko.HousesSelling.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class RealEstateAgencyDto {
    private Long id;

    private String agencyName;

    private String phoneNumber;

    private String website;

    private String email;

    private List<HouseDto> housesDto;
}
