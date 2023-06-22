package com.oleshko.HousesSelling.service.impl;

import com.oleshko.HousesSelling.data.dao.RealEstateAgencyRepository;
import com.oleshko.HousesSelling.data.entity.RealEstateAgency;
import com.oleshko.HousesSelling.platform.exceptions.NotFoundException;
import com.oleshko.HousesSelling.service.RealEstateAgencyService;
import com.oleshko.HousesSelling.service.dto.RealEstateAgencyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class RealEstateAgencyServiceImpl implements RealEstateAgencyService {
    private final RealEstateAgencyRepository agencyRepository;
    private final ConverterService converter;

    @Override
    public List<RealEstateAgencyDto> getAll(Pageable pageable) {
        log.info("Received a list of real estate agency from RealEstateAgencyRepository");
        return agencyRepository.findAll(pageable)
                .stream()
                .map(converter::toRealEstateAgencyDto)
                .toList();
    }

    @Override
    public RealEstateAgencyDto getById(Long id) {
        log.info("The RealEstateAgencyRepository method was called to search by id");
        RealEstateAgency realEstateAgency = agencyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RealEstateAgency with id " + id + " not found"));
        return converter.toRealEstateAgencyDto(realEstateAgency);
    }

    @Override
    public RealEstateAgencyDto save(RealEstateAgencyDto realEstateAgencyDto) {
        RealEstateAgency saved = agencyRepository.saveAndFlush(
                converter.toRealEstateAgencyEntity(realEstateAgencyDto));
        log.info("RealEstateAgency was saved");
        return converter.toRealEstateAgencyDto(saved);
    }

    @Override
    public void delete(Long id) {
        RealEstateAgency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("House with id " + id + " not found"));
        agencyRepository.delete(agency);
        log.info("RealEstateAgency with id " + id + " was deleted");
    }
}
