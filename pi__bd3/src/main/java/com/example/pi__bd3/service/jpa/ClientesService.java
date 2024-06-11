package com.example.pi__bd3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pi__bd3.entity.Clientes;
import com.example.pi__bd3.repository.ClientesRepository;
import com.example.pi__bd3.service.IClientesService;

@Service
public class ClientesService implements IClientesService{
	
	@Autowired
	private ClientesRepository repoClientes;
	public List<Clientes> buscarTodos(){
		return repoClientes.findAll();
	}
	public void guardar (Clientes cliente) {
		repoClientes.save(cliente);
	}
	public void modificar (Clientes cliente) {
		repoClientes.save(cliente);
	}
	public Optional<Clientes> buscarId(Integer id) {
		return repoClientes.findById(id);
	}
	public void eliminar (Integer id) {
	   repoClientes.deleteById(id);
	}
}
