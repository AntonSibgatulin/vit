package com.example.vit.repository;

import com.example.vit.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
    Boolean existsAgreementByNumber(Integer number);

    Agreement getAgreementByNumber(Integer number);

    Agreement getAgreementById(Long id);
}
