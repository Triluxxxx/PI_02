package com.example.PI_02.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI_02.entity.Proveedor;
import com.example.PI_02.repository.ProveedorRepository;
import com.example.PI_02.service.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public List<Proveedor> buscarTodos() {
		return proveedorRepository.findAll();
	}

	@Override
	public Proveedor guardar(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public void eliminar(Integer id) {
		proveedorRepository.deleteById(id);
		
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
		
	}

	@Override
	public Optional<Proveedor> buscarPorId(Integer id) {
		return proveedorRepository.findById(id);
	}

}
