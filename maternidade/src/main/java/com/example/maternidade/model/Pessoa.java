package com.example.maternidade.model;

import com.example.maternidade.model.enums.ESexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder()
@DiscriminatorValue("P")
@Entity
public class Pessoa extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30,nullable = false)
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Enumerated(EnumType.STRING)
    private ESexo sexo;
}
