package api.qcupeu.rest.service;

import java.util.List;
import java.util.Optional;

import api.qcupeu.rest.entity.Clientes;


public interface IClientesService {
	
	List<Clientes> buscarTodos();
	
	void guardar (Clientes cliente); 
	
	void modificar (Clientes cliente);
	
	Optional<Clientes> buscarId(Integer id); 
	
	void eliminar (Integer id); 

}
