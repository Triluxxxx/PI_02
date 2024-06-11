package com.example.PI_02.service;

import java.util.List;
import java.util.Optional;

import com.example.PI_02.entity.Clientes;


public interface IClientesService {

	List<Clientes> buscarTodos();
    Clientes guardar(Clientes clientes);
    void eliminar(Integer id);
    void actualizar(Clientes clientes);
    Optional<Clientes> buscarPorId(Integer id);

}
