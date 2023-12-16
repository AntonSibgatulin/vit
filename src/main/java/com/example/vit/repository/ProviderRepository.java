package com.example.vit.repository;

import com.example.vit.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Boolean existsProviderByName(String name);

    Provider getProvidersByName(String name);

    Provider getProvidersById(Long id);
}
