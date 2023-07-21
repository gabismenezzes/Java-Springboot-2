package com.example.maternidade.controller;

import com.example.maternidade.config.user.UsuarioLogado;
import com.example.maternidade.model.Acompanhante;
import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Parturiente;
import com.example.maternidade.model.dao.BebeDAO;
import com.example.maternidade.model.dao.MedicoDAO;
import com.example.maternidade.model.dao.ParturienteDAO;
import com.example.maternidade.model.enums.ESexo;
import com.example.maternidade.model.enums.ETipoParto;
import com.example.maternidade.service.MedicoService;
import com.example.maternidade.service.ParturienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;

@Controller
@PreAuthorize("hasRole('MEDICO')")
@RequestMapping(path = {"/medico"})
public class MedicoController {

    @Autowired
    private MedicoService medServ;

    @Autowired
    private ParturienteService partServ;

    @Autowired
    private  BebeDAO bebedao;

    @Autowired
    private MedicoDAO medicodao;

    @Autowired
    ParturienteDAO parturientedao;

    @PreAuthorize("hasRole('MEDICO')")
    @GetMapping("/home")
    public String pageHome(Model model, Authentication auth){

        model.addAttribute("nomeMedico",
                ((UsuarioLogado) auth.getPrincipal()).getUser().getLogin());

        return "homeMedico";
    }

    @GetMapping("/pacientes/listagem")
    public String pagePacientes(Model model, Authentication auth){

        int idPacienteLogado = ((UsuarioLogado) auth.getPrincipal()).getUser().getId();

        ArrayList<Parturiente> parturientes = medServ.getMeusPacientes(idPacienteLogado);
//        Parturiente pacientes = medServ.getPacientes(login) ;

        model.addAttribute("parturientes",parturientes);
        return "medico/listagemPacientes";
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
        return "editPaciente";
    }

    @GetMapping("/paciente/new")
    public String pageNewPaciente(Model model) {

        Parturiente p = new Parturiente();
        p.setMedicos(new Medico());
        p.setAcompanhante(new Acompanhante());
        ArrayList<String> beb = new ArrayList<>();

        model.addAttribute("parturiente", p);
        model.addAttribute("bebe",beb);
       // model.addAttribute("bebe", new Bebe());
        return "medico/newPaciente";
    }
    @GetMapping("/bebe/new")
    public String pageNewBebe(Model model) {
        Bebe b = new Bebe();

        b.setNomedoPai("");
        b.setParturiente(new Parturiente());
        b.setMedicos(new Medico());


        model.addAttribute("bebe", b);

        return "medico/newBebe";

    }

//    @GetMapping("/paciente/new/parturiente")
//    public String pageNewPaciente(Model model, Authentication auth) {
//        Parturiente p = new Parturiente();
//        p.setBebe(new Bebe());
//        p.setMedicos(new Medico());
//        p.setAcompanhante(new Acompanhante());
//        ArrayList<String> med = new ArrayList<>();
//
//        model.addAttribute("parturiente", p);
//        //model.addAttribute("sexos", ESexo.values());
//        //model.addAttribute("medicos", med);
//       // model.addAttribute("bebe", p.getBebe());
//        model.addAttribute("acompanhante", new Acompanhante()); // Inicializa a variável acompanhante
//
//        return "medico/newPaciente";
//    }

    @GetMapping("/paciente/new/bebe")
    public String pageNewBebe(Model model, Authentication auth) {
        Bebe b = new Bebe();

        model.addAttribute("parturiente", false);
        model.addAttribute("sexos", ESexo.values());
        model.addAttribute("bebe", b);
        model.addAttribute("mae", b.getParturiente());
        model.addAttribute("pai", b.getNomedoPai());

        model.addAttribute("medico", b.getMedicos());


        return "medico/newBebe";
    }

    @PostMapping("/bebe/save")
    public String pageSaveBebe(@ModelAttribute Bebe bebe,
                                   Model model, Authentication auth){


        medServ.saveBebe (bebe);

        return "paciente/bercariovirtual";


    }


    @PostMapping("/paciente/save")
    public String pageSavePaciente(@ModelAttribute Parturiente part,
                                   Model model, Authentication auth){

       // part.setBebe(  bebedao.getById( part.getBebe().getId() ));

        medServ.savePaciente( part);

        return "medico/listagemPacientes";


    }

}
