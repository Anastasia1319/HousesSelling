package com.oleshko.HousesSelling.service;

import com.oleshko.HousesSelling.service.dto.RealEstateAgencyDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RealEstateAgencyService {
    List<RealEstateAgencyDto> getAll(Pageable pageable);

    RealEstateAgencyDto getById(Long id);

    RealEstateAgencyDto save(RealEstateAgencyDto realEstateAgencyDto);

    void delete(Long id);
}
