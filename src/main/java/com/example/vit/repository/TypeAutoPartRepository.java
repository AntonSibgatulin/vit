package com.example.vit.repository;

import com.example.vit.entity.TypeAutoParts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAutoPartRepository extends JpaRepository<TypeAutoParts, String> {
    TypeAutoParts getTypeAutoPartsByTypeAutoParts(String TypeAutoParts);

}
