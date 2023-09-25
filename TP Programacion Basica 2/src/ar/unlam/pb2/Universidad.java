package ar.unlam.pb2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Profesor> profesores;
	private ArrayList<Curso> cursos;
	private ArrayList<AsignacionCursoProfe> asignacionesCursoProfesor;
	private ArrayList<AsignacionCursoAlumno> asignacionesCursoAlumno;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.asignacionesCursoProfesor = new ArrayList<>();
		this.asignacionesCursoAlumno = new ArrayList<>();
	}

	public Boolean agregarMateria(Materia materia) {
		if (this.materias.contains(materia))
			return false;
		return this.materias.add(materia);
	}

	public Materia buscarMateriaPorId(Integer id) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigoMateria().equals(id)) {
				return this.materias.get(i);
			}
		}
		return null;
	}

	public Boolean agregarAlumno(Alumno alumno) {
		if (this.alumnos.contains(alumno))
			return false;
		return this.alumnos.add(alumno);
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {
		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				return this.alumnos.get(i);
			}
		}
		return null;
	}

	public Boolean crearCicloLectivo(Integer id, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioInscripcion,
			LocalDate fechaFinalizacionInscripcion) {
		Boolean cicloLectivoCreado = false;
		if (cicloLectivoCumpleCondicionesParaCrearse(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion)) {
			CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
					fechaInicioInscripcion, fechaFinalizacionInscripcion);
			this.ciclosLectivos.add(cicloLectivo);
			cicloLectivoCreado = true;
		}

		return cicloLectivoCreado;
	}

	public Boolean cicloLectivoCumpleCondicionesParaCrearse(Integer id, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioInscripcion,
			LocalDate fechaFinalizacionInscripcion) {
		Boolean cicloLectivoCumpleCondicionesParaCrearse = true;
		for (int i = 0; i < this.ciclosLectivos.size(); i++) {
			if (this.ciclosLectivos.get(i).getId().equals(id)
					|| this.ciclosLectivos.get(i).getFechaInicioCicloLectivo().equals(fechaInicioCicloLectivo)
					|| this.ciclosLectivos.get(i).getFechaFinalizacionCicloLectivo()
							.equals(fechaFinalizacionCicloLectivo)
					|| this.ciclosLectivos.get(i).getFechaInicioInscripcion().equals(fechaInicioInscripcion)
					|| this.ciclosLectivos.get(i).getFechaFinalizacionInscripcion()
							.equals(fechaFinalizacionInscripcion)) {
				cicloLectivoCumpleCondicionesParaCrearse = false;
			}
		}
		return cicloLectivoCumpleCondicionesParaCrearse;
	}

	public CicloLectivo buscarCicloLectivoPorId(Integer id) {
		for (int i = 0; i < this.ciclosLectivos.size(); i++) {
			if (this.ciclosLectivos.get(i).getId().equals(id)) {
				return this.ciclosLectivos.get(i);
			}
		}
		return null;
	}

	public Boolean crearCurso(Integer comision, Materia materia, Dia dia, Horario horario, CicloLectivo cicloLectivo,
			Aula aula) {
		Curso curso = new Curso(comision, materia, dia, horario, cicloLectivo, aula);
		if (cursoCumpleCondicionesParaCrearse(comision, materia, dia, horario, cicloLectivo, aula))
			return cursos.add(curso);
		return false;
	}

	public Boolean cursoCumpleCondicionesParaCrearse(Integer comision, Materia materia, Dia dia, Horario horario,
			CicloLectivo cicloLectivo, Aula aula) {
		Boolean cursoCumpleCondicionesParaCrearse = true;
		for (int i = 0; i < this.cursos.size(); i++) {
			if (this.cursos.get(i).getComision().equals(comision)
					|| (this.cursos.get(i).getMateria().getCodigoMateria().equals(materia.getCodigoMateria())
							&& this.cursos.get(i).getCicloLectivo().getId().equals(cicloLectivo.getId())
							&& this.cursos.get(i).getHorario().equals(horario))) {
				cursoCumpleCondicionesParaCrearse = false;
			}
		}
		return cursoCumpleCondicionesParaCrearse;
	}

	public Curso buscarCursoPorId(Integer comision) {
		for (int i = 0; i < this.cursos.size(); i++) {
			if (this.cursos.get(i).getComision().equals(comision)) {
				return this.cursos.get(i);
			}
		}
		return null;
	}

	public Boolean registrarProfesor(Profesor profesor) {
		if (this.profesores.contains(profesor))
			return false;
		return this.profesores.add(profesor);
	}

	public Profesor buscarProfesorPorDni(Integer dni) {
		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				return this.profesores.get(i);
			}
		}
		return null;
	}

	public Boolean asignarMateriaCorrelativa(Integer idMateria, Integer idMateriaCorrelativa) {
		Boolean materiaCorrelativaAsignada = false;
		Materia materia = buscarMateriaPorId(idMateria);
		Materia materiaCorrelativa = buscarMateriaPorId(idMateriaCorrelativa);
		if (materia != null && materiaCorrelativa != null) {
			materia.setMateriaCorrelativa(materiaCorrelativa);
			materiaCorrelativaAsignada = true;
		}
		return materiaCorrelativaAsignada;
	}

	public Boolean eliminarMateriaCorrelativa(Integer idMateria, Integer idMateriaCorrelativaAEliminar) {
		Boolean materiaCorrelativaEliminada = false;
		Materia materia = buscarMateriaPorId(idMateria);
		Materia materiaCorrelativa = buscarMateriaPorId(idMateriaCorrelativaAEliminar);
		if (materia != null && materiaCorrelativa != null) {
			materia.eliminarMateriaCorrelativa(idMateriaCorrelativaAEliminar);
			materiaCorrelativaEliminada = true;
		}
		return materiaCorrelativaEliminada;
	}

	public Boolean inscribirAlumnoACurso(Integer comision, Integer dni, LocalDate fechaActual) {
		Boolean alumnosInscripto = false;
		Curso curso = buscarCursoPorId(comision);
		Alumno alumno = buscarAlumnoPorDni(dni);
		if (curso != null && alumno != null && curso.getCicloLectivo().getFechaInicioInscripcion().isBefore(fechaActual)
				&& curso.getCicloLectivo().getFechaFinalizacionInscripcion().isAfter(fechaActual)
				&& materiasCorrelativasAprobadas(dni, curso.getMateria().getCodigoMateria())
				&& (curso.getAlumnosEnCurso() < curso.getAula().getCAPACIDAD_MAXIMA()
						&& !alumnoConAsignacionEnMismoHorarioYTurno(comision, dni))) {
			AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(buscarCursoPorId(comision), alumno);
			if (!this.asignacionesCursoAlumno.contains(asignacionCursoAlumno) && !materiaAprobadaOPromocionada(curso.getMateria().getCodigoMateria(), dni)) {
				curso.setAlumnosEnCurso(1);
				alumnosInscripto =  asignacionesCursoAlumno.add(asignacionCursoAlumno);
			}
		}
		return alumnosInscripto;
	}

	public Boolean materiasCorrelativasAprobadas(Integer dni, Integer codigoMateria) {
		Boolean materiasCorrelativasAprobadas = false;
		Integer cantidadMateriasCorrelativasAprobadas = 0;
		for (int k = 0; k < buscarMateriaPorId(codigoMateria).getMateriasCorrelativas().size(); k++) {
			Materia materia = buscarMateriaPorId(codigoMateria).getMateriasCorrelativas().get(k);
			AsignacionCursoAlumno cursada = buscarAsignacionCursoAlumnoPorCodigoMateria(materia.getCodigoMateria(),
					dni);
			if (cursada != null && cursadaAprobadaOPromocionada(cursada.getCurso().getComision(), dni)) {
				cantidadMateriasCorrelativasAprobadas++;
			}
		}
		if (cantidadMateriasCorrelativasAprobadas
				.equals(buscarMateriaPorId(codigoMateria).getMateriasCorrelativas().size())) {
			materiasCorrelativasAprobadas = true;
		}
		return materiasCorrelativasAprobadas;
	}

	public Boolean cursadaAprobadaOPromocionada(Integer comision, Integer dni) {
		Boolean cursadaAprobada = false;
		AsignacionCursoAlumno cursada = buscarAsignacionCursoAlumnoPorComision(comision, dni);
		if (cursada != null && (cursada.getAprobado() || cursada.getPromocionado())) {
			cursadaAprobada = true;
		}
		return cursadaAprobada;
	}
	
	public Boolean materiaAprobadaOPromocionada(Integer codigoMateria, Integer dni) {
		Boolean cursadaAprobada = false;
		AsignacionCursoAlumno cursada = buscarAsignacionCursoAlumnoPorCodigoMateria(codigoMateria, dni);
		if (cursada != null && (cursada.getAprobado() || cursada.getPromocionado())) {
			cursadaAprobada = true;
		}
		return cursadaAprobada;
	}

	public Boolean alumnoConAsignacionEnMismoHorarioYTurno(Integer comision, Integer dni) {
		Boolean alumnoConAsignacionEnMismoHorarioYTurno = false;
		Curso curso = buscarCursoPorId(comision);
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getAlumno().getDni().equals(dni)
					&& this.asignacionesCursoAlumno.get(i).getCurso().getDia().equals(curso.getDia())
					&& this.asignacionesCursoAlumno.get(i).getCurso().getCicloLectivo().getFechaInicioCicloLectivo()
							.equals(curso.getCicloLectivo().getFechaInicioCicloLectivo())
					&& this.asignacionesCursoAlumno.get(i).getCurso().getHorario().equals(curso.getHorario())) {
				alumnoConAsignacionEnMismoHorarioYTurno = true;
				return alumnoConAsignacionEnMismoHorarioYTurno;
			}
		}
		return alumnoConAsignacionEnMismoHorarioYTurno;
	}

	public Boolean asignarCursoAlProfesor(Integer comision, Integer dni) {
		Curso curso = buscarCursoPorId(comision);
		Profesor profesor = buscarProfesorPorDni(dni);
		if (curso != null && profesor != null && buscarAsignacionCursoProfe(comision, dni) == null
				&& (buscarAsignacionCursoAlumnoPorComision(comision, dni).getCurso().getProfesoresEnCurso() < curso
						.getProfesoresNecesarios(curso.getAlumnosEnCurso()))) {
			if (this.profesores.contains(profesor)) {
				AsignacionCursoProfe asignacionCursoProfe = new AsignacionCursoProfe(curso, profesor);
				if (!asignacionesCursoProfesor.contains(asignacionCursoProfe)) {
					curso.setProfesoresEnCurso(1);
					return asignacionesCursoProfesor.add(asignacionCursoProfe);
				}
			}
		}
		return false;
	}

	public AsignacionCursoProfe buscarAsignacionCursoProfe(Integer comision, Integer dni) {
		for (int i = 0; i < this.asignacionesCursoProfesor.size(); i++) {
			if (this.asignacionesCursoProfesor.get(i).getCurso().getComision().equals(comision)
					&& this.asignacionesCursoProfesor.get(i).getProfesor().getDni().equals(dni)) {
				return this.asignacionesCursoProfesor.get(i);
			}
		}
		return null;
	}

	public AsignacionCursoAlumno buscarAsignacionCursoAlumnoPorComision(Integer comision, Integer dni) {
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getCurso().getComision().equals(comision)) {
				return this.asignacionesCursoAlumno.get(i);
			}
		}
		return null;
	}

	public AsignacionCursoAlumno buscarAsignacionCursoAlumnoPorCodigoMateria(Integer codigoMateria, Integer dni) {
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getCurso().getMateria().getCodigoMateria().equals(codigoMateria)) {
				return this.asignacionesCursoAlumno.get(i);
			}
		}
		return null;
	}

	public Boolean cargarNotaAlumno(Integer comision, Integer dni, Nota nota) {
		Boolean notaCargada = true;
		AsignacionCursoAlumno cursada = buscarAsignacionCursoAlumnoPorComision(comision, dni);
		if (cursada != null) {
			notaCargada = cursada.setNota(nota);
		}
		return notaCargada;
	}

	public Integer obtenerNotaFinal(Integer comision, Integer dni) {
		Integer notaFinal = null;
		if (buscarAsignacionCursoAlumnoPorComision(comision, dni) != null) {
			notaFinal = buscarAsignacionCursoAlumnoPorComision(comision, dni).getNotaFinal();
		}
		return notaFinal;
	}

	public ArrayList<AsignacionCursoAlumno> obtenerListadoMateriasAprobadasPorUnAlumno(Integer idAlumno) {
		ArrayList<AsignacionCursoAlumno> listadoMateriasAprobadasPorAlumno = new ArrayList<>();
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getAlumno().getDni().equals(idAlumno)
					&& (this.asignacionesCursoAlumno.get(i).getPromocionado()
							|| this.asignacionesCursoAlumno.get(i).getAprobado())) {
				listadoMateriasAprobadasPorAlumno.add(this.asignacionesCursoAlumno.get(i));
			}
		}
		return listadoMateriasAprobadasPorAlumno;
	}

	public ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer dni) {
		ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno = this.materias;
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getAlumno().getDni().equals(dni)
					&& (this.asignacionesCursoAlumno.get(i).getPromocionado()
							|| this.asignacionesCursoAlumno.get(i).getAprobado())) {
				obtenerMateriasQueFaltanCursarParaUnAlumno
						.remove(this.asignacionesCursoAlumno.get(i).getCurso().getMateria());
			}
		}

		return obtenerMateriasQueFaltanCursarParaUnAlumno;
	}

	public ArrayList<AsignacionCursoAlumno> obtenerReporteDeNotasDeAumnosDeCurso(Integer comision) {
		ArrayList<AsignacionCursoAlumno> obtenerReporteDeNotasDeAumnosDeCurso = new ArrayList<>();
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getCurso().getComision().equals(comision)) {
				obtenerReporteDeNotasDeAumnosDeCurso.add(this.asignacionesCursoAlumno.get(i));
			}
		}
		return obtenerReporteDeNotasDeAumnosDeCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public Integer getCantidadDeAlumnos() {
		return this.alumnos.size();
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public Integer getCantidadDeProfesores() {
		return this.profesores.size();
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public Integer getCantidadDeMaterias() {
		return this.materias.size();
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public Integer getCantidadDeCursos() {
		return this.cursos.size();
	}

	public ArrayList<AsignacionCursoProfe> getAsignacionesCursoProfesor() {
		return asignacionesCursoProfesor;
	}

	public Integer getCantidadAsignacionesCursoProfesor() {
		return this.asignacionesCursoProfesor.size();
	}

	public ArrayList<AsignacionCursoAlumno> getAsignacionesCursoAlumno() {
		return asignacionesCursoAlumno;
	}

	public Integer getCantidadAsignacionesCursoAlumno() {
		return this.asignacionesCursoAlumno.size();
	}

}
