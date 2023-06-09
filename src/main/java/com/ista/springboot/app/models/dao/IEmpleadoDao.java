package com.ista.springboot.app.models.dao;

import java.util.List;

import com.ista.springboot.app.models.entity.Empleado;

public interface IEmpleadoDao {

		public List<Empleado> findAll();
		
		public void save(Empleado empleado);
		
		public Empleado findOne(Long id);
		
		public void delete(Long id);
}
