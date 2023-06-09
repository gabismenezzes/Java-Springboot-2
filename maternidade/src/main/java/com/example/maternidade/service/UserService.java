package com.example.maternidade.service;

import com.example.maternidade.config.Usuario.UsuarioLogado;
import com.example.maternidade.model.Usuario;
import com.example.maternidade.model.dao.MedicoDAO;
import com.example.maternidade.model.dao.ParturienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    ParturienteDAO parturienteDAO;
    @Autowired
    MedicoDAO medicoDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = medicoDAO.findByLogin(username);

        if (u == null){
            u = medicoDAO.findByLogin(username);
        }
        if (u == null){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new UsuarioLogado(u);
    }
}

