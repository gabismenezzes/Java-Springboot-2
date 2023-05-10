package com.example.maternidade.model;

import com.example.maternidade.model.enums.ETipoParto;

import java.time.LocalTime;

public class Bebe extends Pessoa{

    private Parturiente mae;

    private String nomedoPai;

    private LocalTime horarioNascimento;

    private ETipoParto parto;

    private Medico medico;

}
