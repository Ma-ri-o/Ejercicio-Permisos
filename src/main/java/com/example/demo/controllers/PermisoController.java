package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Permiso;
import com.example.demo.service.IPermisoService;

@RestController
@RequestMapping("/api")
public class PermisoController {

	@Autowired
	private IPermisoService permisoService;

	@GetMapping("/select/{id}")
	public Permiso select(@PathVariable Long id) {
		return permisoService.findByIdPermiso(id);
	}

	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Permiso permiso) {

		if (permiso != null) {
			permisoService.save(permiso);
			return new ResponseEntity<String>("Permiso creado correctamente", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Se genero un conflicto", HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Permiso permiso) {

		Permiso permisoBD = null;
		permisoBD = permisoService.findByIdPermiso(id);
		if (permisoBD != null) {
			permisoBD.setNombreEmpleado(permiso.getNombreEmpleado());
			permisoBD.setApellidosEmpleado(permiso.getApellidosEmpleado());
			permisoBD.setTipoPermiso(permiso.getTipoPermiso());
			
			permisoService.updatePermiso(permisoBD);
			
			return new ResponseEntity<>(permisoBD, HttpStatus.CREATED);

		}else {
			return new ResponseEntity<String>("Genero un conflicto", HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
		permisoService.deletePermiso(id);
		return new ResponseEntity<String>("Borrado correctamente",HttpStatus.OK);
	}
}
