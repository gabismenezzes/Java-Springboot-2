package com.example.maternidade.model;

import jakarta.persistence.*;

public class Parturiente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Bebe bebe;
    @OneToOne
    private Acompanhante acompanhante;
    @OneToMany
    private Medico medico;


}
