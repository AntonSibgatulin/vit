package com.example.vit.dto;

import com.example.vit.entity.Act;
import com.example.vit.entity.Models;
import com.example.vit.entity.Pts;
import jakarta.persistence.ManyToOne;

public class CarDto {

    public String models;
    public String numberEngine;
    public String numberAxis;
    public Long ptsId;
    public Integer price;
    public Long actNumber;

}
