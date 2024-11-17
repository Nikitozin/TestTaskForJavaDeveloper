package com.example.taskforjavadeveloper.service;

import com.example.taskforjavadeveloper.model.Airplane;
import com.example.taskforjavadeveloper.model.TemporaryPoint;

import java.util.List;

public interface AirplaneService {

    List<Airplane> getAllAirplanes();

    Airplane createAirplane(Airplane airplane);

    Airplane getAirplaneById(Long id);

    String startFlight(Long airplaneId);

    List<TemporaryPoint> getCurrentPosition(Long id);
}
