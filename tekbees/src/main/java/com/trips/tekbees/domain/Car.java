package com.trips.tekbees.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Car {
    private String plate;
}
