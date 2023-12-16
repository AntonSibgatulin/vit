package com.example.vit.repository;

import com.example.vit.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    Boolean existsBuyerByName(String name);

    Buyer getBuyerByName(String name);

    Buyer getBuyerById(Long id);

}
