package ar.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void materiaCreadaCorrectamente() {
		Integer codigoMateria = 1000;
		String nombre = "Programacion Basica 1";
		
		Materia materia = new Materia(codigoMateria, nombre);
		
		assertNotNull(materia);
		assertEquals(nombre, materia.getNombre());
	}
	
	@Test
	public void agregadoDeMateriaCorrelativa() {
		Integer codigoMateria = 2000;
		Integer codigoMateriaCorrelativa = 1001;
		Integer codigoMateriaCorrelativa2 = 1002;
		String nombre = "Programacion Basica 1";
		String nombreMateriaCorrelativa = "Programacion Basica 2";
		String nombreMateriaCorrelativa2 = "Matematica";
		
		Materia materia = new Materia(codigoMateria, nombre);
		Materia materiaCorrelativa = new Materia(codigoMateriaCorrelativa, nombreMateriaCorrelativa);
		Materia materiaCorrelativa2 = new Materia(codigoMateriaCorrelativa2, nombreMateriaCorrelativa2);
		
		materia.setMateriaCorrelativa(materiaCorrelativa);
		materia.setMateriaCorrelativa(materiaCorrelativa2);
		Integer cantidadDeMateriasCorrelativas = 2;
		
		assertEquals(cantidadDeMateriasCorrelativas, materia.getCantidadMateriasCorrelativas());
	}
	
	@Test
	public void correlativaNoAgregadaYaQueExiste() {
		Integer codigoMateria = 2000;
		Integer codigoMateriaCorrelativa = 1001;
		String nombre = "Programacion Basica 1";
		String nombreMateriaCorrelativa = "Programacion Basica 2";
		
		Materia materia = new Materia(codigoMateria, nombre);
		Materia materiaCorrelativa = new Materia(codigoMateriaCorrelativa, nombreMateriaCorrelativa);
		
		materia.setMateriaCorrelativa(materiaCorrelativa);
		materia.setMateriaCorrelativa(materiaCorrelativa);
		Integer cantidadDeMateriasCorrelativas = 1;
		
		assertEquals(cantidadDeMateriasCorrelativas, materia.getCantidadMateriasCorrelativas());
	}

}
