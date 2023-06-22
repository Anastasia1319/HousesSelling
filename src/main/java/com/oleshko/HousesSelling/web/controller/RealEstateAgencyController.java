package com.oleshko.HousesSelling.web.controller;

import com.oleshko.HousesSelling.service.RealEstateAgencyService;
import com.oleshko.HousesSelling.service.dto.RealEstateAgencyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencies")
@RequiredArgsConstructor
public class RealEstateAgencyController {
    private final RealEstateAgencyService agencyService;

    @GetMapping("/{id}")
    public RealEstateAgencyDto get(@PathVariable Long id) {
        return agencyService.getById(id);
    }

    @GetMapping
    public List<RealEstateAgencyDto> getAll(Pageable pageable) {
        return agencyService.getAll(pageable);
    }

    @PostMapping
    public RealEstateAgencyDto creat(@RequestBody RealEstateAgencyDto agencyDto) {
        return agencyService.save(agencyDto);
    }

    @PutMapping("/{id}")
    public RealEstateAgencyDto update(@PathVariable Long id, @RequestBody RealEstateAgencyDto agencyDto) {
        agencyDto.setId(id);
        return agencyService.save(agencyDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        agencyService.delete(id);
    }
}
