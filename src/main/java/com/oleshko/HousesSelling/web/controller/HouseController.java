package com.oleshko.HousesSelling.web.controller;

import com.oleshko.HousesSelling.service.HouseService;
import com.oleshko.HousesSelling.service.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
@RequiredArgsConstructor
public class HouseController {
    private final HouseService houseService;

    @GetMapping("/{id}")
    public HouseDto get(@PathVariable Long id) {
        return houseService.getById(id);
    }

    @GetMapping
    public List<HouseDto> getAll(Pageable pageable) {
        return houseService.getAll(pageable);
    }

    @PostMapping
    public HouseDto creat(@RequestBody HouseDto houseDto) {
        return houseService.save(houseDto);
    }

    @PutMapping("/{id}")
    public HouseDto update(@PathVariable Long id, @RequestBody HouseDto houseDto) {
        houseDto.setId(id);
        return houseService.save(houseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        houseService.delete(id);
    }
}
