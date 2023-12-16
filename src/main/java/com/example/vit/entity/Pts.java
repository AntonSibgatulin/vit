package com.example.vit.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Pts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    public CarBrand brand;

    @ManyToOne
    public Models model;

    @Column(length = 20)
    public String number;


    @Column(length = 50)
    public String manufacturer;

    @Column(length = 20)
    public String color;

    public int year;

    public int enginePower;

    @Column(length = 17)
    public String vin;

    public String axisNumber;

    //@Column(length = 20)
    public Date registrationDate;

    @Column(length = 50)
    public String registrationAuthority;

    @Column(length = 20)
    public String engineNumber;

}
