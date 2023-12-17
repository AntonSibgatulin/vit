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

    @Column(length = 20)
    public String provider_inn;
    @Column(length = 20)
    public String provider_kpp;
    @Column(length = 20)
    public String provider_rscore;
    @Column(length = 20)
    public String provider_kscore;


    @ManyToOne
    public Location provider_location;

    @Column(length = 20)
    public String buyer_inn;
    @Column(length = 20)
    public String buyer_kpp;
    @Column(length = 20)
    public String buyer_rscore;
    @Column(length = 20)
    public String buyer_kscore;


    @ManyToOne
    public Location buyer_location;


}
