package com.example.maternidade;

import com.example.maternidade.model.Medico;
import com.example.maternidade.model.dao.MedicoDAO;
import com.example.maternidade.model.enums.EEspecialidadeMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import java.util.Optional;

import static com.example.maternidade.model.enums.EEspecialidadeMedico.NEONATOLOGISTA;

@SpringBootApplication
@ComponentScan("com.example.maternidade")
public class MaternidadeApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MaternidadeApplication.class, args);
	}

	@Autowired
	MedicoDAO medico;

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
			System.out.println("Usuário não encontrado!!");
		}

		if (medico.findByLoginAndSenha("login", "senha") != null) {
			System.out.println("Usuário encontrado!!!");
		}
	}

}
