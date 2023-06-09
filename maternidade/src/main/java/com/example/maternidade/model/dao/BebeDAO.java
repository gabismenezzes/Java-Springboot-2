package com.example.maternidade.model.dao;

import com.example.maternidade.model.Bebe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BebeDAO extends JpaRepository<Bebe,Integer> {

    ArrayList<Bebe> findByMae(String mae);
}
