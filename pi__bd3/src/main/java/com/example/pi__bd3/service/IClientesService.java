package com.example.pi__bd3.service;

import java.util.List;
import java.util.Optional;

import com.example.pi__bd3.entity.Clientes;


public interface IClientesService {

    List<Clientes> buscarTodos();
	
	void guardar (Clientes cliente); 
	
	void modificar (Clientes cliente);
	
	Optional<Clientes> buscarId(Integer id); 
	
	void eliminar (Integer id); 

}
