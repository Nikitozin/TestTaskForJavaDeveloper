package com.example.taskforjavadeveloper.repository;

import com.example.taskforjavadeveloper.model.Airplane;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirplaneRepository extends MongoRepository<Airplane, Long> {
}
