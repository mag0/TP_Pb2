package ar.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNota {

	@Test
	public void notaCreadaCorrectamente() {
		
		Nota nota = new Nota();
		
		nota.setNota(8);
		Integer notaEsperada = 8;
		Integer notaObtenida = nota.getValorNota();
		
		assertEquals(notaEsperada,notaObtenida);
		
	}
	
	@Test
	public void notaNoCreadaPorSerMayorADiez() {
		
		Nota nota = new Nota();
		Boolean resultado = nota.setNota(11);
		
		assertFalse(resultado);
		
	}
	
	@Test
	public void notaCreadaCorrectamenteConTipoDeParcial() {
		Parcial parcial = Parcial.PRIMER_PARCIAL;
		
		Nota nota = new Nota();
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		
		assertEquals(parcial,nota.getParcial());
		
	}

}
