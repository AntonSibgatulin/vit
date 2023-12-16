package com.example.vit.entity;

import jakarta.persistence.*;

@Entity
public class Bank {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true,length = 100)
    public String name;
}
