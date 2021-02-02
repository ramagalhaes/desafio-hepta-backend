package com.desafio.hepta;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.hepta.entities.Funcionario;
import com.desafio.hepta.services.FuncionarioService;
import com.desafio.hepta.services.SetorService;

@SpringBootTest
class DesafioHeptaApplicationTests {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	SetorService setorService;

	@Test
	void contextLoads() {
	}
	
	//O metodos buscarao os funcionarios que estao no arquivo 'TestConfig', que e reponsavel pelo seeding do banco de dados
	
	@Test
	public void procurarFuncionarios() {
		List<Funcionario> list = null;
		list = funcionarioService.findAll();
		Assert.assertNotNull(list);
	}
	
	//no banco de dados: id 1 e 2
	@Test
	public void funcionarioPorId() {
		Funcionario funcionario = null;
		funcionario = funcionarioService.findById(1);
		Assert.assertNotNull(funcionario);
		Assert.assertEquals("raphael", funcionario.getNome());
	}
	
	@Test
	public void inserirFuncionario() {
		List<Funcionario> list1 = funcionarioService.findAll();
		Funcionario funcionario = new Funcionario(null,"teste",setorService.findByNome("tecnologia"),200.00,"teste@gmail.com", 20);
		funcionarioService.insert(funcionario);
		List<Funcionario> list2 = funcionarioService.findAll();
		Assert.assertTrue(list1.size() < list2.size());
	}
	
	@Test
	public void deletarFuncionario() {
		List<Funcionario> list1 = funcionarioService.findAll();
		funcionarioService.deleteById(1);
		List<Funcionario> list2 = funcionarioService.findAll();
		Assert.assertTrue(list1.size() > list2.size());
		
	}
}
