package com.example.vit.dto;

import com.example.vit.entity.CarBrand;
import com.example.vit.entity.Models;
import com.example.vit.entity.TypeAutoParts;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class AutoPartDto {

    public String typeAutoParts;

    public String carBrands;

    public List<String> models;

    public Integer price;

    public Integer count;

    public Integer resultSum;
}
