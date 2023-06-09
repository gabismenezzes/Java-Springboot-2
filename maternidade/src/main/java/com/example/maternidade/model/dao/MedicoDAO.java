package com.example.maternidade.model.dao;

import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoDAO extends JpaRepository<Medico,Integer> {

    public Medico findByCrm(String crm);

    public Medico findByLoginAndSenha(String login, String senha);




    Usuario findByLogin(String username);


}
