package com.example.vit.repository;

import com.example.vit.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank getBankByName(String name);
}
