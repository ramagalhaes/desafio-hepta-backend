package com.desafio.hepta.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.hepta.entities.Funcionario;
import com.desafio.hepta.services.FuncionarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		try{
			List<Funcionario> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		catch(Exception e) {
			throw new RuntimeException("Erro desconhecido");
		}
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Integer id){
		try {
			Funcionario func = service.findById(id);
			return ResponseEntity.ok().body(func);
		}
		catch(Exception e) {
			throw new RuntimeException("Funcionario nao encontrado");
		}
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Funcionario> insert(@RequestBody Funcionario funcionario){
		funcionario = service.insert(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(funcionario);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		try {
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		catch(Exception e) {
			throw new RuntimeException("Funcionario nao encontrado");
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable Integer id, @RequestBody Funcionario obj){
		try {
			obj = service.update(obj, id);
			return ResponseEntity.ok().body(obj);
		}
		catch(Exception e) {
			throw new RuntimeException("Nao foi possivel atualizar o usuario");
		}
	}
}
