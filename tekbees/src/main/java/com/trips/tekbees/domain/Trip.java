package com.trips.tekbees.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder(toBuilder = true)
@Document(collection = "trips")
public class Trip {
    @Id
    private String id;
    private FromAndToAddress start;
    private FromAndToAddress end;
    private Country country;
    private City city;
    private Person passenger;
    private Person driver;
    private Car car;
    private Status status;
    @Field("check_code")
    private String checkCode;
    private String createdAt;
    private String updatedAt;
    private int price;
    @Field("driver_location")
    private DriverLocation driverLocation;

}
