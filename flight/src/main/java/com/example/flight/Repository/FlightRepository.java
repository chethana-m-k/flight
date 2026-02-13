package com.example.flight.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.flight.Entity.Flight;

public interface FlightRepository extends MongoRepository<Flight, String> {

    Flight findById(int id);

    boolean existsById(int id);
}
