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
public class Bebe extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "parturiente_id")
    private Parturiente parturiente;

    private String nomedoPai;

    @OneToOne(mappedBy = "bebe")
    private Medico medicos;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }





//    public Parturiente getMae() {
//        return mae;
//    }
//
//    public void setMae(Parturiente mae) {
//        this.mae = mae;
//    }


    public Parturiente getParturiente() {
        return parturiente;
    }

    public void setParturiente(Parturiente parturiente) {
        this.parturiente = parturiente;
    }

    public String getNomedoPai() {
        return nomedoPai;
    }

    public void setNomedoPai(String nomedoPai) {
        this.nomedoPai = nomedoPai;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }



}
