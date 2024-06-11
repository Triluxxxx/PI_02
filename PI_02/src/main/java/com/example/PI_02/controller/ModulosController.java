package com.example.PI_02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PI_02.entity.Modulos;
import com.example.PI_02.excepcion.RecursoNoEncontradoExcepcion;
import com.example.PI_02.service.IModulosService;

@RestController
@RequestMapping("/api_ropa")
public class ModulosController {
	@Autowired
	private IModulosService modulosService;
	
	@GetMapping("/modulos")
	public List<Modulos> listar(){return modulosService.buscarTodos();}
	
	@PostMapping("/modulos")
	public Modulos guardar(@RequestBody Modulos modulos) {return modulosService.guardar(modulos);
	}
	
	@GetMapping("/modulos/{id}")
	public ResponseEntity<Modulos> buscarPorId(@PathVariable Integer id) {
		Modulos modulos = modulosService.buscarPorId(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id));
		return ResponseEntity.ok(modulos);
	}
	
	@PutMapping("/modulos/{id}")
	public ResponseEntity<Modulos> actualizar(@PathVariable Integer id, @RequestBody Modulos modulos){
		if(!modulosService.buscarPorId(id).isPresent()) {
			throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id);
		}
		modulos.setId(id);
		modulosService.actualizar(modulos);
		return ResponseEntity.ok(modulos);
	}
	@DeleteMapping("/modulos/{id}")
	public void eliminar(@PathVariable Integer id) {
		modulosService.eliminar(id);
	}
}

