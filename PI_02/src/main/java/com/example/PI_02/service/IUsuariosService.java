package com.example.PI_02.service;

import java.util.List;
import java.util.Optional;

import com.example.PI_02.entity.Usuarios;

public interface IUsuariosService {
	
	List<Usuarios> buscarTodos();
    Usuarios guardar(Usuarios usuarios);
    void eliminar(Integer id);
    void actualizar(Usuarios usuarios);
    Optional<Usuarios> buscarPorId(Integer id);

}
