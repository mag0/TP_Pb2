package ar.unlam.pb2;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void alumnoCreadoCorrectamente() {
		
		Integer dni = 12345678;
		String nombre = "juan", apellido = "Perez";
		
		Alumno alumno = new Alumno(dni, nombre, apellido, LocalDate.of(2011, 5, 4), LocalDate.of(2014, 5, 4));
		
		assertNotNull(alumno);
		assertEquals(dni, alumno.getDni());
	}
	
	@Test
	public void alumnoCreadoCorrectamente2() {
		
		Integer dni = 12345678;
		String nombre = "juan", apellido = "Perez";
		
		Alumno alumno = new Alumno(dni, nombre, apellido, LocalDate.of(2011, 5, 4), LocalDate.of(2014, 5, 4));
		Alumno alumno2 = new Alumno(dni, nombre, apellido, LocalDate.of(2011, 5, 4), LocalDate.of(2014, 5, 4));
		Alumno alumno3= new Alumno(dni, nombre, apellido, LocalDate.of(2011, 5, 4), LocalDate.of(2014, 5, 4));
		
		assertEquals((Integer)1, alumno.getId());
		assertEquals((Integer)2, alumno2.getId());
		assertEquals((Integer)3, alumno3.getId());
	}

}
