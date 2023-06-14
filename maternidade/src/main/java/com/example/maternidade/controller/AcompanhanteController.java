package com.example.maternidade.controller;

import com.example.maternidade.config.User.UsuarioLogado;
import com.example.maternidade.model.Acompanhante;
import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Medico;
import com.example.maternidade.model.dao.ParturienteDAO;
import com.example.maternidade.service.ParturienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

public class AcompanhanteController {
    @Autowired
    private ParturienteService part;

    @PreAuthorize("hasRole('PARTURIENTE')")
    @GetMapping("/home")
    public String pageHome(Model model, Authentication auth){

        model.addAttribute("loginPARTURIENTE",
                ((UsuarioLogado) auth.getPrincipal()).getUser().getLogin());

        return "homePaciente";
    }

    @GetMapping("/bebe")
    public String pageBebe(Model model, Authentication auth){

        int idPacienteLogado = ((UsuarioLogado) auth.getPrincipal()).getUser().getId();

        ArrayList<Bebe> bebes = ParturienteService.getBebes(String.valueOf(idPacienteLogado)) ;

        model.addAttribute("bebes",bebes);
        return "bebes/listagem";
    }



    @PostMapping("/bebes/save")
    public String pageSaveBebes(@ModelAttribute Bebe bebe,
                                  Model model, Authentication auth){

        part.saveBebe(bebe, (Medico), (Acompanhante), ((UsuarioLogado) auth.getPrincipal()).getUser());


        return "redirect:/paciente/bebe";
    }
}
