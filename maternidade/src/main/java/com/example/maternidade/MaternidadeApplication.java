package com.example.maternidade;

import com.example.maternidade.model.*;
import com.example.maternidade.model.dao.AcompanhanteDAO;
import com.example.maternidade.model.dao.BebeDAO;
import com.example.maternidade.model.dao.MedicoDAO;
import com.example.maternidade.model.dao.ParturienteDAO;
import com.example.maternidade.model.enums.ESexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Optional;

import static com.example.maternidade.model.enums.EEspecialidadeMedico.NEONATOLOGISTA;
import static java.sql.Types.NULL;

@SpringBootApplication
@ComponentScan("com.example.maternidade")
public class MaternidadeApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MaternidadeApplication.class, args);
	}

	@Autowired
	ParturienteDAO parturiente;
	@Autowired
	MedicoDAO medico;

	@Autowired
	BebeDAO bebe;

	@Autowired
	AcompanhanteDAO acompanhante;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Bebe be = (Bebe) Bebe.builder()
				.nome("Jesusedro")
				.login("bebe")
				.senha(passwordEncoder.encode("senhadobebe"))
				.id(1)
				.nomedoPai("Deus")
				.build();
		if (bebe.count() == 0) {
			bebe.save(be);
		}


		if (bebe.findByLoginAndSenha("bebe", "senhadobebe") != null) {
			System.out.println("Bebe encontrada!!!");
		}
		System.out.println("Bebe salvo :: "+be.getId());

		Acompanhante ac = (Acompanhante) Acompanhante.builder()
				.grauParentesco("amigo")
				.login("ac")
				.senha(passwordEncoder.encode("ac"))
				.id(1)
				.nome("nome")
				.build();
		if (acompanhante.count() == 0) {
			acompanhante.save(ac);
		}
		Optional<Acompanhante> user3 = acompanhante.findById(1);
		if (user3.isPresent()) {
			System.out.println("==> " + user3.get().getLogin());
		} else {
			System.out.println("Ac não encontrada!!");
		}

		if (parturiente.findByLoginAndSenha("ac", "ac") != null) {
			System.out.println("Ac encontrada!!!");
		}

		System.out.println("Ac salva :: "+ac.getId());

		Medico m1 = (Medico) Medico.builder()
				.crm("123")
				.especialidade(NEONATOLOGISTA)
				.login("login")
				.senha(passwordEncoder.encode("senha"))
				.id(1)
				.nome("nome")
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

		Parturiente p1 = (Parturiente) Parturiente.builder()
				.id(1)
				.login("pa")
				.senha(passwordEncoder.encode("pa"))
				.nome("nome")
				.build();

		if (parturiente.count() == 0) {
			parturiente.save(p1);
		}
//		Optional<Parturiente> user2 = parturiente.findByLogin();
//		if (user2.isPresent()) {
//			System.out.println("==> " + user2.get().getLogin());
//		} else {
//			System.out.println("Parturiente não encontrada!!");
//		}

		if (parturiente.findByLoginAndSenha("pa", "pa") != null) {
			System.out.println("Parturiente encontrada!!!");
		}

		System.out.println("Parturiente salva :: "+p1.getId());
	}

}
