package com.example.maternidade.model;

import jakarta.persistence.*;

public class Acompanhante extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30,nullable = false)
    private String grauParentesco;
    @OneToOne
    private Parturiente paciente;

}
