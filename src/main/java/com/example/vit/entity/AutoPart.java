package com.example.vit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class AutoPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    public TypeAutoParts typeAutoParts;

    @ManyToOne
    public CarBrand carBrands;

    @ManyToMany
    public List<Models> models;

    public Integer price;

    public Integer count;

    public Integer resultSum;

}
