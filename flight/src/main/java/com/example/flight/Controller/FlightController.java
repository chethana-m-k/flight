package com.example.flight.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.flight.Dto.FlightDto;
import com.example.flight.Service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService service;

    // Insert
    @PostMapping
    public FlightDto addFlight(@RequestBody FlightDto dto) {
        return service.addFlight(dto);
    }

    // Get All
    @GetMapping
    public List<FlightDto> getAllFlights() {
        return service.getAllFlights();
    }

    // Get By ID
    @GetMapping("/{id}")
    public FlightDto getById(@PathVariable int id) {
        return service.getFlightById(id);
    }

    // Update
    @PutMapping("/{id}")
    public FlightDto update(
            @PathVariable int id,
            @RequestBody FlightDto dto) {

        return service.updateFlight(id, dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {

        service.deleteFlight(id);

        return "Flight Deleted Successfully!";
    }
}

