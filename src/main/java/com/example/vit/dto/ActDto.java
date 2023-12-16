package com.example.vit.dto;

import com.example.vit.entity.Agreement;
import com.example.vit.entity.Confidant;
import com.example.vit.entity.TransmissionPoint;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class ActDto {

    public Integer number;

    public String transmissionPoint;

    public Date dateTransmission;


    public Long agreement;


    public Integer confidant;
}
