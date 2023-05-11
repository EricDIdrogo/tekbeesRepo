package com.trips.tekbees.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document
@Data
public class DriverLocation {

    private String type;
    private List<BigDecimal> coordinates;
}
