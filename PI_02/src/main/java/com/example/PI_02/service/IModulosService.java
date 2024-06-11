package com.example.PI_02.service;

import java.util.List;
import java.util.Optional;
import com.example.PI_02.entity.Modulos;

public interface IModulosService {

	List<Modulos> buscarTodos();
    Modulos guardar(Modulos modulos);
    void eliminar(Integer id);
    void actualizar(Modulos modulos);
    Optional<Modulos> buscarPorId(Integer id);
}
