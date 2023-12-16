package com.example.vit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarBrand {

    @Id
    @Column(length = 30)
    public String brand;
}
