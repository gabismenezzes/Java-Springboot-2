package com.example.maternidade.model;

import com.example.maternidade.model.enums.ETipoParto;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

public class Bebe extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    private Parturiente mae;

    private String nomedoPai;
    @Temporal(TemporalType.TIME)
    private LocalTime horarioNascimento;
    @Enumerated(EnumType.STRING)
    private ETipoParto parto;

    @ManyToOne
    private List<Medico> medicos;
    @Column(length = 30,nullable = false)
    private Boolean ficounaUTI;

}
