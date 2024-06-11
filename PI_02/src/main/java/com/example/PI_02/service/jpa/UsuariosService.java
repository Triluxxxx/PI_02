package com.example.PI_02.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI_02.entity.Usuarios;
import com.example.PI_02.repository.UsuariosRepository;
import com.example.PI_02.service.IUsuariosService;

@Service
public class UsuariosService implements IUsuariosService {
	@Autowired
	private UsuariosRepository usuariosRepository;

	@Override
	public List<Usuarios> buscarTodos() {
		return usuariosRepository.findAll();
	}

	@Override
	public Usuarios guardar(Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}

	@Override
	public void eliminar(Integer id) {
		 usuariosRepository.deleteById(id);
		
	}

	@Override
	public void actualizar(Usuarios usuarios) {
		usuariosRepository.save(usuarios);
	}

	@Override
	public Optional<Usuarios> buscarPorId(Integer id) {
		return usuariosRepository.findById(id);
	}
	

}
