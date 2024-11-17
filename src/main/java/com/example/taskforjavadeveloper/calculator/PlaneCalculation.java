package com.example.taskforjavadeveloper.calculator;

import com.example.taskforjavadeveloper.model.AirplaneCharacteristics;
import com.example.taskforjavadeveloper.model.TemporaryPoint;
import com.example.taskforjavadeveloper.model.WayPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneCalculation {

    public List<TemporaryPoint> calculateRoute(AirplaneCharacteristics characteristics, List<WayPoint> wayPoints) {
        List<TemporaryPoint> route = new ArrayList<>();

        for (int i = 0; i < wayPoints.size() - 1; i++) {
            WayPoint start = wayPoints.get(i);
            WayPoint end = wayPoints.get(i + 1);
            route.addAll(generatePoints(characteristics, start, end));
        }

        return route;
    }

    private List<TemporaryPoint> generatePoints(AirplaneCharacteristics characteristics, WayPoint start, WayPoint end) {
        List<TemporaryPoint> points = new ArrayList<>();

        double lat = start.getLatitude();
        double lon = start.getLongitude();
        double height = start.getHeight();
        double speed = start.getSpeed();

        points.add(new TemporaryPoint(lat, lon, height, speed, 0));

        while (!isCloseEnough(lat, lon, height, end)) {
            lat = updateCoordinate(lat, end.getLatitude(), 0.001);
            lon = updateCoordinate(lon, end.getLongitude(), 0.001);
            height = updateCoordinate(height, end.getHeight(), 0.1);
            speed = Math.min(characteristics.getMaxSpeed(), speed + characteristics.getAcceleration());

            points.add(new TemporaryPoint(lat, lon, height, speed, 0));
        }

        return points;
    }

    private boolean isCloseEnough(double lat, double lon, double height, WayPoint end) {
        return Math.abs(lat - end.getLatitude()) < 0.001 && Math.abs(lon - end.getLongitude()) < 0.001 && Math.abs(height - end.getHeight()) < 0.1;
    }

    private double updateCoordinate(double current, double target, double step) {
        return calculateWay(current, target) ? current + step : current - step;
    }

    private boolean calculateWay(double currentPoint, double destination) {
        return currentPoint < destination;
    }
}
