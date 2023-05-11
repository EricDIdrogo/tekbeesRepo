package com.trips.tekbees.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Person {

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;
}
