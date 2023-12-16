package com.example.vit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public Long number;

    public Date date;

    @ManyToMany
    public List<AutoPart> autoParts;

    public Integer allPrice;

    @ManyToOne
    public Act actAutoParts;

}
