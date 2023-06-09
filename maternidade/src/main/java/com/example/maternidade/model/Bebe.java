package com.example.maternidade.model;

import com.example.maternidade.model.enums.ESexo;
import com.example.maternidade.model.enums.ETipoParto;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;
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

    public Bebe() {
    }

    public Bebe(int id, Parturiente mae, String nomedoPai, LocalTime horarioNascimento, ETipoParto parto, List<Medico> medicos, Boolean ficounaUTI) {
        this.id = id;
        this.mae = mae;
        this.nomedoPai = nomedoPai;
        this.horarioNascimento = horarioNascimento;
        this.parto = parto;
        this.medicos = medicos;
        this.ficounaUTI = ficounaUTI;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Parturiente getMae() {
        return mae;
    }

    public void setMae(Parturiente mae) {
        this.mae = mae;
    }

    public String getNomedoPai() {
        return nomedoPai;
    }

    public void setNomedoPai(String nomedoPai) {
        this.nomedoPai = nomedoPai;
    }

    public LocalTime getHorarioNascimento() {
        return horarioNascimento;
    }

    public void setHorarioNascimento(LocalTime horarioNascimento) {
        this.horarioNascimento = horarioNascimento;
    }

    public ETipoParto getParto() {
        return parto;
    }

    public void setParto(ETipoParto parto) {
        this.parto = parto;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public Boolean getFicounaUTI() {
        return ficounaUTI;
    }

    public void setFicounaUTI(Boolean ficounaUTI) {
        this.ficounaUTI = ficounaUTI;
    }
}
