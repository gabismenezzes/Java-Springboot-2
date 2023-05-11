package com.example.maternidade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass()
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30,nullable = false)
    private String login;
    @Column(length = 120,nullable = false)
    private String senha;

}
