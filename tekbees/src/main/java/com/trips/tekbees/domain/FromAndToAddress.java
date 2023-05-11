package com.trips.tekbees.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@Data
public class FromAndToAddress {

    private Date date;

    @Field("pickup_address")
    private String pickupAddress;

    @Field("pickup_location")
    private PickupLocation pickupLocation;
}
