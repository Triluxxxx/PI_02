package com.example.PI_02.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI_02.entity.Cajas;
import com.example.PI_02.repository.CajasRepository;
import com.example.PI_02.service.ICajasService;

@Service
public class CajasService implements ICajasService {
	
	@Autowired
	private CajasRepository cajasRepository;

	@Override
	public List<Cajas> buscarTodos() {
		return cajasRepository.findAll();
	}

	@Override
	public Cajas guardar(Cajas cajas) {
		return cajasRepository.save(cajas);
	}

	@Override
	public void eliminar(Integer id) {
		cajasRepository.deleteById(id);
		
	}

	@Override
	public void actualizar(Cajas cajas) {
		cajasRepository.save(cajas);
		
	}

	@Override
	public Optional<Cajas> buscarPorId(Integer id) {
		return cajasRepository.findById(id);
	}


}
