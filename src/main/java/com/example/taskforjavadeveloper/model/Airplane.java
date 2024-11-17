package com.example.taskforjavadeveloper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "airplanes")
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {
    @Id
    private Long id;

    @DBRef
    private AirplaneCharacteristics characteristics;

    private TemporaryPoint position;

    @DBRef
    private List<Flight> flights;
}
