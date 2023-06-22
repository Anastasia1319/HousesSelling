package com.oleshko.HousesSelling.data.dao;

import com.oleshko.HousesSelling.data.entity.RealEstateAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateAgencyRepository extends JpaRepository<RealEstateAgency, Long> {
    RealEstateAgency findByAgencyName(String agencyName);
}
