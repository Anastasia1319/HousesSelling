package com.oleshko.HousesSelling.service.impl;

import com.oleshko.HousesSelling.data.dao.HouseRepository;
import com.oleshko.HousesSelling.data.entity.House;
import com.oleshko.HousesSelling.platform.exceptions.NotFoundException;
import com.oleshko.HousesSelling.service.HouseService;
import com.oleshko.HousesSelling.service.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
    private final ConverterService converter;

    @Override
    public List<HouseDto> getAll(Pageable pageable) {
        log.info("Received a list of houses from HouseRepository");
        return houseRepository.findAll(pageable)
                .stream()
                .map(converter::toHouseDto)
                .toList();
    }

    @Override
    public HouseDto getById(Long id) {
        log.info("The HouseRepository method was called to search by id");
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("House with id " + id + " not found"));
        return converter.toHouseDto(house);
    }

    @Override
    public HouseDto save(HouseDto houseDto) {
        House saved = houseRepository.saveAndFlush(converter.toHouseEntity(houseDto));
        log.info("House was saved");
        return converter.toHouseDto(saved);
    }

    @Override
    public void delete(Long id) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("House with id " + id + " not found"));
        houseRepository.delete(house);
        log.info("House with id " + id + " was deleted");
    }
}
