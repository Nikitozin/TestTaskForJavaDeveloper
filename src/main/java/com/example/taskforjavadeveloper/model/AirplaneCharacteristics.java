package com.example.taskforjavadeveloper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "airplane_characteristics")
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneCharacteristics {
    private double maxSpeed;

    private double acceleration;

    private double altitudeChangeSpeed;

    private double courseChangeSpeed;
}
