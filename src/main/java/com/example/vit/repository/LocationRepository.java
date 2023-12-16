package com.example.vit.repository;

import com.example.vit.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location getLocationsByLocation(String location);
}
