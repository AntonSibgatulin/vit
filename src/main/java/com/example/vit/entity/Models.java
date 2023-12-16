package com.example.vit.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Models {

    @Id
    @Column(length = 100,unique = true)
    public String model;

    @ManyToOne
    public CarBrand carBrand;

}
