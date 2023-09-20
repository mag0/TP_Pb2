package ar.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAula {

	@Test
	public void aulaCreadaCorrectamente() {
		Integer numeroAula = 100;
		
		Aula aula = new Aula(numeroAula, 20);
		
		assertNotNull(aula);
	}

}
