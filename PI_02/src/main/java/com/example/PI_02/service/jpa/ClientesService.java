package com.example.PI_02.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI_02.entity.Clientes;
import com.example.PI_02.repository.ClientesRepository;
import com.example.PI_02.service.IClientesService;

@Service
public class ClientesService implements IClientesService {
	@Autowired
	private ClientesRepository clientesRepository;

	@Override
	public List<Clientes> buscarTodos() {
		return clientesRepository.findAll();
	}

	@Override
	public Clientes guardar(Clientes clientes) {
		return clientesRepository.save(clientes);
	}

	@Override
	public void eliminar(Integer id) {
		clientesRepository.deleteById(id);
		
	}

	@Override
	public void actualizar(Clientes clientes) {
		clientesRepository.save(clientes);
	}

	@Override
	public Optional<Clientes> buscarPorId(Integer id) {
		return clientesRepository.findById(id);
	}
}
