package com.example.taskforjavadeveloper.service.impl;

import com.example.taskforjavadeveloper.model.Airplane;
import com.example.taskforjavadeveloper.model.Flight;
import com.example.taskforjavadeveloper.model.TemporaryPoint;
import com.example.taskforjavadeveloper.repository.AirplaneRepository;
import com.example.taskforjavadeveloper.service.AirplaneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;

    @Override
    public List<Airplane> getAllAirplanes() {
        log.info("Getting all Airplanes");
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane createAirplane(Airplane airplane) {
        log.info("Creating Airplane");
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane getAirplaneById(Long id) {
        log.info("Getting Airplane by ID");
        return airplaneRepository.findById(id).orElse(null);
    }

    @Override
    public String startFlight(Long airplaneId) {
        Airplane airplane = getAirplaneById(airplaneId);
        if (airplane.getFlights().isEmpty()) {
            return "No flights provided!";
        }
        airplaneRepository.save(airplane);
        return "Flight started for airplane with ID: " + airplaneId.toString();
    }

    @Override
    public List<TemporaryPoint> getCurrentPosition(Long id) {
        return airplaneRepository.findById(id)
                .map(airplane -> {
                    Flight currentFlight = airplane.getFlights().getFirst();
                    return currentFlight.getPassedPoints();
                })
                .orElse(List.of());
    }
}