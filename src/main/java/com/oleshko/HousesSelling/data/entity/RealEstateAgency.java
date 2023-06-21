package com.oleshko.HousesSelling.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "real_estate_agencies")
@Data
public class RealEstateAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "agency_name")
    private String agencyName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "website")
    private String website;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "agencyId", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<House> houses;
}
