package com.desafio.hepta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.hepta.entities.Setor;
import com.desafio.hepta.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;
	
	public List<Setor> findAll(){
		return repository.findAll();
	}
	
	public Setor findById(Integer id) {
		Optional<Setor> obj = repository.findById(id);
		return obj.get();
	}
	
	public Setor insert(Setor obj) {
		return repository.save(obj);
	}
	
	public Setor update(Setor obj, Integer id) {	
		Optional<Setor> s = repository.findById(id);
		Setor setor = s.get();
		setor = obj;
		setor.setId(id);
		return repository.save(obj);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Setor findByNome(String nome) {
		return repository.findByNomeContainingIgnoreCase(nome);
		
		
	}
	
}
