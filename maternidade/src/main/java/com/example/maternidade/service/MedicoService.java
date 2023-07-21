package com.example.maternidade.service;

import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Parturiente;
import com.example.maternidade.model.dao.BebeDAO;
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
    BebeDAO bebe;

    @Autowired
    ParturienteDAO paciente;

    public ArrayList<Parturiente> getMeusPacientes(int idPacienteLogado) {
        return paciente.findById(idPacienteLogado);
    }

    @Transactional
    public void saveBebe(Bebe b){

//        b.setMedicos( medico.findById(b.getMedicos().getId()).get());
        //b.setParturiente( paciente.findById(b.getParturiente().getId()).get());
        bebe.save(b);
    }

    @Transactional
    public void savePaciente(Parturiente p) {

        paciente.save(p);

    }
}
