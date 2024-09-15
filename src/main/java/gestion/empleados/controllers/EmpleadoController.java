package gestion.empleados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.empleados.excepciones.ResourceNotFoundException;
import gestion.empleados.modelo.Empleado;
import gestion.empleados.repos.EmpleadoRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	// Trae una lista de todos los empleados
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return empleadoRepository.findAll();
	}
	
	// Registra un nuevo empleado
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	// Obtiene un empleado por id
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadosPorID(@PathVariable Long id) {
		Empleado empleado = empleadoRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
		return ResponseEntity.ok(empleado);
	}
	
	// Actualiza un empleado por id
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadosPorID(@PathVariable Long id, @RequestBody Empleado detallesEmpleado) {
		Empleado empleado = empleadoRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
		empleado.setNombre(detallesEmpleado.getNombre());
		empleado.setApellido(detallesEmpleado.getApellido());
		empleado.setEmail(detallesEmpleado.getEmail());
		Empleado empleadoAct = empleadoRepository.save(empleado);
		return ResponseEntity.ok(empleadoAct);
	}
	
	// Elimina un empleado por id
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        empleadoRepository.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
