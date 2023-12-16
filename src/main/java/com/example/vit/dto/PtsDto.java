package com.example.vit.dto;

import com.example.vit.entity.CarBrand;
import com.example.vit.entity.Models;
import jakarta.persistence.ManyToOne;

public class PtsDto {
    public String VIN;
    public CarBrand brand;

    public Models models;

    public String categoryTs;
    public Long numberEngine;
    public String numberAxis;
}
