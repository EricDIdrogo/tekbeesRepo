package com.trips.tekbees.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class City {
    private String name;
}
