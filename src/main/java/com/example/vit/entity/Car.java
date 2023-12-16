package com.example.vit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "model", "number_engine"
        })
})
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "model", length = 100)
    public String model;
    @Column(name = "number_engine")
    public String numberEngine;
    @ManyToOne
    public Pts pts;
    public Integer price;
    @ManyToOne
    public Act act;


}