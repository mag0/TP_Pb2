package ar.unlam.pb2;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

public class TestCurso {

	@Test
	public void cursoCreadoCorrectamente() {
		
		Integer codigoCurso = 1;
		Materia materia = new Materia(1000, "Matematica");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2011, 5, 4);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Aula aula = new Aula(100, 20);	
		Curso curso = new Curso(1,materia, dia, horario, cicloLectivo, aula);
		
		assertNotNull(curso);
		assertEquals(codigoCurso, curso.getComision());
	}

}
