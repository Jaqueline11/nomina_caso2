package com.ista.springboot.app.models.service;

import java.util.List;

import com.ista.springboot.app.models.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.app.models.dao.IEmpleadoDao;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao clienteDao;
	
	
	@Transactional(readOnly=true)
	@Override
	public List<Empleado> findAll() {
		
		return clienteDao.findAll();
	}

	@Transactional
	@Override
	public void save(Empleado empleado) {
		
		clienteDao.save(empleado);
	}

	@Transactional(readOnly=true)
	@Override
	public Empleado findOne(Long id) {
		
		return clienteDao.findOne(id);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		clienteDao.delete(id);
		
	}
	
	

}
