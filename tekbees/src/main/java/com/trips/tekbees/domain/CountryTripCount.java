package com.trips.tekbees.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryTripCount {

    private String countryName;

    private long totalTrips;
}
