package com.desafio.hepta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.hepta.entities.Funcionario;
import com.desafio.hepta.entities.Setor;
import com.desafio.hepta.repositories.FuncionarioRepository;
import com.desafio.hepta.repositories.SetorRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired 
	private SetorRepository setorRepository;
	
	
	//SEEDING do banco de testes
	@Override
	public void run(String... args) throws Exception {
		Setor setor = new Setor(null, "vendas");
		Setor setor2 = new Setor(null, "tecnologia");
		
		
		setorRepository.save(setor);
		setorRepository.save(setor2);
		
		Funcionario f1 = new Funcionario(null, "raphael", setor, 100.0, "raphael@hotmail.com", 22);
		Funcionario f2 = new Funcionario(null, "Pedro", setor, 150.0, "pedro@hotmail.com", 40);
		
		funcionarioRepository.save(f1);
		funcionarioRepository.save(f2);
	

	}
}
