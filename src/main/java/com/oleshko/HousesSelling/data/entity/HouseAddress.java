package com.oleshko.HousesSelling.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "house_addresses")
@Data
public class HouseAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "region")
    private String region;

    @Column(name = "locality_type")
    @Enumerated(EnumType.STRING)
    private LocalityType localityType;

    @Column(name = "locality_name")
    private String localityName;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;


    public enum LocalityType {
        CITY, VILLAGE, FARM
    }
}
