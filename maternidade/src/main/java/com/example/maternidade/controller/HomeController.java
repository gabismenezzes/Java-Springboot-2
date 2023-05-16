package com.example.maternidade.controller;

import com.example.maternidade.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/home","/"})
public class HomeController {

    @GetMapping("")
    public String pageHome(Model model){

        model.addAttribute("nome",
                "Homey");
        return "home";
    }

    @GetMapping("/ajuda")
    public String pageAjuda(){

        return "ajuda";
    }
    @GetMapping("/login")
    public String pageLogin(Model model){

//        LoginDTO ldto = LoginDTO.builder().login("abc").build();
        LoginDTO ldto = new LoginDTO();
        model.addAttribute("user",ldto);
        return "Login";
    }
    @PostMapping("/login")
    public String pageLoginPost(@ModelAttribute("user") LoginDTO login){

        //System.out.println(login.getLogin()+" - "+login.getSenha());

        return "Login";
    }
}
