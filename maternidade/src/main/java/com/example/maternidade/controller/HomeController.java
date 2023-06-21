package com.example.maternidade.controller;

import com.example.maternidade.config.user.UsuarioLogado;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/home",""})
public class HomeController {

    @GetMapping("")
    public String pageHome(Model model, Authentication auth){

        if (auth != null) {
            model.addAttribute("nome",
                    ((UsuarioLogado) auth.getPrincipal()).getUser().getId());
        }else{
            model.addAttribute("nome",
                    "ninguém logado");
        }
        return "home";
    }


    @GetMapping("/ajuda")
    public String pageAjuda(){

        return "ajuda";
    }
    @GetMapping("/login")
    public String pageLogin(Model model){


        return "Login";
    }



}
