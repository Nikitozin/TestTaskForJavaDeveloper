package com.example.taskforjavadeveloper.scheduler;

import com.example.taskforjavadeveloper.calculator.PlaneCalculation;
import com.example.taskforjavadeveloper.model.Flight;
import com.example.taskforjavadeveloper.model.TemporaryPoint;
import com.example.taskforjavadeveloper.repository.AirplaneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FlightScheduler {

    private final AirplaneRepository repository;
    private final PlaneCalculation calculation;

    public FlightScheduler(AirplaneRepository repository, PlaneCalculation calculation) {
        this.repository = repository;
        this.calculation = calculation;
        System.out.println("FlightScheduler was initialized");
    }

    @Scheduled(fixedRate = 5000)
    public void updateAirplanePosition() {
        log.info("Scheduler is executing...");
        repository.findAll().forEach(airplane -> {
            Flight currentFlight = airplane.getFlights().getFirst();
            List<TemporaryPoint> route = calculation.calculateRoute(
                    airplane.getCharacteristics(),
                    currentFlight.getWayPoints()
            );

            TemporaryPoint nextPoint = route.get(currentFlight.getPassedPoints().size());
            currentFlight.getPassedPoints().add(nextPoint);
            repository.save(airplane);
        });
    }
}