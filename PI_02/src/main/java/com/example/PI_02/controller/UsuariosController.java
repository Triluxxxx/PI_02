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

import com.example.PI_02.entity.Usuarios;
import com.example.PI_02.excepcion.RecursoNoEncontradoExcepcion;
import com.example.PI_02.service.IUsuariosService;

@RestController
@RequestMapping("/api_ropa")
public class UsuariosController {
	@Autowired
	private IUsuariosService usuariosService;
	
	@GetMapping("/usuarios")
	public List<Usuarios> listar(){return usuariosService.buscarTodos();}
	
	@PostMapping("/usuarios")
	public Usuarios guardar(@RequestBody Usuarios usuarios) {return usuariosService.guardar(usuarios);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> buscarPorId(@PathVariable Integer id) {
		Usuarios usuarios = usuariosService.buscarPorId(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id));
		return ResponseEntity.ok(usuarios);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> actualizar(@PathVariable Integer id, @RequestBody Usuarios usuarios){
		if(!usuariosService.buscarPorId(id).isPresent()) {
			throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id:" + id);
		}
		usuarios.setId(id);
		usuariosService.actualizar(usuarios);
		return ResponseEntity.ok(usuarios);
	}
	@DeleteMapping("/usuarios/{id}")
	public void eliminar(@PathVariable Integer id) {
		usuariosService.eliminar(id);
	}
}
