package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.PermisoDao;
import com.example.demo.entity.Permiso;

@Service
public class PermisoServiceImpl implements IPermisoService {

	@Autowired
	private PermisoDao permisoDao;

	@Override
	@Transactional(readOnly = true)
	public Permiso findByIdPermiso(Long id) {

		return permisoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Permiso updatePermiso(Permiso permiso) {
		return (Permiso) permisoDao.save(permiso);
	}

	@Override
	@Transactional
	public void deletePermiso(Long id) {
		permisoDao.deleteById(id);
	}

	
	@Override
	@Transactional
	public void save(Permiso p) {
		permisoDao.save(p);
	}

}
