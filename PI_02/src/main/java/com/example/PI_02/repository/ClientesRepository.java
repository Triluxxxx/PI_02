package com.example.PI_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PI_02.entity.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
	

}
