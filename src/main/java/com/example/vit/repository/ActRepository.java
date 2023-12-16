package com.example.vit.repository;

import com.example.vit.entity.Act;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActRepository extends JpaRepository<Act, Long> {
    Act getActByNumber(Integer number);

    Act getActById(Long id);
}
