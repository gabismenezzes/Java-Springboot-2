package com.example.maternidade.service;

import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Parturiente;
import com.example.maternidade.model.dao.MedicoDAO;
import com.example.maternidade.model.dao.ParturienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class MedicoService {
    @Autowired
    MedicoDAO medico;

    @Autowired
    ParturienteDAO paciente;

    public ArrayList<Parturiente> getPacientes(String login) {
        return paciente.findByLogin(login);
    }


    @Transactional
    public void savePaciente(Parturiente p, Bebe b) {

        //Cliente c = clientes.findByLogin(username);
//        Cliente c = clientes.findById(2).get();
        p.setBebe( b );
        paciente.save(p);

    }
}
