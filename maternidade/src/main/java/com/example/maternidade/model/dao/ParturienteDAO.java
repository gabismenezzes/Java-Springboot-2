package com.example.maternidade.model.dao;

import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Parturiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ParturienteDAO extends JpaRepository<Parturiente,Integer> {

    Parturiente findByLogin(String username);

    ArrayList<Parturiente> findById(int idPacienteLogado);
    public Parturiente findByLoginAndSenha(String login, String senha);
}
