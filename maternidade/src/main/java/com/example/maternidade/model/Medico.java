package com.example.maternidade.model;

import com.example.maternidade.model.enums.EEspecialidadeMedico;
import jakarta.persistence.*;

public class Medico extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30,nullable = false)
    private String crm;
    @Enumerated(EnumType.STRING)
    private EEspecialidadeMedico especialidade;


}
