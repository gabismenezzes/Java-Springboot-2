package com.example.maternidade.controller;

import com.example.maternidade.config.user.UsuarioLogado;
import com.example.maternidade.model.Acompanhante;
import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Parturiente;
import com.example.maternidade.model.enums.ESexo;
import com.example.maternidade.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

    @Controller
    @PreAuthorize("hasRole('MEDICO')")
    @RequestMapping(path = {"/medico"})
    public class MedicoController {

        @Autowired
        private MedicoService medServ;

        @PreAuthorize("hasRole('MEDICO')")
        @GetMapping("/home")
        public String pageHome(Model model, Authentication auth){

            model.addAttribute("nomeMedico",
                    ((UsuarioLogado) auth.getPrincipal()).getUser().getLogin());

            return "homeMedico";
        }

        @GetMapping("/pacientes")
        public String pagePacientes(Model model, Authentication auth){

            String login = ((UsuarioLogado) auth.getPrincipal()).getUser().getLogin();

            ArrayList<Parturiente> pacientes = medServ.getPacientes(login) ;

            model.addAttribute("pacientes",pacientes);
            return "paciente/listagem";
        }

        @GetMapping("/paciente/edit/{id}")
        public String pageEditPaciente(@PathVariable("id") Integer id,
                                      Model model, Authentication auth){

            Parturiente p = null;
            ArrayList<String> bebe = new ArrayList<>();
            bebe.add("ANA");
            bebe.add("MARIA");
            bebe.add("JOANA");
            bebe.add("OLIVIA");
            bebe.add("CAROLINA");
            model.addAttribute("parturiente",p);
            model.addAttribute("bebe",bebe);
            return "medico/editPaciente";
        }

        @GetMapping("/paciente/new")
        public String pageNewPaciente(Model model, Authentication auth) {
            Parturiente p = new Parturiente(0, new Bebe(), new Acompanhante(), new ArrayList<Medico>());
            ArrayList<String> med = new ArrayList<>();
            med.add("ANA");
            med.add("MARIA");
            med.add("JOANA");
            med.add("OLIVIA");
            med.add("CAROLINA");
            model.addAttribute("sexos", ESexo.values());
            model.addAttribute("medicos", med);
            model.addAttribute("bebe", p.getBebe());
            model.addAttribute("acompanhante", p.getAcompanhante());
            model.addAttribute("medicosList", p.getMedicos());

            return "medico/newPaciente";
        }


        @PostMapping("/paciente/save")
        public String pageSavePaciente(@ModelAttribute Bebe bebe,
                                      Model model, Authentication auth){

            medServ.savePaciente(bebe.getMae(), ((Parturiente) ((UsuarioLogado) auth.getPrincipal()).getUser()).getBebe());

            return "redirect:/paciente/bebe";
        }

    }
