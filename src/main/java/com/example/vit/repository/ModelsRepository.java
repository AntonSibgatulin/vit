package com.example.vit.repository;

import com.example.vit.entity.CarBrand;
import com.example.vit.entity.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelsRepository extends JpaRepository<Models, Long> {
    Models getModelsByModel(String models);

    @Query("SELECT m FROM Models m WHERE m.model IN :models")
    List<Models> findAllByModels(@Param("models") List<String> models);

    List<Models> findAllByCarBrand(CarBrand carBrand);
}
