package com.trips.tekbees.controller;

import com.trips.tekbees.domain.CityTripCount;
import com.trips.tekbees.domain.CountryTripCount;
import com.trips.tekbees.domain.RidePagedList;
import com.trips.tekbees.domain.Trip;
import com.trips.tekbees.service.TripsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripsController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final TripsService service;

    @GetMapping("/count")
    public Long count() {
        return this.service.count();
    }

    @GetMapping("/city")
    public List<CityTripCount> getTotalRidesByCity() {
        return this.service.getTotalRidesByCity();
    }

    @GetMapping("/country")
    public List<CountryTripCount> getTotalRidesByCountry() {
        return this.service.getTotalRidesByCountry();
    }

    @PostMapping("/create")
    public ResponseEntity<Trip> createTrip(@Valid @RequestBody Trip trip) {
        Trip createdTrip = this.service.createRide(trip);
        return ResponseEntity.ok(createdTrip);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable String id, @Valid @RequestBody Trip trip) {
        Trip updatedTrip = this.service.updateRide(id, trip);
        return ResponseEntity.ok(updatedTrip);
    }

    @GetMapping("/all/{cityName}")
    public RidePagedList getAllTrips(@PathVariable("cityName") String cityName,
                                     @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return service.findByCityName(cityName,PageRequest.of(pageNumber, pageSize));
    }


}
