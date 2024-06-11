package api.qcupeu.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.qcupeu.rest.entity.Registros;
import api.qcupeu.rest.service.IRegistrosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/apisspringboot")
public class RegistrosController {
	@Autowired
	private IRegistrosService serviceRegistros;
	@GetMapping("/registros")
	public List<Registros> buscarTodos(){
		return serviceRegistros.buscarTodos();
	}
	@PostMapping("/registros")
	public Registros guardar(@RequestBody Registros registro) {
		serviceRegistros.guardar(registro);
		return registro;
	}
	@PutMapping("/registros")
	public Registros modificar(@RequestBody Registros registro) {
		serviceRegistros.modificar(registro);
		return registro; 
	}
	@GetMapping("/registros/{id}")
	public Optional<Registros> buscarId(@PathVariable("id")Integer id){
		return serviceRegistros.buscarId(id);
	}
	@DeleteMapping("/registros/{id}")
	public String eliminar(@PathVariable("id")Integer id) {
		serviceRegistros.eliminar(id);
		return "Registro eliminado";
	}
}
