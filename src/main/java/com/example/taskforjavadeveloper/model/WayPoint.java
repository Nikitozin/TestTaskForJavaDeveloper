package com.example.taskforjavadeveloper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "way_points")
@AllArgsConstructor
@NoArgsConstructor
public class WayPoint {
    private double latitude;

    private double longitude;

    private double height;

    private double speed;
}
