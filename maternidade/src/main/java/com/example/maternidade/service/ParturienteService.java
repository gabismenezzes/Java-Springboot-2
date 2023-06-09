package com.example.maternidade.service;

import com.example.maternidade.model.Acompanhante;
import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Parturiente;
import com.example.maternidade.model.dao.BebeDAO;
import com.example.maternidade.model.dao.MedicoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public class ParturienteService {

    @Autowired
    BebeDAO bebe;
    @Autowired
    MedicoDAO medico;

    public ArrayList<Bebe> getBebes(int idParturienteL) {
        return bebe.findByParturienteId(idParturienteL);
    }

    @Transactional
    public void saveCarro(Bebe b, Medico m, Acompanhante acompanhante, Parturiente parturiente) {

        b.setMae( parturiente );
        bebe.save(b);

    }
}
