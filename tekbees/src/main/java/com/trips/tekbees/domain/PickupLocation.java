package com.trips.tekbees.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PickupLocation {

    private String type;

    private List<BigDecimal> coordinates;
}
