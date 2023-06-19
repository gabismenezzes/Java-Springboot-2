package com.example.maternidade.model;

import com.example.maternidade.model.enums.ETipoParto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("B")
public class Bebe extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "mae_id")
    private Parturiente mae;

    private String nomedoPai;

    private LocalTime horarioNascimento;
    @Enumerated(EnumType.STRING)
    private ETipoParto parto;

    @OneToMany(mappedBy = "bebe")
    private List<Medico> medicos;
    @Column(length = 30,nullable = false)
    private Boolean ficounaUTI;

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
