package com.desafio.hepta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.hepta.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
