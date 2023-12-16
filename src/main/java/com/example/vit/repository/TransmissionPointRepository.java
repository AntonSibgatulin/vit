package com.example.vit.repository;

import com.example.vit.entity.TransmissionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
//@Repository
public interface TransmissionPointRepository extends JpaRepository<TransmissionPoint, String> {
    TransmissionPoint getTransmissionPointByTransmissionPoint(String transmissionPoint);
}
