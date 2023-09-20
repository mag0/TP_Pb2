package ar.unlam.pb2;

import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCicloLectivo {

	@Test
	public void cicloLectivoCreadoCorrectamente() {
		Integer id = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2011, 5, 4);
		CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		
		assertNotNull(cicloLectivo);
	}

}
