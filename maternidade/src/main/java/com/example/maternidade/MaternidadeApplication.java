package com.example.maternidade;

import com.example.maternidade.model.Usuario;
import com.example.maternidade.model.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class MaternidadeApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MaternidadeApplication.class, args);
	}

	@Autowired
	UsuarioDAO usuarioDAO;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario u1 = Usuario.builder()
				.login("usuario")
				.senha("111")
				.build();

		if (usuarioDAO.count() == 0) {
			usuarioDAO.save(u1);
		}
		Optional<Usuario> user1 = usuarioDAO.findById(1);
		if (user1.isPresent()) {
			System.out.println("==> " + user1.get().getLogin());
		} else {
			System.out.println("Usuário não encontrado!!");
		}

		if (usuarioDAO.findByLoginAndSenha("mec", "111") != null) {
			System.out.println("Usuário encontrado!!!");
		}
	}

}
