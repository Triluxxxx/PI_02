package com.example.PI_02.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI_02.entity.Modulos;
import com.example.PI_02.repository.ModulosRepository;
import com.example.PI_02.service.IModulosService;

@Service
public class ModulosService implements IModulosService {
	@Autowired
	private ModulosRepository modulosRepository;

	@Override
	public List<Modulos> buscarTodos() {
		return modulosRepository.findAll();
	}

	@Override
	public Modulos guardar(Modulos modulos) {
		return modulosRepository.save(modulos);
	}

	@Override
	public void eliminar(Integer id) {
		modulosRepository.deleteById(id);;
		
	}

	@Override
	public void actualizar(Modulos modulos) {
		modulosRepository.save(modulos);
		
	}

	@Override
	public Optional<Modulos> buscarPorId(Integer id) {
		return modulosRepository.findById(id);
	}
	

}
