package com.example.vit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TransmissionPoint {
    @Id
    @Column(length = 100,unique = true)
    public String transmissionPoint;

}
