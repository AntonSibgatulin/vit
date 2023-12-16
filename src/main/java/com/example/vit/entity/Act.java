package com.example.vit.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Act {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public Integer number;


    @ManyToOne
    public TransmissionPoint transmissionPoint;

    public Date dateTransmission;


    @ManyToOne
    public Agreement agreement;

    @ManyToOne
    public Confidant confidant;
}
