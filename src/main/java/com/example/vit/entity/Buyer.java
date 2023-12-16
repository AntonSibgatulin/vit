package com.example.vit.entity;

import jakarta.persistence.*;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    public TypeOfOwnerShip typeOfOwnerShip;

    @Column(unique = true)
    public String name;

    @ManyToOne
    public Bank bank;


    public String inn;
    public String kpp;
    public String rscore;
    public String kscore;


    @ManyToOne
    public Location location;


}
