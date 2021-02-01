package com.desafio.hepta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.hepta.entities.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer>{
	
	public Setor findByNomeContainingIgnoreCase(String txt);
}
