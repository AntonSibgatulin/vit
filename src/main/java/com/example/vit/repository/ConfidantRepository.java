package com.example.vit.repository;

import com.example.vit.entity.Confidant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfidantRepository extends JpaRepository<Confidant, Long> {
    Confidant getConfidantByNumberConfidant(Integer confidant);

    Confidant getConfidantById(Long id);
}
