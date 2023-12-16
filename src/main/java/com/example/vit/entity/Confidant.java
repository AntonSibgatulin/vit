package com.example.vit.entity;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity

@Table(name = "confidants", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"surname", "name", "patronymic"})
})

public class Confidant {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long id;


    @NotNull
    @Column(name = "surname", nullable = false, length = 25)
    public String surname;


    @NotNull
    @Column(name = "name", nullable = false, length = 25)
    public String name;


    @NotNull
    @Column(name = "patronymic", nullable = false, length = 25)
    public String patronymic;
    ;

    public Integer numberConfidant;

    public Date confidant;
    public Integer seriaPassport;
    public Integer numberPassport;
    public Date dataOutput;

    @Column(length = 100)
    public String whoOutput;

}
