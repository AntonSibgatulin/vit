package com.example.vit.repository;

import com.example.vit.entity.Car;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car getCarById(Long id);

/*
    @Query("SELECT car, confidants, act " +
            "FROM Car car " +
            "INNER JOIN car.act act " +
            "LEFT JOIN act.confidant confidants LIMIT 1")
    List<Object[]> findCarsWithConfidants();

*/


    @Query("SELECT confidant.name, COUNT(car.id) AS carCount "
            + "FROM Car car "
            + "INNER JOIN car.act act "
            + "LEFT JOIN act.confidant confidant "
            + "GROUP BY act.confidant.id")
    List<Object[]> getDiagram1();


}
