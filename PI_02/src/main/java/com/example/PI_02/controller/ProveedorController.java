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


import com.example.PI_02.entity.Proveedor;
import com.example.PI_02.excepcion.RecursoNoEncontradoExcepcion;
import com.example.PI_02.service.IProveedorService;

@RestController
@RequestMapping("/api_ropa")
public class ProveedorController {
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/proveedor")
	public List<Proveedor> listar(){return proveedorService.buscarTodos();}
	
	@PostMapping("/proveedor")
	public Proveedor guardar(@RequestBody Proveedor proveedor) {return proveedorService.guardar(proveedor);
	}
	
	@GetMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> buscarPorId(@PathVariable Integer id) {
		Proveedor proveedor = proveedorService.buscarPorId(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id));
		return ResponseEntity.ok(proveedor);
	}
	
	@PutMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> actualizar(@PathVariable Integer id, @RequestBody Proveedor proveedor){
		if(!proveedorService.buscarPorId(id).isPresent()) {
			throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id);
		}
		proveedor.setId(id);
		proveedorService.actualizar(proveedor);
		return ResponseEntity.ok(proveedor);
	}
	@DeleteMapping("/proveedor/{id}")
	public void eliminar(@PathVariable Integer id) {
		proveedorService.eliminar(id);
	}
}


