package api.qcupeu.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.qcupeu.rest.entity.Clientes;
import api.qcupeu.rest.service.IClientesService;


@RestController
@RequestMapping("/apisspringboot")
public class ClientesController {
	@Autowired
	private IClientesService serviceClientes;
	@GetMapping("/clientes")
	public List<Clientes> buscartodos(){
		return serviceClientes.buscarTodos();
	}
	@PostMapping("/clientes")
	public Clientes guardar(@RequestBody Clientes cliente) {
		serviceClientes.guardar(cliente);
		return cliente;
	}
	@PutMapping("/clientes")
	public Clientes modificar(@RequestBody Clientes cliente) {
		serviceClientes.modificar(cliente);
		return cliente; 
	}
	@GetMapping("/clientes/{id}")
	public Optional<Clientes> buscarId(@PathVariable("id") Integer id){
		return serviceClientes.buscarId(id);
	}
	@DeleteMapping("/clientes/{id}")
	public String eliminar(@PathVariable("id") Integer id) {
		serviceClientes.eliminar(id);
		return "Cliente eliminado";
	}
}
