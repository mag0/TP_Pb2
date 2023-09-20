package ar.unlam.pb2;

import java.time.LocalDate;

public class Alumno extends Persona{
	
	private static Integer generadorId = 1;
	private Integer id;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;

	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		super(dni, nombre, apellido);
		this.id = generadorId++;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}
	
	public Integer getId() {
		return id;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
