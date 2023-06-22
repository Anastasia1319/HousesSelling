package com.oleshko.HousesSelling.service.impl;

import com.oleshko.HousesSelling.data.dao.RealEstateAgencyRepository;
import com.oleshko.HousesSelling.data.entity.House;
import com.oleshko.HousesSelling.data.entity.RealEstateAgency;
import com.oleshko.HousesSelling.service.dto.HouseDto;
import com.oleshko.HousesSelling.service.dto.RealEstateAgencyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Log4j2
public class ConverterService {
    private final RealEstateAgencyRepository agencyRepository;

    public House toHouseEntity(HouseDto houseDto) {
        House house = new House();
        house.setId(houseDto.getId());
        house.setAddress(houseDto.getAddress());
        house.setHouseArea(houseDto.getHouseArea());
        house.setYearBuilt(houseDto.getYearBuilt());
        house.setFloorCount(houseDto.getFloorCount());
        house.setPrice(houseDto.getPrice());
        house.setAgencyId(agencyRepository.findByAgencyName(houseDto.getRealEstateAgency()));
        log.info("HouseDto transformed to House");
        return house;
    }

    public HouseDto toHouseDto(House house) {
        HouseDto houseDto = new HouseDto();
        houseDto.setId(house.getId());
        houseDto.setAddress(house.getAddress());
        houseDto.setHouseArea(house.getHouseArea());
        houseDto.setYearBuilt(house.getYearBuilt());
        houseDto.setFloorCount(house.getFloorCount());
        houseDto.setPrice(house.getPrice());
        houseDto.setRealEstateAgency(house.getAgencyId().getAgencyName());
        log.info("House transformed to HouseDto");
        return houseDto;
    }

    public RealEstateAgencyDto toRealEstateAgencyDto(RealEstateAgency realEstateAgency) {
        RealEstateAgencyDto realEstateAgencyDto = new RealEstateAgencyDto();
        realEstateAgencyDto.setId(realEstateAgency.getId());
        realEstateAgencyDto.setAgencyName(realEstateAgency.getAgencyName());
        realEstateAgencyDto.setPhoneNumber(realEstateAgency.getPhoneNumber());
        realEstateAgencyDto.setWebsite(realEstateAgency.getWebsite());
        realEstateAgencyDto.setEmail(realEstateAgency.getEmail());
        realEstateAgencyDto.setHousesDto(realEstateAgency.getHouses()
                .stream()
                .map(this::toHouseDto)
                .collect(Collectors.toList()));
        log.info("RealEstateAgency transformed to RealEstateAgencyDto");
        return realEstateAgencyDto;
    }

    public RealEstateAgency toRealEstateAgencyEntity(RealEstateAgencyDto realEstateAgencyDto) {
        RealEstateAgency realEstateAgency = new RealEstateAgency();
        realEstateAgency.setId(realEstateAgencyDto.getId());
        realEstateAgency.setAgencyName(realEstateAgencyDto.getAgencyName());
        realEstateAgency.setPhoneNumber(realEstateAgencyDto.getPhoneNumber());
        realEstateAgency.setWebsite(realEstateAgencyDto.getWebsite());
        realEstateAgency.setEmail(realEstateAgencyDto.getEmail());
        realEstateAgency.setHouses(realEstateAgencyDto.getHousesDto()
                .stream()
                .map(this::toHouseEntity)
                .collect(Collectors.toList()));
        log.info("RealEstateAgencyDto transformed to RealEstateAgency");
        return realEstateAgency;
    }
}
