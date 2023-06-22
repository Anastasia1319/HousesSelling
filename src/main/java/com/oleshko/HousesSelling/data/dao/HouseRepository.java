package com.oleshko.HousesSelling.data.dao;

import com.oleshko.HousesSelling.data.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
