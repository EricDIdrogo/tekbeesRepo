package com.trips.tekbees.domain;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RidePagedList extends PageImpl<Trip> {

    public RidePagedList(List<Trip> trips, Pageable pageable, long total) {
        super(trips, pageable, total);
    }

    public RidePagedList(List<Trip> trips) {
        super(trips);
    }

}
