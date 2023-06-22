/*
DROP TABLE houses;
DROP TABLE house_addresses;
DROP TABLE real_estate_agencies;
*/

CREATE TABLE IF NOT EXISTS real_estate_agencies
(
    "id"         BIGSERIAL PRIMARY KEY,
    agency_name  VARCHAR(300),
    phone_number VARCHAR(100),
    website      VARCHAR(100) UNIQUE NOT NULL,
    email        VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS house_addresses
(
    "id"          BIGSERIAL PRIMARY KEY,
    region        VARCHAR(300),
    locality_type VARCHAR(300),
    locality_name VARCHAR(300),
    street        VARCHAR(300),
    house_number  VARCHAR(300)
);

CREATE TABLE IF NOT EXISTS houses
(
    "id"                  BIGSERIAL PRIMARY KEY,
    house_addresses_id    INT8          NOT NULL,
    house_area            NUMERIC(9, 2) NOT NULL,
    year_built            INT,
    floor_count           INT,
    price                 NUMERIC(9, 2) NOT NULL,
    real_estate_agency_id INT8          NOT NULL,
    FOREIGN KEY (house_addresses_id) REFERENCES house_addresses ("id"),
    FOREIGN KEY (real_estate_agency_id) REFERENCES real_estate_agencies ("id")
);

