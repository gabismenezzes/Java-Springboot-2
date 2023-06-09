package com.example.maternidade;

import com.example.maternidade.model.Acompanhante;
import com.example.maternidade.model.Bebe;
import com.example.maternidade.model.Medico;
import com.example.maternidade.model.Parturiente;
import com.example.maternidade.model.dao.AcompanhanteDAO;
import com.example.maternidade.model.dao.BebeDAO;
import com.example.maternidade.model.dao.MedicoDAO;
import com.example.maternidade.model.dao.ParturienteDAO;
import com.example.maternidade.model.enums.ESexo;
import com.example.maternidade.model.enums.ETipoParto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static com.example.maternidade.model.enums.EEspecialidadeMedico.NEONATOLOGISTA;

@SpringBootApplication
@ComponentScan("com.example.maternidade")
public class MaternidadeApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MaternidadeApplication.class, args);
	}

	@Autowired
	ParturienteDAO parturienteDAO;
	@Autowired
	MedicoDAO medico;

	@Autowired
	BebeDAO bebe;

	@Autowired
	AcompanhanteDAO acompanhante;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Medico m1 = (Medico) Medico.builder()
				.crm("123")
				.especialidade(NEONATOLOGISTA)
				.login("login")
				.senha("senha")
				.id(1)
				.build();

		if (medico.count() == 0) {
			medico.save(m1);
		}
		Optional<Medico> user1 = medico.findById(1);
		if (user1.isPresent()) {
			System.out.println("==> " + user1.get().getLogin());
		} else {
			System.out.println("Médico não encontrado!!");
		}

		if (medico.findByLoginAndSenha("login", "senha") != null) {
			System.out.println("Médico encontrado!!!");
		}

		Acompanhante a1 = (Acompanhante) Acompanhante.builder()
				.grauParentesco("marido")
				.id(1)
				.login("acompanhante")
				.senha("senha")
				.build();

		if (acompanhante.count() == 0) {
			acompanhante.save(a1);
		}
		Optional<Acompanhante> user2 = acompanhante.findById(1);
		if (user2.isPresent()) {
			System.out.println("==> " + user2.get().getLogin());
		} else {
			System.out.println("Acompanhante não encontrado!!");
		}

		if (medico.findByLoginAndSenha("acompanhante", "senha") != null) {
			System.out.println("Acompanhante encontrado!!!");
		}

		System.out.println("Acompanhante salvo :: "+a1.getId());
	}

}
