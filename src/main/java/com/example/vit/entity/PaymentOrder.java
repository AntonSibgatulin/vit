package com.example.vit.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Integer number;
    public Date date;
    public Integer sum;


    public String provider_inn;
    public String provider_kpp;
    public String provider_rscore;
    public String provider_kscore;


    @ManyToOne
    public Location provider_location;


    public String buyer_inn;
    public String buyer_kpp;
    public String buyer_rscore;
    public String buyer_kscore;


    @ManyToOne
    public Location buyer_location;


}
