package com.oleshko.HousesSelling.service;

import com.oleshko.HousesSelling.service.dto.HouseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HouseService {
    List<HouseDto> getAll(Pageable pageable);

    HouseDto getById(Long id);

    HouseDto save(HouseDto houseDto);

    void delete(Long id);
}
