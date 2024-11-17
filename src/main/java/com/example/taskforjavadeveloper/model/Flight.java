package com.example.taskforjavadeveloper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "flights")
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    private Long number;

    @DBRef
    private List<WayPoint> wayPoints;

    private List<TemporaryPoint> passedPoints;
}
