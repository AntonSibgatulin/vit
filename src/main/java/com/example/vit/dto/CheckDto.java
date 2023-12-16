package com.example.vit.dto;

import com.example.vit.entity.Act;
import com.example.vit.entity.AutoPart;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;

public class CheckDto {

    public List<AutoPartDto> autoPartDtos;
    public Integer allPrice;


    public Long number;

    public Date date;


    public Integer actNumber;
}
