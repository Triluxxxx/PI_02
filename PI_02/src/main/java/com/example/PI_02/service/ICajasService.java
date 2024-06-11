package com.example.PI_02.service;

import java.util.List;
import java.util.Optional;

import com.example.PI_02.entity.Cajas;

public interface ICajasService {

	List<Cajas> buscarTodos();
    Cajas guardar(Cajas cajas);
    void eliminar(Integer id);
    void actualizar(Cajas cajas);
    Optional<Cajas> buscarPorId(Integer id);
}
