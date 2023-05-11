package com.trips.tekbees.repositories;

import com.trips.tekbees.domain.CityTripCount;
import com.trips.tekbees.domain.CountryTripCount;
import com.trips.tekbees.domain.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TripRepository extends MongoRepository<Trip, String> {

    Page<Trip> findByCityName(String city, Pageable pageable);

    @Aggregation(pipeline = {
            "{$group: {_id: '$city.name', totalTrips: {$sum: 1}}}",
            "{$project: {_id: 0, city: '$_id', totalTrips: 1}}"
    })
    List<CityTripCount> getTotalTripsByCity();

    @Aggregation(pipeline = {
            "{$group: {_id: '$country.name', totalTrips: {$sum: 1}}}"
    })
    List<CountryTripCount> getTotalTripsByCountry();
}




































