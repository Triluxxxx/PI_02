package com.example.PI_02.service;

import java.util.List;
import java.util.Optional;

import com.example.PI_02.entity.Proveedor;

public interface IProveedorService {

	List<Proveedor> buscarTodos();
    Proveedor guardar(Proveedor proveedor);
    void eliminar(Integer id);
    void actualizar(Proveedor proveedor);
    Optional<Proveedor> buscarPorId(Integer id);
}
