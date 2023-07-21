package com.example.maternidade.model.dao;

import com.example.maternidade.model.Acompanhante;
import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Parturiente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcompanhanteDAO extends JpaRepository<Acompanhante, Integer> {

    public Acompanhante findByParturienteId(int id);

    public Acompanhante findByLoginAndSenha(String login, String senha);
}
