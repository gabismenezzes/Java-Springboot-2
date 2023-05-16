package com.example.maternidade.model.dao;

import com.example.maternidade.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

    public Usuario findByLogin(String login);
    public Usuario findByLoginAndSenha(String login, String senha);

    @Query("select u from Usuario u ")
    public List<Usuario> findUsuario();
}
