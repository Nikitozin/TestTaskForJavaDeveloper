package com.example.taskforjavadeveloper.controller;

import com.example.taskforjavadeveloper.calculator.PlaneCalculation;
import com.example.taskforjavadeveloper.model.Airplane;
import com.example.taskforjavadeveloper.model.Flight;
import com.example.taskforjavadeveloper.model.TemporaryPoint;
import com.example.taskforjavadeveloper.model.WayPoint;
import com.example.taskforjavadeveloper.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airplanes")
@AllArgsConstructor
public class AirplaneController {

    private final AirplaneService airplaneService;

    @GetMapping
    public List<Airplane> getAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @PostMapping
    public Airplane createAirplane(@RequestBody Airplane airplane) {
        return airplaneService.createAirplane(airplane);
    }

    @GetMapping("/{id}")
    public Airplane getAirplaneById(@PathVariable Long id) {
        return airplaneService.getAirplaneById(id);
    }

    @GetMapping("/{id}/position")
    public List<TemporaryPoint> getCurrentPosition(@PathVariable Long id) {
        return airplaneService.getCurrentPosition(id);
    }

    @PostMapping("/{airplaneId}/start")
    public String startFlight(@PathVariable Long airplaneId) {
        return airplaneService.startFlight(airplaneId);
    }

//    @GetMapping("/{airplaneId}/status")
//    public List<TemporaryPoint> getFlightStatus(@PathVariable Long airplaneId) {
//        return airplaneService.getCurrentFlightStatus(airplaneId);
//    }
}