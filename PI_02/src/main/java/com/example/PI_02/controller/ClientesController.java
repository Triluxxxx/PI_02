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

import com.example.PI_02.entity.Clientes;
import com.example.PI_02.excepcion.RecursoNoEncontradoExcepcion;
import com.example.PI_02.service.IClientesService;

@RestController
@RequestMapping("/api_ropa")
public class ClientesController {
	@Autowired
	private IClientesService clientesService;
	
	@GetMapping("/clientes")
	public List<Clientes> listar(){return clientesService.buscarTodos();}
	
	@PostMapping("/clientes")
	public Clientes guardar(@RequestBody Clientes clientes) {return clientesService.guardar(clientes);
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Clientes> buscarPorId(@PathVariable Integer id) {
		Clientes clientes = clientesService.buscarPorId(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id));
		return ResponseEntity.ok(clientes);
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Clientes> actualizar(@PathVariable Integer id, @RequestBody Clientes clientes){
		if(!clientesService.buscarPorId(id).isPresent()) {
			throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id);
		}
		clientes.setId(id);
		clientesService.actualizar(clientes);
		return ResponseEntity.ok(clientes);
	}
	@DeleteMapping("/clientes/{id}")
	public void eliminar(@PathVariable Integer id) {
		clientesService.eliminar(id);
	}
}

