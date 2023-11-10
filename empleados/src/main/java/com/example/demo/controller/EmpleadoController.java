package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleado;
import com.example.demo.enums.Trabajo;
import com.example.demo.services.EmpleadoServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServideImpl;
	
	@GetMapping("/all")
	public List<Empleado> listarEmpleados(){
		return empleadoServideImpl.listarEmpleados();
	}
	
	
	@PostMapping("/add")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {
		Trabajo trabajo = validarTrabajo(empleado.getTrabajo());
		if(trabajo != null) {
			empleado.setSalario(trabajo.getSalario());
			return empleadoServideImpl.guardarEmpleado(empleado);
		}else {
			return null; 
		}
	}
	
	
	@GetMapping("/{id}")
	public Empleado empleadoXID(@PathVariable(name="id") Integer id) {
		
		Empleado empleadoXId= new Empleado();
		
		empleadoXId=empleadoServideImpl.empleadoXID(id);
				
		return empleadoXId;
	}
	
	@PutMapping("/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Integer id,@RequestBody Empleado empleado) {
		
		Empleado empleadoSeleccionado= new Empleado();
		Empleado empleadoActualizado= new Empleado();
		
		empleadoSeleccionado= empleadoServideImpl.empleadoXID(id);
		
		empleadoSeleccionado.setNombre(empleado.getNombre());
		Trabajo trabajo = validarTrabajo(empleado.getTrabajo());
		empleadoSeleccionado.setTrabajo(trabajo.getTrabajo());
		empleadoSeleccionado.setSalario(trabajo.getSalario());
		
		empleadoActualizado = empleadoServideImpl.actualizarEmpleado(empleadoSeleccionado);
		
		
		return empleadoActualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarEmpleado(@PathVariable(name="id")Integer id) {
		empleadoServideImpl.eliminarEmpleado(id);
	}
	
	public Trabajo validarTrabajo(String trabajo) {
		Trabajo[] trabajos = Trabajo.values();
		for (int i = 0; i < Trabajo.values().length; i++) {
			if(trabajo.equals(trabajos[i].getTrabajo())) {
				return trabajos[i];
			}
		}
		return null;
	}
	
}