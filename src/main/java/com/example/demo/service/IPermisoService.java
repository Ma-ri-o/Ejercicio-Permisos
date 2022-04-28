package com.example.demo.service;

import com.example.demo.entity.Permiso;

public interface IPermisoService {

	public Permiso findByIdPermiso(Long id);

	public void save(Permiso p);

	public Permiso updatePermiso(Permiso permiso);
	
	public void deletePermiso(Long id);
	
	
}
