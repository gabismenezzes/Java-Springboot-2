package com.example.maternidade.model.dao;

import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoDAO extends JpaRepository<Medico,Integer> {

    public Medico findByNome(String nome);
    public Medico findByNomeAndEmail(String nome, String email);
    public Medico findByLoginAndSenha(String login, String senha);

    public List<Medico> findByValorHoraGreaterThan(double valor);

    @Query("select m from Mecanico m join m.minhasOS os " +
            " Where os.dataSaida is null")
    public List<Medico> findMecanicoOsAberta();


    Usuario findByLogin(String username);


}
