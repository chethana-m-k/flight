package com.example.flight.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "flights")
public class Flight {

    @Id
    private String _id;   // MongoDB default id

    @Indexed(unique = true)
    private int id;       // Your unique id

    private String flightCode;
    private String airlineName;
    private String source;
    private String destination;
    private int fare;
    private String duration;

    // Getters and Setters
}

