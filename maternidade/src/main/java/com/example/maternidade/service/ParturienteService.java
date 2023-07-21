package com.example.maternidade.service;

import com.example.maternidade.model.Acompanhante;
import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Parturiente;
import com.example.maternidade.model.dao.BebeDAO;
import com.example.maternidade.model.dao.MedicoDAO;
import com.example.maternidade.model.dao.ParturienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ParturienteService {

    @Autowired
    private BebeDAO bebe;
    @Autowired
    private MedicoDAO medico;

    @Autowired
    private ParturienteDAO parturiente;

    public ArrayList<Bebe> getBebes(int idPacienteLogado) {
        return bebe.findById(idPacienteLogado);
    }

    ArrayList<Parturiente> getPacientes(int idPacienteLogado) {
        return parturiente.findById(idPacienteLogado);
    }

    @Transactional
    public void saveBebe(Bebe b, Parturiente parturiente) {
        b.setParturiente(parturiente);
        bebe.save(b);
    }
}

