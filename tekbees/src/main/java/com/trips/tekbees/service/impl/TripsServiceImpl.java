package com.trips.tekbees.service.impl;

import com.trips.tekbees.domain.CityTripCount;
import com.trips.tekbees.domain.CountryTripCount;
import com.trips.tekbees.domain.RidePagedList;
import com.trips.tekbees.domain.Trip;
import com.trips.tekbees.exceptions.TripNotFoundException;
import com.trips.tekbees.repositories.TripRepository;
import com.trips.tekbees.service.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripsServiceImpl implements TripsService {

    @Autowired
    private TripRepository repository;

    public Long count() {
        return this.repository.count();
    }

    @Override
    public List<CityTripCount> getTotalRidesByCity() {
        return this.repository.getTotalTripsByCity();
    }

    @Override
    public List<CountryTripCount> getTotalRidesByCountry() {
        return this.repository.getTotalTripsByCountry();
    }

    @Override
    public Trip createRide(Trip trip) {
        return this.repository.save(trip);
    }

    @Override
    public Trip updateRide(String id, Trip updatedTrip) {

        Trip existingTrip = noNullTrip(id);

        existingTrip.setStart(updatedTrip.getStart());
        existingTrip.setEnd(updatedTrip.getEnd());
        existingTrip.setCountry(updatedTrip.getCountry());
        existingTrip.setCity(updatedTrip.getCity());
        existingTrip.setPassenger(updatedTrip.getPassenger());
        existingTrip.setDriver(updatedTrip.getDriver());
        existingTrip.setCar(updatedTrip.getCar());
        existingTrip.setStatus(updatedTrip.getStatus());
        existingTrip.setCheckCode(updatedTrip.getCheckCode());
        existingTrip.setCreatedAt(updatedTrip.getCreatedAt());
        existingTrip.setUpdatedAt(updatedTrip.getUpdatedAt());
        existingTrip.setPrice(updatedTrip.getPrice());
        existingTrip.setDriverLocation(updatedTrip.getDriverLocation());

        return this.repository.save(existingTrip);
    }


    public RidePagedList findByCityName(final String city, Pageable pageable) {
        Page<Trip> tripsPage = this.repository.findByCityName(city,pageable);

        return new RidePagedList(tripsPage.stream().collect(Collectors.toList()), PageRequest.of(
                tripsPage.getPageable().getPageNumber(),
                tripsPage.getPageable().getPageSize()),
                tripsPage.getTotalElements());
    }

    private Trip noNullTrip(String id) {
        return this.repository.findById(id).orElseThrow(() -> {
            throw new TripNotFoundException(String.format("The trip with id %s does not exist", id));
        });
    }
}
