package ar.unlam.pb2;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAsignacionCursoProfe {

	@Test
	public void cursoAsignadoCorrectamente() {
		Materia materia = new Materia(1000, "Matematica");
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2011, 5, 4);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Aula aula = new Aula(100, 50);
		Curso curso = new Curso(1, materia, Dia.LUNES, Horario.MANIANA, cicloLectivo, aula);
		Profesor profesor = new Profesor(1234, "Pepe", "Ginobili");
		
		AsignacionCursoProfe asignacionCursoProfe = new AsignacionCursoProfe(curso, profesor);
		
		assertNotNull(asignacionCursoProfe);
	}

}
