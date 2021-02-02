package com.desafio.hepta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.hepta.entities.Setor;
import com.desafio.hepta.services.SetorService;

@RestController
@RequestMapping(value = "/setores")
@CrossOrigin
public class SetorController {
	
	@Autowired
	SetorService service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Setor>> findAll(){
		try{
			List<Setor> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		catch(Exception e) {
			throw new RuntimeException("Erro desconhecido");
		}
		
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Setor> findById(@PathVariable Integer id){
		try {
			Setor setor = service.findById(id);
			return ResponseEntity.ok().body(setor);
		}
		catch(Exception e) {
			throw new RuntimeException("Setor nao encontrado");
		}
	}
}
