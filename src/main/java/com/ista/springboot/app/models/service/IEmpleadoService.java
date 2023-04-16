package com.ista.springboot.app.models.service;

import java.util.List;

import com.ista.springboot.app.models.entity.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	
	public void save(Empleado empleado);
	
	public Empleado findOne(Long id);
	
	public void delete(Long id);
}
