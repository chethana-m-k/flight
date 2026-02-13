package com.example.flight.Service;

import java.util.List;

import com.example.flight.Dto.FlightDto;

public interface FlightService {

    FlightDto addFlight(FlightDto dto);

    List<FlightDto> getAllFlights();

    FlightDto getFlightById(int id);

    FlightDto updateFlight(int id, FlightDto dto);

    void deleteFlight(int id);
}

