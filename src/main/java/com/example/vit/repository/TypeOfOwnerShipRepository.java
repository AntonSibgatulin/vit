package com.example.vit.repository;

import com.example.vit.entity.TypeOfOwnerShip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfOwnerShipRepository extends JpaRepository<TypeOfOwnerShip, String> {
    TypeOfOwnerShip getTypeOfOwnerShipByTypeOfOwnerShip(String type);
}
