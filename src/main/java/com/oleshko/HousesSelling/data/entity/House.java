package com.oleshko.HousesSelling.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "houses")
@Data
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_addresses_id")
    private HouseAddress address;

    @Column(name = "house_area ", nullable = false)
    private Double houseArea;

    @Column(name = "year_built")
    private Integer yearBuilt;

    @Column(name = "floor_count")
    private Integer floorCount;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "real_estate_agency_id", nullable = false)
    private RealEstateAgency agencyId;
}
