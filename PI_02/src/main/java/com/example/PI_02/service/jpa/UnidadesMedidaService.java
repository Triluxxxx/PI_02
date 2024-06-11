package com.example.PI_02.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI_02.entity.UnidadesMedida;
import com.example.PI_02.repository.UnidadesMedidaRepository;
import com.example.PI_02.service.IUnidadesMedidaService;

@Service
public class UnidadesMedidaService implements IUnidadesMedidaService {

	@Autowired
	private UnidadesMedidaRepository unidadesMedidaRepository;
	
	@Override
	public List<UnidadesMedida> buscarTodos() {
		return unidadesMedidaRepository.findAll();
	}

	@Override
	public UnidadesMedida guardar(UnidadesMedida unidadesMedida) {
		return unidadesMedidaRepository.save(unidadesMedida);
	}

	@Override
	public void eliminar(Integer id) {
		unidadesMedidaRepository.deleteById(id);
	}

	@Override
	public void actualizar(UnidadesMedida unidadesMedida) {
		unidadesMedidaRepository.save(unidadesMedida);
		
	}

	@Override
	public Optional<UnidadesMedida> buscarPorId(Integer id) {
		return unidadesMedidaRepository.findById(id);
	}

}
