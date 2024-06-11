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

import com.example.PI_02.entity.Cajas;
import com.example.PI_02.excepcion.RecursoNoEncontradoExcepcion;
import com.example.PI_02.service.ICajasService;

@RestController
@RequestMapping("/api_ropa")
public class CajasController {
	@Autowired
	private ICajasService cajasService;
	
	@GetMapping("/cajas")
	public List<Cajas> listar(){return cajasService.buscarTodos();}
	
	@PostMapping("/cajas")
	public Cajas guardar(@RequestBody Cajas cajas) {return cajasService.guardar(cajas);
	}
	
	@GetMapping("/cajas/{id}")
	public ResponseEntity<Cajas> buscarPorId(@PathVariable Integer id) {
		Cajas cajas = cajasService.buscarPorId(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id));
		return ResponseEntity.ok(cajas);
	}
	
	@PutMapping("/cajas/{id}")
	public ResponseEntity<Cajas> actualizar(@PathVariable Integer id, @RequestBody Cajas cajas){
		if(!cajasService.buscarPorId(id).isPresent()) {
			throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id);
		}
		cajas.setId(id);
		cajasService.actualizar(cajas);
		return ResponseEntity.ok(cajas);
	}
	@DeleteMapping("/cajas/{id}")
	public void eliminar(@PathVariable Integer id) {
		cajasService.eliminar(id);
	}
}
