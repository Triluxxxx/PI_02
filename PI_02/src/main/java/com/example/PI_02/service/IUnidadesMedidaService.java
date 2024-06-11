package com.example.PI_02.service;

import java.util.List;
import java.util.Optional;

import com.example.PI_02.entity.UnidadesMedida;

public interface IUnidadesMedidaService {
	List<UnidadesMedida> buscarTodos();
    UnidadesMedida guardar(UnidadesMedida unidadesMedida);
    void eliminar(Integer id);
    void actualizar(UnidadesMedida unidadesMedida);
    Optional<UnidadesMedida> buscarPorId(Integer id);

}
