package com.example.maternidade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("P")
public class Parturiente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "parturiente_id")
    private Bebe bebe;
    @OneToOne
    private Acompanhante acompanhante;

    @OneToMany(mappedBy = "parturiente")
    private List<Medico> medicos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bebe getBebe() {
        return bebe;
    }

    public void setBebe(Bebe bebe) {
        this.bebe = bebe;
    }

    public Acompanhante getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(Acompanhante acompanhante) {
        this.acompanhante = acompanhante;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
