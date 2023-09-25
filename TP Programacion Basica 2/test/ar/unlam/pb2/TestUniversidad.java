package ar.unlam.pb2;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

public class TestUniversidad {

	@Test
	public void universidadCreadaCorrectamente() {
		String nombre = "Universidad De La Matanza";

		Universidad universidad = new Universidad(nombre);

		assertNotNull(universidad);
		assertEquals(nombre, universidad.getNombre());
	}

	@Test
	public void alumnoAgregadoCorrectamente() {
		String nombre = "Universidad De La Matanza";
		Integer dni = 12345678;
		String nombreAlumno = "juan", apellido = "Perez";	
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido, fechaNacimiento, fechaIngreso);
		Universidad uni = new Universidad(nombre);

		assertTrue(uni.agregarAlumno(alumno));
	}

	@Test
	public void dosAlumnosAgregadosCorrectamente() {
		String nombre = "Universidad De La Matanza";
		Integer dni = 12345678;
		String nombreAlumno = "juan", apellido = "Perez";
		Integer dni2 = 123456789;
		String nombreAlumno2 = "juan", apellido2 = "Perez";	
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido, fechaNacimiento, fechaIngreso);
		Alumno alumno2 = new Alumno(dni2, nombreAlumno2, apellido2, fechaNacimiento, fechaIngreso);
		Universidad uni = new Universidad(nombre);
		uni.agregarAlumno(alumno);

		assertTrue(uni.agregarAlumno(alumno2));
	}

	@Test
	public void noSePuedenAgregarDosAlumnosConElMismoDni() {
		String nombre = "Universidad De La Matanza";
		Integer dni = 12345678;
		String nombreAlumno = "juan", apellido = "Perez";
		String nombreAlumno2 = "juan", apellido2 = "Perez";
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido, fechaNacimiento, fechaIngreso);
		Alumno alumno2 = new Alumno(dni, nombreAlumno2, apellido2, fechaNacimiento, fechaIngreso);
		Universidad uni = new Universidad(nombre);
		uni.agregarAlumno(alumno);

		assertFalse(uni.agregarAlumno(alumno2));
	}

	@Test
	public void materiaAgregadaCorrectamente() {
		String nombre = "Universidad De La Matanza";
		Integer codigoMateria = 1000;
		String nombreMateria = "Programacion Basica 1";

		Materia materia = new Materia(codigoMateria, nombreMateria);
		Universidad uni = new Universidad(nombre);

		assertTrue(uni.agregarMateria(materia));
	}

	@Test
	public void dosMateriaAgregadasCorrectamente() {
		String nombre = "Universidad De La Matanza";
		Integer codigoMateria = 1000;
		String nombreMateria = "Programacion Basica 1";
		Integer codigoMateria2 = 1001;
		String nombreMateria2 = "Matematica";

		Materia materia = new Materia(codigoMateria, nombreMateria);
		Materia materia2 = new Materia(codigoMateria2, nombreMateria2);
		Universidad uni = new Universidad(nombre);
		uni.agregarMateria(materia);

		assertTrue(uni.agregarMateria(materia2));
	}

	@Test
	public void noSePuedenAgregarDosMateriasConElMismoId() {
		String nombre = "Universidad De La Matanza";
		Integer id = 1000;
		String nombreMateria = "Programacion Basica 1";
		String nombreMateria2 = "Matematica";

		Materia materia = new Materia(id, nombreMateria);
		Materia materia2 = new Materia(id, nombreMateria2);
		Universidad uni = new Universidad(nombre);
		uni.agregarMateria(materia);

		assertFalse(uni.agregarMateria(materia2));
	}

	@Test
	public void cicloLectivoCreadoCorrectamente() {
		String nombre = "Universidad De La Matanza";	
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2011, 5, 4);

		Universidad uni = new Universidad(nombre);
		assertTrue(uni.crearCicloLectivo(1, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion));
	}

	@Test
	public void dosCiclosLectivosCreadosCorrectamente() {
		String nombre = "Universidad De La Matanza";
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2012, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2012, 5, 4);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2012, 5, 4);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2012, 5, 4);
		
		Universidad uni = new Universidad(nombre);
		uni.crearCicloLectivo(1, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		
		assertTrue(uni.crearCicloLectivo(2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2));
	}

	@Test
	public void noSePuedeAsignar2CiclosLectivosConMismoId() {
		String nombre = "Universidad De La Matanza";	
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2012, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2012, 5, 4);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2012, 5, 4);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2012, 5, 4);
		
		Universidad uni = new Universidad(nombre);
		uni.crearCicloLectivo(1, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		
		assertFalse(uni.crearCicloLectivo(1, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2));
	}

	@Test
	public void noSePuedenSuperponerLosRangosDeFechasEntre2CiclosLectivos() {
		String nombre = "Universidad De La Matanza";
		Integer Id = 1;
		Integer Id2 = 2;		
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2011, 5, 4);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2011, 5, 4);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2012, 5, 4);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2012, 5, 4);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2012, 5, 4);
		
		Universidad uni = new Universidad(nombre);
		uni.crearCicloLectivo(Id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		assertFalse(uni.crearCicloLectivo(Id2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2));
	}

	@Test
	public void cursoCreadoCorrectamente() {
		String nombre = "Universidad De La Matanza";
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		
		Universidad uni = new Universidad(nombre);
		Materia materia = new Materia(1000, "Matematica");
		Aula aula = new Aula(100, 50);
		uni.agregarMateria(materia);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4),
				LocalDate.of(2011, 5, 4));

		assertTrue(uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula));
	}

	@Test
	public void dosCursosCreadosCorrectamente() {
		String nombre = "Universidad De La Matanza";
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Horario horario2 = Horario.TARDE;
		
		Universidad uni = new Universidad(nombre);
		Materia materia = new Materia(1000, "Matematica");
		Materia materia2 = new Materia(1001, "Fisica");	
		Aula aula = new Aula(100, 50);
		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4),
				LocalDate.of(2011, 5, 4));
		uni.crearCicloLectivo(2, LocalDate.of(2012, 5, 4), LocalDate.of(2012, 5, 4), LocalDate.of(2012, 5, 4),
				LocalDate.of(2012, 5, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);

		assertTrue(uni.crearCurso(2, materia2, dia, horario2, uni.buscarCicloLectivoPorId(2), aula));
	}

	@Test
	public void noSePuedenCrearDosCursosConLaMismaMateriaCicloLectivoYTurno() {
		String nombre = "Universidad De La Matanza";
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		
		Universidad uni = new Universidad(nombre);
		Materia materia = new Materia(1000, "Matematica");
		Materia materia2 = new Materia(1001, "Fisica");	
		Aula aula = new Aula(100, 50);
		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4),
				LocalDate.of(2011, 5, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);

		assertFalse(uni.crearCurso(2, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula));
	}

	@Test
	public void profesorAgregadoCorrectamente() {
		String nombre = "Universidad De La Matanza";
		Integer dni = 19283747;
		String nombreProfesor = "Carlos", apellido = "Suarez";
		
		Universidad uni = new Universidad(nombre);
		Profesor profesor = new Profesor(dni, nombreProfesor, apellido);

		uni.registrarProfesor(profesor);
		assertEquals(profesor, uni.buscarProfesorPorDni(dni));
	}

	@Test
	public void dosProfesoresAgregadosCorrectamente() {
		String nombre = "Universidad De La Matanza";
		Integer dni = 19283747;
		String nombreProfesor = "Carlos", apellido = "Suarez";
		Integer dni2 = 192837479;
		String nombreProfesor2 = "Carlos", apellido2 = "Suarez";

		Profesor profesor = new Profesor(dni, nombreProfesor, apellido);
		Profesor profesor2 = new Profesor(dni2, nombreProfesor2, apellido2);
		Universidad uni = new Universidad(nombre);
		uni.registrarProfesor(profesor);

		assertTrue(uni.registrarProfesor(profesor2));
	}

	@Test
	public void noSePuedenAgregarDosProfesoresConElMismoDni() {
		String nombre = "Universidad De La Matanza";
		Integer dni = 19283747;
		String nombreProfesor = "Carlos", apellido = "Suarez";
		String nombreProfesor2 = "Carlos", apellido2 = "Suarez";

		Profesor profesor = new Profesor(dni, nombreProfesor, apellido);
		Profesor profesor2 = new Profesor(dni, nombreProfesor2, apellido2);
		Universidad uni = new Universidad(nombre);
		uni.registrarProfesor(profesor);

		assertFalse(uni.registrarProfesor(profesor2));
	}

	@Test
	public void asignarMateriaCorrelativa() {
		Universidad uni = new Universidad("unlam");
		Materia materia = new Materia(1000, "Programacion basica 1");
		Materia materia2 = new Materia(1001, "Programacion basica 2");

		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);

		assertTrue(uni.asignarMateriaCorrelativa(1001, 1000));
		assertEquals((Integer)1, uni.buscarMateriaPorId(1001).getCantidadMateriasCorrelativas());
	}

	@Test
	public void eliminarMateriaCorrelativa() {
		Universidad uni = new Universidad("unlam");
		Materia materia = new Materia(1000, "Programacion basica 1");
		Materia materia2 = new Materia(1001, "Programacion basica 2");

		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.asignarMateriaCorrelativa(1001, 1000);

		assertTrue(uni.eliminarMateriaCorrelativa(1001, 1000));
		assertEquals((Integer)0, uni.buscarMateriaPorId(1001).getCantidadMateriasCorrelativas());
	}
	
	@Test
	public void alumnoAnotadoEnDosCursosCorrectamente() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Materia materia = new Materia(1000, "Matematica");
		Materia materia2 = new Materia(1001, "Fisica");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCicloLectivo(2, LocalDate.of(2012, 5, 4), LocalDate.of(2012, 5, 4), LocalDate.of(2012, 4, 4),
				LocalDate.of(2012, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(2, materia2, dia, horario, uni.buscarCicloLectivoPorId(2), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));

		assertTrue(uni.inscribirAlumnoACurso(2, 12, LocalDate.of(2012, 5, 4)));
	}
	
	@Test
	public void dosAlumnosAnotadosEnUnCursoCorrectamente() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Alumno alumno2 = new Alumno(123, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Materia materia = new Materia(1000, "Matematica");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.agregarAlumno(alumno2);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, fechaIngreso);

		assertTrue(uni.inscribirAlumnoACurso(1, 123, fechaIngreso));
		assertEquals((Integer)2, uni.buscarCursoPorId(1).getAlumnosEnCurso());
	}

	@Test
	public void alumnoAnotadoEnCursoCorrectamente() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Materia materia = new Materia(1000, "Matematica");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);

		assertTrue(uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 3)));
		assertEquals(uni.buscarCursoPorId(1), uni.buscarAsignacionCursoAlumnoPorComision(1, 12).getCurso());
	}
	
	@Test
	public void alumnoNoAnotadoEnCursoPorPasarseFechaDeInscripcion() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Materia materia = new Materia(1000, "Matematica");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4),
				LocalDate.of(2011, 5, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);

		assertFalse(uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 5)));
	}

	

	@Test
	public void cargaDeNotaCorrectamente() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Nota nota = new Nota();
		nota.setNota(4);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		
		assertTrue(uni.cargarNotaAlumno(1, 12, nota));
		assertTrue(uni.cargarNotaAlumno(1, 12, nota2));
	}
	
	@Test
	public void obtenerNotaFinal() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Nota nota = new Nota();
		nota.setNota(4);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		
		//La nota final la redondean para abajo
		assertEquals((Integer) 5, uni.obtenerNotaFinal(1, 12));
	}
	
	@Test
	public void soloSePuedeRecuperarUnParcial() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Nota nota = new Nota();
		nota.setNota(3);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		Nota nota3 = new Nota();
		nota3.setNota(5);
		nota3.setParcial(Parcial.RECUPERATORIO_PRIMER_PARCIAL);
		Nota nota4 = new Nota();
		nota4.setNota(5);
		nota4.setParcial(Parcial.RECUPERATORIO_SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		uni.cargarNotaAlumno(1, 12, nota3);
		
		assertFalse(uni.cargarNotaAlumno(1, 12, nota4));
		
	}
	
	@Test
	public void noSePuedeCargarNotaPorqueYaHayUnaCargada() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Nota nota = new Nota();
		nota.setNota(4);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		
		assertFalse(uni.cargarNotaAlumno(1, 12, nota));
	}

	@Test
	public void elAlumnoTieneUnaMateriaAprobada() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Nota nota = new Nota();
		nota.setNota(4);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);

		assertEquals(1, uni.obtenerListadoMateriasAprobadasPorUnAlumno(12).size());
	}

	@Test
	public void alumnoAnotadoEnCursoPorTenerCorrelativasAprobadas() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Dia dia2 = Dia.MARTES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Materia materia2 = new Materia(1001, "Matematica");
		Materia materia3 = new Materia(1002, "Programacion basica 2");
		Nota nota = new Nota();
		nota.setNota(4);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.agregarMateria(materia3);
		uni.asignarMateriaCorrelativa(1002, 1000);
		uni.asignarMateriaCorrelativa(1002, 1001);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCicloLectivo(2, LocalDate.of(2012, 5, 4), LocalDate.of(2012, 5, 4), LocalDate.of(2012, 4, 4),
				LocalDate.of(2012, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(2, materia2, dia2, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(3, materia3, dia, horario, uni.buscarCicloLectivoPorId(2), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.inscribirAlumnoACurso(2, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		uni.cargarNotaAlumno(2, 12, nota);
		uni.cargarNotaAlumno(2, 12, nota2);

		assertTrue(uni.inscribirAlumnoACurso(3, 12, LocalDate.of(2012, 5, 4)));
	}

	@Test
	public void alumnoNoAnotadoEnCursoPorNoTenerCorrelativasAprobadas() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Materia materia2 = new Materia(1001, "Matematica");
		Materia materia3 = new Materia(1002, "Programacion basica 2");
		Nota nota = new Nota();
		nota.setNota(2);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(2);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.agregarMateria(materia3);
		uni.asignarMateriaCorrelativa(1002, 1000);
		uni.asignarMateriaCorrelativa(1002, 1001);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4),
				LocalDate.of(2011, 5, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(2, materia2, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(3, materia3, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.inscribirAlumnoACurso(2, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		uni.cargarNotaAlumno(2, 12, nota);
		uni.cargarNotaAlumno(2, 12, nota2);

		assertFalse(uni.inscribirAlumnoACurso(3, 12, LocalDate.of(2011, 5, 4)));
	}

	@Test
	public void noEsPosibleAsignarCursoAlAlumnoPorqueEstaLlenaElAula() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Alumno alumno2 = new Alumno(123, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Alumno alumno3 = new Alumno(1234, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Alumno alumno4 = new Alumno(12345, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 3);
		Materia materia = new Materia(1000, "Programacion basica 1");
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.agregarAlumno(alumno2);
		uni.agregarAlumno(alumno3);
		uni.agregarAlumno(alumno4);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4),
				LocalDate.of(2011, 5, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.inscribirAlumnoACurso(1, 123, LocalDate.of(2011, 5, 4));
		uni.inscribirAlumnoACurso(1, 1234, LocalDate.of(2011, 5, 4));

		assertFalse(uni.inscribirAlumnoACurso(1, 12345, LocalDate.of(2011, 5, 4)));
	}
	
	@Test
	public void noEsPosibleAsignarCursoAlAlumnoPorqueYaAproboEsaMateria() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 3);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Nota nota = new Nota();
		nota.setNota(7);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCicloLectivo(2, LocalDate.of(2012, 5, 4), LocalDate.of(2012, 5, 4), LocalDate.of(2012, 4, 4),
				LocalDate.of(2012, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(2, materia, dia, horario, uni.buscarCicloLectivoPorId(2), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);

		assertFalse(uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4)));
	}

	@Test
	public void noSePuedeInscribirElAlumnoSiYaEstáInscriptoAOtroCursoParaElMismoDíaYTurno() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Materia materia2 = new Materia(1001, "Programacion basica 2");
		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.asignarMateriaCorrelativa(1001, 1000);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(2, materia2, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));

		assertFalse(uni.inscribirAlumnoACurso(2, 12, LocalDate.of(2011, 5, 4)));
	}

	@Test
	public void profesorAnotadoEnMateriaCorrectamente() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Profesor profesor = new Profesor(12, "juan", "Perez");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 3);
		Materia materia = new Materia(1000, "Programacion basica 1");
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.registrarProfesor(profesor);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));

		assertTrue(uni.asignarCursoAlProfesor(1, 12));
		assertEquals(profesor, uni.buscarAsignacionCursoProfe(1, 12).getProfesor());
	}

	@Test
	public void dosProfesoresAnotadosCorrectamenteEnUnaCursadaPorHaberMasDe20Alumnos() {
		Universidad uni = new Universidad("unlam");
		Profesor profesor = new Profesor(12, "juan", "Perez");
		Profesor profesor2 = new Profesor(123, "juan", "Perez");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 40);
		Materia materia = new Materia(1000, "Programacion basica 1");
		uni.agregarMateria(materia);
		uni.registrarProfesor(profesor);
		uni.registrarProfesor(profesor2);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		for (int i = 0; i < 21; i++) {
			LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
			LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
			Alumno alumno = new Alumno(i, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
			uni.agregarAlumno(alumno);
			uni.inscribirAlumnoACurso(1, i, LocalDate.of(2011, 5, 4));
		}
		uni.asignarCursoAlProfesor(1, 123);

		assertTrue(uni.asignarCursoAlProfesor(1, 12));
		assertEquals((Integer) 2, uni.buscarAsignacionCursoProfe(1, 123).getCurso().getProfesoresEnCurso());
	}

	@Test
	public void noPermitirDosProfesoresAnotadosEnUnaCursadaConMenosDe21alumnos() {
		Universidad uni = new Universidad("unlam");
		Profesor profesor = new Profesor(12, "juan", "Perez");
		Profesor profesor2 = new Profesor(123, "juan", "Perez");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 40);
		Materia materia = new Materia(1000, "Programacion basica 1");
		uni.agregarMateria(materia);
		uni.registrarProfesor(profesor);
		uni.registrarProfesor(profesor2);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		uni.agregarAlumno(alumno);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.asignarCursoAlProfesor(1, 123);

		assertFalse(uni.asignarCursoAlProfesor(1, 12));
		assertEquals((Integer) 1, uni.buscarAsignacionCursoProfe(1, 123).getCurso().getProfesoresEnCurso());
	}
	
	@Test
	public void profesorNoSePuedeAnotarEnLaMismaComisionDosVeces() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Profesor profesor = new Profesor(12, "juan", "Perez");
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 3);
		Materia materia = new Materia(1000, "Programacion basica 1");
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.registrarProfesor(profesor);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.asignarCursoAlProfesor(1, 12);
		
		assertFalse(uni.asignarCursoAlProfesor(1, 12));
	}

	@Test
	public void elAlumnoTieneUnaMateriaAprobadaGraciasAQueAproboElRecuperatorioDelPrimerParcial() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Nota nota = new Nota();
		nota.setNota(3);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		Nota nota3 = new Nota();
		nota3.setNota(7);
		nota3.setParcial(Parcial.RECUPERATORIO_PRIMER_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		uni.cargarNotaAlumno(1, 12, nota3);

		assertEquals(1, uni.obtenerListadoMateriasAprobadasPorUnAlumno(12).size());
	}

	@Test
	public void obtenerListadoMateriasAprobadasPorUnAlumno() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Horario horario2 = Horario.TARDE;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Materia materia2 = new Materia(1001, "Matematica");
		Nota nota = new Nota();
		nota.setNota(4);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(2, materia2, dia, horario2, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.inscribirAlumnoACurso(2, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		uni.cargarNotaAlumno(2, 12, nota);
		uni.cargarNotaAlumno(2, 12, nota2);

		assertEquals(2, uni.obtenerListadoMateriasAprobadasPorUnAlumno(12).size());
		assertEquals(uni.buscarMateriaPorId(1000), uni.obtenerListadoMateriasAprobadasPorUnAlumno(12).get(0).getCurso().getMateria());
		assertEquals(uni.buscarMateriaPorId(1001), uni.obtenerListadoMateriasAprobadasPorUnAlumno(12).get(1).getCurso().getMateria());
	}

	@Test
	public void obtenerMateriasQueFaltanCursarPorUnAlumno() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Horario horario2 = Horario.TARDE;
		Aula aula = new Aula(100, 50);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Materia materia2 = new Materia(1001, "Matematica");
		Materia materia3 = new Materia(1002, "Fisica");
		Materia materia4 = new Materia(1003, "Biologia");
		Nota nota = new Nota();
		nota.setNota(4);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarMateria(materia2);
		uni.agregarMateria(materia3);
		uni.agregarMateria(materia4);
		uni.agregarAlumno(alumno);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.crearCurso(2, materia2, dia, horario2, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.inscribirAlumnoACurso(2, 12, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		uni.cargarNotaAlumno(2, 12, nota);
		uni.cargarNotaAlumno(2, 12, nota2);

		assertEquals(2, uni.obtenerMateriasQueFaltanCursarParaUnAlumno(12).size());
		assertEquals(materia3, uni.obtenerMateriasQueFaltanCursarParaUnAlumno(12).get(0));
		assertEquals(materia4, uni.obtenerMateriasQueFaltanCursarParaUnAlumno(12).get(1));
	}

	@Test
	public void obtenerReporteDeNotasDeAlumnosEnCurso() {
		Universidad uni = new Universidad("unlam");
		LocalDate fechaNacimiento = LocalDate.of(1999, 5, 4);
		LocalDate fechaIngreso = LocalDate.of(2011, 5, 4);
		Alumno alumno = new Alumno(12, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Alumno alumno2 = new Alumno(123, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Alumno alumno3 = new Alumno(1234, "Jose", "Gonzales", fechaNacimiento, fechaIngreso);
		Dia dia = Dia.LUNES;
		Horario horario = Horario.MANIANA;
		Aula aula = new Aula(100, 3);
		Materia materia = new Materia(1000, "Programacion basica 1");
		Nota nota = new Nota();
		nota.setNota(4);
		nota.setParcial(Parcial.PRIMER_PARCIAL);
		Nota nota2 = new Nota();
		nota2.setNota(7);
		nota2.setParcial(Parcial.SEGUNDO_PARCIAL);
		uni.agregarMateria(materia);
		uni.agregarAlumno(alumno);
		uni.agregarAlumno(alumno2);
		uni.agregarAlumno(alumno3);
		uni.crearCicloLectivo(1, LocalDate.of(2011, 5, 4), LocalDate.of(2011, 5, 4), LocalDate.of(2011, 4, 4),
				LocalDate.of(2011, 6, 4));
		uni.crearCurso(1, materia, dia, horario, uni.buscarCicloLectivoPorId(1), aula);
		uni.inscribirAlumnoACurso(1, 12, LocalDate.of(2011, 5, 4));
		uni.inscribirAlumnoACurso(1, 123, LocalDate.of(2011, 5, 4));
		uni.inscribirAlumnoACurso(1, 1234, LocalDate.of(2011, 5, 4));
		uni.cargarNotaAlumno(1, 12, nota);
		uni.cargarNotaAlumno(1, 12, nota2);
		uni.cargarNotaAlumno(1, 123, nota);
		uni.cargarNotaAlumno(1, 123, nota2);
		uni.cargarNotaAlumno(1, 1234, nota);
		uni.cargarNotaAlumno(1, 1234, nota2);

		assertEquals(3, uni.obtenerReporteDeNotasDeAumnosDeCurso(1).size());
		assertEquals(nota, uni.obtenerReporteDeNotasDeAumnosDeCurso(1).get(0).getNotaPrimerParcial());
	}

}
