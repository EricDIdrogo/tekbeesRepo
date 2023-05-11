package com.trips.tekbees.service;


import com.trips.tekbees.domain.CityTripCount;
import com.trips.tekbees.domain.CountryTripCount;
import com.trips.tekbees.domain.RidePagedList;
import com.trips.tekbees.domain.Trip;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TripsService {

    Long count();

    List<CityTripCount> getTotalRidesByCity();

    List<CountryTripCount> getTotalRidesByCountry();

    Trip createRide(Trip trip);

    Trip updateRide(String id, Trip trip);

    RidePagedList findByCityName(String city, Pageable pageable);


}
