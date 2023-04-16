package com.ista.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ista.springboot.app.models.entity.Empleado;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoDaoImpl implements IEmpleadoDao {

	@PersistenceContext 
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Empleado> findAll() {
		
		return em.createQuery("from Empleado").getResultList();
		
	}

	
	@Override
	public void save(Empleado empleado) {
		
		if (empleado.getId()!= null && empleado.getId()>0) {
			em.merge(empleado);
		}else {
			
			em.persist(empleado);
		}
			
	}

	
	@Override
		public Empleado findOne(Long id) {
	
		return em.find(Empleado.class, id);
	}

	
	@Override
	public void delete(Long id) {
		
		em.remove(findOne(id));
				
	}
	
	
	
}
