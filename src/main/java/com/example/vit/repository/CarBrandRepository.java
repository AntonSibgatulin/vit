package com.example.vit.repository;

import com.example.vit.entity.Car;
import com.example.vit.entity.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarBrandRepository extends JpaRepository<CarBrand, String> {
    CarBrand getCarBrandsByBrand(String brand);

    @Query("SELECT c FROM CarBrand c WHERE c.brand IN :brands")
    List<CarBrand> findAllByBrand(@Param("brands") List<String> brands);
}
