package com.example.vit.entity;


import jakarta.persistence.*;

@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    public TypeOfOwnerShip typeOfOwnerShip;

    @Column(unique = true, length = 120)
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
