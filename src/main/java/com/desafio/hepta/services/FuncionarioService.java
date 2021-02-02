package com.desafio.hepta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.hepta.entities.Funcionario;
import com.desafio.hepta.entities.Setor;
import com.desafio.hepta.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private SetorService setorService;

	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll(){
		return repository.findAll();
	}
	
	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Funcionario insert(Funcionario obj) {
		Setor setor = setorService.findByNome(obj.getSetor().getNome());
		obj.setSetor(setor);
		return repository.save(obj);
	}
	
	public Funcionario update(Funcionario obj, Integer id) {	
		Optional<Funcionario> f = repository.findById(id);
		Funcionario funcionario = f.get();
		funcionario = obj;
		funcionario.setId(id);
		Setor setor = setorService.findByNome(funcionario.getSetor().getNome());
		funcionario.setSetor(setor);
		return repository.save(obj);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
