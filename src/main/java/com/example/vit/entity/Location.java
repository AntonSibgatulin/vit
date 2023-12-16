package com.example.vit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Location {
    @Id
    @Column(length = 25,unique = true)
    public String location;
}
