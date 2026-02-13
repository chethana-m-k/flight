package com.example.flight.Service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flight.Dto.FlightDto;
import com.example.flight.Entity.Flight;
import com.example.flight.Repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository repo;

    // Convert DTO → Entity
    private Flight mapToEntity(FlightDto dto) {
        Flight f = new Flight();

        f.setId(dto.getId());
        f.setFlightCode(dto.getFlightCode());
        f.setAirlineName(dto.getAirlineName());
        f.setSource(dto.getSource());
        f.setDestination(dto.getDestination());
        f.setFare(dto.getFare());
        f.setDuration(dto.getDuration());

        return f;
    }

    // Convert Entity → DTO
    private FlightDto mapToDTO(Flight f) {
        FlightDto dto = new FlightDto();

        dto.setId(f.getId());
        dto.setFlightCode(f.getFlightCode());
        dto.setAirlineName(f.getAirlineName());
        dto.setSource(f.getSource());
        dto.setDestination(f.getDestination());
        dto.setFare(f.getFare());
        dto.setDuration(f.getDuration());

        return dto;
    }

    // Insert
    @Override
    public FlightDto addFlight(FlightDto dto) {

        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Flight ID already exists!");
        }

        Flight flight = mapToEntity(dto);
        Flight saved = repo.save(flight);

        return mapToDTO(saved);
    }

    // Get All
    @Override
    public List<FlightDto> getAllFlights() {

        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get By ID
    @Override
    public FlightDto getFlightById(int id) {

        Flight flight = repo.findById(id);

        if (flight == null) {
            throw new RuntimeException("Flight not found!");
        }

        return mapToDTO(flight);
    }

    // Update
    @Override
    public FlightDto updateFlight(int id, FlightDto dto) {

        Flight flight = repo.findById(id);

        if (flight == null) {
            throw new RuntimeException("Flight not found!");
        }

        flight.setFare(dto.getFare());
        flight.setDestination(dto.getDestination());

        Flight updated = repo.save(flight);

        return mapToDTO(updated);
    }

    // Delete
    @Override
    public void deleteFlight(int id) {

        Flight flight = repo.findById(id);

        if (flight == null) {
            throw new RuntimeException("Flight not found!");
        }

        repo.delete(flight);
    }
}

