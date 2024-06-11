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

import com.example.PI_02.entity.UnidadesMedida;
import com.example.PI_02.excepcion.RecursoNoEncontradoExcepcion;
import com.example.PI_02.service.IUnidadesMedidaService;

@RestController
@RequestMapping("/api_ropa")
public class UnidadesMedidaController {
	@Autowired
	private IUnidadesMedidaService unidadesMedidaService;
	
	@GetMapping("/unidadesMedida")
	public List<UnidadesMedida> listar(){return unidadesMedidaService.buscarTodos();}
	
	@PostMapping("/unidadesMedida")
	public UnidadesMedida guardar(@RequestBody UnidadesMedida unidadesMedida) {return unidadesMedidaService.guardar(unidadesMedida);
	}
	
	@GetMapping("/unidadesMedida/{id}")
	public ResponseEntity<UnidadesMedida> buscarPorId(@PathVariable Integer id) {
		UnidadesMedida unidadesMedida = unidadesMedidaService.buscarPorId(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id));
		return ResponseEntity.ok(unidadesMedida);
	}
	
	@PutMapping("/unidadesMedida/{id}")
	public ResponseEntity<UnidadesMedida> actualizar(@PathVariable Integer id, @RequestBody UnidadesMedida unidadesMedida){
		if(!unidadesMedidaService.buscarPorId(id).isPresent()) {
			throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id);
		}
		unidadesMedida.setId(id);
		unidadesMedidaService.actualizar(unidadesMedida);
		return ResponseEntity.ok(unidadesMedida);
	}
	@DeleteMapping("/unidadesMedida/{id}")
	public void eliminar(@PathVariable Integer id) {
		unidadesMedidaService.eliminar(id);
	}
}


