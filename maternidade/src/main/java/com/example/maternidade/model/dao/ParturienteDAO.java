package com.example.maternidade.model.dao;

import com.example.maternidade.model.Parturiente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ParturienteDAO extends JpaRepository<Parturiente,Integer> {


    Parturiente findByLogin(String username);


    public Parturiente findByLoginAndSenha(String login, String senha);
}
