package com.oleshko.HousesSelling.data.dao;

import com.oleshko.HousesSelling.data.entity.HouseAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseAddressRepository extends JpaRepository<HouseAddress, Long> {
}
