package com.example.vit.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(unique = true)
    public Integer number;
    public Date date;

    @ManyToOne
    public Provider provider;

    @ManyToOne
    public Buyer buyer;

    @ManyToOne
    public PaymentOrder paymentOrder;
}
