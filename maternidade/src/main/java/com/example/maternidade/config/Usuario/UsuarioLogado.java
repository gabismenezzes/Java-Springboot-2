package com.example.maternidade.config.Usuario;

import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Parturiente;
import com.example.maternidade.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UsuarioLogado implements UserDetails {
    private Usuario user;
    public UsuarioLogado(Usuario user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> roles = new ArrayList<>();
        if (user instanceof Parturiente) {
            roles.add(new SimpleGrantedAuthority("ROLE_PARTURIENTE"));
        } else if (user instanceof Medico) {
            roles.add(new SimpleGrantedAuthority("ROLE_MEDICO"));
        }
        if (user.getId() == 1){
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return roles;
    }

    public Usuario getUser() {
        return user;
    }
    @Override
    public String getPassword() {
        return user.getSenha();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
