package com.example.maternidade.controller;

import com.example.maternidade.config.user.UsuarioLogado;
import com.example.maternidade.model.Bebe;
import com.example.maternidade.service.ParturienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@PreAuthorize("hasRole('PARTURIENTE')")
@RequestMapping(path = {"parturiente"})
public class ParturienteController {

    @Autowired
    private ParturienteService part;


    @PreAuthorize("hasRole('PARTURIENTE')")
    @GetMapping("/home")
    public String pageHome(Model model, Authentication auth){
        model.addAttribute("loginPaciente",
                ((UsuarioLogado) auth.getPrincipal()).getUser().getLogin());
        return "homePaciente";
    }

    @PreAuthorize("hasRole('PARTURIENTE')")
    @GetMapping("/listagem/bebes")
    public String pageBercario(Model model, Authentication auth){
        int idPacienteLogado = ((UsuarioLogado) auth.getPrincipal()).getUser().getId();
        ArrayList<Bebe> bebes = part.getBebes(idPacienteLogado);
        model.addAttribute("bebe", bebes);
        return "paciente/bercariovirtual";
    }
}

