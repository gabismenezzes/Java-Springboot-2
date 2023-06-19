package com.example.maternidade.model;

import com.example.maternidade.model.enums.EEspecialidadeMedico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "bebe_id")
    private Bebe bebe;

    @ManyToOne
    @JoinColumn(name = "parturiente_id")
    private Parturiente parturiente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EEspecialidadeMedico getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EEspecialidadeMedico especialidade) {
        this.especialidade = especialidade;
    }
}
