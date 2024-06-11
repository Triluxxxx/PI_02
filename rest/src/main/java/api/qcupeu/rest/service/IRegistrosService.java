package api.qcupeu.rest.service;

import java.util.List;
import java.util.Optional;

import api.qcupeu.rest.entity.Registros;

public interface IRegistrosService {
	List<Registros> buscarTodos();
	
	void guardar (Registros registro);
	
	void modificar (Registros registro);
	
	Optional<Registros> buscarId(Integer id); 
	
	void eliminar (Integer id); 

}
