package com.example.maternidade.model.dao;

import com.example.maternidade.model.Bebe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BebeDAO extends JpaRepository<Bebe,Integer> {

    ArrayList<Bebe> findById(int idPacienteLogado);


    public Bebe findByLoginAndSenha(String login, String senha);
}
