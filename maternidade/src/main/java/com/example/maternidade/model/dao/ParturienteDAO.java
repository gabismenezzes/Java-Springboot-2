package com.example.maternidade.model.dao;

import com.example.maternidade.model.Parturiente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ParturienteDAO extends JpaRepository<Parturiente,Integer> {

    ArrayList<Parturiente> findByLogin(String username);


}
