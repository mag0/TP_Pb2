package ar.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProfe {

	@Test
	public void profesorCreadoCorrectamente() {
		
		Integer dni = 19283747;
		String nombre = "Carlos", apellido = "Suarez";
		
		Profesor profesor = new Profesor(dni, nombre, apellido);
		
		assertNotNull(profesor);
	}

}
