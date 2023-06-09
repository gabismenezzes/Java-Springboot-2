package com.example.maternidade.model;

import com.example.maternidade.model.enums.EEspecialidadeMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("M")
public class Medico extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30,nullable = false)
    private String crm;
    @Enumerated(EnumType.STRING)
    private EEspecialidadeMedico especialidade;


}
