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
public class Parturiente extends Usuario{


    @OneToMany(mappedBy = "parturiente")
    private List<Bebe> bebes;
    @OneToOne(mappedBy = "parturiente")
    private Acompanhante acompanhante;

    @OneToOne(mappedBy = "parturiente")
    private Medico medicos;


//    public Bebe getBebe() {
//        return bebe;
//    }
//
//    public void setBebe(Bebe bebe) {
//        this.bebe = bebe;
//    }


    public List<Bebe> getBebes() {
        return bebes;
    }

    public void setBebes(List<Bebe> bebes) {
        this.bebes = bebes;
    }

    public Acompanhante getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(Acompanhante acompanhante) {
        this.acompanhante = acompanhante;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }
}
