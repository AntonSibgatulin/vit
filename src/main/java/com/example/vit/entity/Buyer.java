package com.example.vit.entity;

import jakarta.persistence.*;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    public TypeOfOwnerShip typeOfOwnerShip;

    @Column(unique = true,length = 120)
    public String name;

    @ManyToOne
    public Bank bank;

    @Column(length = 20)
    public String inn;
    @Column(length = 20)
    public String kpp;
    @Column(length = 20)
    public String rscore;
    @Column(length = 20)
    public String kscore;


    @ManyToOne
    public Location location;


}
