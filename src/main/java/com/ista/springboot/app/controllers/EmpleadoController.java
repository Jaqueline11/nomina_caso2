package com.ista.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import com.ista.springboot.app.models.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ista.springboot.app.models.service.IEmpleadoService;

@Controller
@SessionAttributes("empleado")
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home() {
		return "home";
		
	}
	@RequestMapping(value="/listaremp", method=RequestMethod.GET)
	public String listaremp(Model model) {
		List<Empleado> empleados = empleadoService.findAll();
		model.addAttribute("titulo", "Listado de empleados");
		model.addAttribute("empleado", empleadoService.findAll());
		model.addAttribute("totalSalarios", empleados.stream().mapToDouble(Empleado::getSalario).sum());
		return "listar";

	}


	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		
		Empleado empleado = new Empleado();
		model.put("empleado", empleado);
		model.put("titulo", "Formulario del Empleado");
		return "form";
	}
	
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Empleado empleado = null;
		if (id>0) {
			
			empleado = empleadoService.findOne(id);
		}else {
			
			return "redirect:/empleados/listar";
		}	
		model.put("empleado", empleado);
		model.put("titulo", "Editar del Empleado");
		
		return "form";
	}
	
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Empleado empleado) {
		empleadoService.save(empleado);
		return "redirect:/empleados/listaremp";
	
	}

	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			empleadoService.delete(id);
		}
		return "redirect:/empleados/listaremp";
	}
	
	
}
