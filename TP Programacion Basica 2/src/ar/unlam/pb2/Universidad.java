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
		if (buscarMateriaPorId(materia.getCodigoMateria()) == null)
			return materias.add(materia);
		return false;
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
		if (buscarAlumnoPorDni(alumno.getDni()) == null)
			return alumnos.add(alumno);
		return false;
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
					|| this.ciclosLectivos.get(i).getFechaInicioCicloLectivo().compareTo(fechaInicioCicloLectivo) == 0
					|| this.ciclosLectivos.get(i).getFechaFinalizacionCicloLectivo()
							.compareTo(fechaFinalizacionCicloLectivo) == 0
					|| this.ciclosLectivos.get(i).getFechaInicioInscripcion().compareTo(fechaInicioInscripcion) == 0
					|| this.ciclosLectivos.get(i).getFechaFinalizacionInscripcion()
							.compareTo(fechaFinalizacionInscripcion) == 0) {
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
		if (buscarProfesorPorDni(profesor.getDni()) == null)
			return profesores.add(profesor);
		return false;
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
		if (buscarMateriaPorId(idMateria) != null && buscarMateriaPorId(idMateriaCorrelativa) != null) {
			buscarMateriaPorId(idMateria).setMateriaCorrelativa(buscarMateriaPorId(idMateriaCorrelativa));
			materiaCorrelativaAsignada = true;
		}
		return materiaCorrelativaAsignada;
	}

	public Boolean eliminarMateriaCorrelativa(Integer idMateria, Integer idMateriaCorrelativaAEliminar) {
		Boolean materiaCorrelativaEliminada = false;
		if (buscarMateriaPorId(idMateria) != null && buscarMateriaPorId(idMateriaCorrelativaAEliminar) != null) {
			buscarMateriaPorId(idMateria).eliminarMateriaCorrelativa(idMateriaCorrelativaAEliminar);
			materiaCorrelativaEliminada = true;
		}
		return materiaCorrelativaEliminada;
	}

	public Materia buscarMateriaCorrelativaPorId(Integer idMateria, Integer idMateriaCorrelativaAEliminar) {
		if (buscarMateriaPorId(idMateria) != null && buscarMateriaPorId(idMateriaCorrelativaAEliminar) != null
				&& buscarMateriaPorId(idMateria).buscarMateriaCorrelativa(idMateriaCorrelativaAEliminar) != null) {
			return buscarMateriaPorId(idMateria).buscarMateriaCorrelativa(idMateriaCorrelativaAEliminar);
		}
		return null;
	}

	public Boolean inscribirAlumnoACurso(Integer comision, Integer dni, LocalDate fechaActual) {
		if (buscarCursoPorId(comision) != null && buscarAlumnoPorDni(dni) != null
				&& buscarCursoPorId(comision).getCicloLectivo().getFechaFinalizacionInscripcion()
						.compareTo(fechaActual) >= 0
				&& materiasCorrelativasAprobadas(dni, buscarCursoPorId(comision).getMateria().getCodigoMateria())
				&& (buscarCursoPorId(comision).getAlumnosEnCurso() < buscarCursoPorId(comision).getAula()
						.getCAPACIDAD_MAXIMA() && !alumnoConAsignacionEnMismoHorarioYTurno(comision, dni))) {
			AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(buscarCursoPorId(comision),
					buscarAlumnoPorDni(dni));
			if (!this.asignacionesCursoAlumno.contains(asignacionCursoAlumno)) {
				buscarCursoPorId(comision).setAlumnosEnCurso(1);
				return asignacionesCursoAlumno.add(asignacionCursoAlumno);
			}

		}
		return false;
	}

	public Boolean materiasCorrelativasAprobadas(Integer dni, Integer codigoMateria) {
		Boolean materiasCorrelativasAprobadas = false;
		Integer cantidadMateriasCorrelativasAprobadas = 0;

		for (int k = 0; k < buscarMateriaPorId(codigoMateria).getMateriasCorrelativas().size(); k++) {
			for (int f = 0; f < this.asignacionesCursoAlumno.size(); f++) {
				if (this.asignacionesCursoAlumno.get(f).getAlumno().equals(buscarAlumnoPorDni(dni))
						&& this.asignacionesCursoAlumno.get(f).getCurso().getMateria()
								.equals(buscarMateriaPorId(codigoMateria).getMateriasCorrelativas().get(k))
						&& cursadaAprobada(this.asignacionesCursoAlumno.get(f).getCurso().getComision(), dni)) {
					cantidadMateriasCorrelativasAprobadas++;
				}
			}
		}

		if (cantidadMateriasCorrelativasAprobadas
				.equals(buscarMateriaPorId(codigoMateria).getMateriasCorrelativas().size())) {
			materiasCorrelativasAprobadas = true;
		}
		return materiasCorrelativasAprobadas;
	}

	public Boolean cursadaAprobada(Integer comision, Integer dni) {
		Boolean cursadaAprobada = false;
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getCurso().equals(buscarCursoPorId(comision))
					&& this.asignacionesCursoAlumno.get(i).getAlumno().getDni().equals(dni)) {
				if (this.asignacionesCursoAlumno.get(i).getAprobada()
						|| this.asignacionesCursoAlumno.get(i).getPromocionado()) {
					cursadaAprobada = true;
					return cursadaAprobada;
				}

			}
		}
		return cursadaAprobada;
	}

	public Boolean alumnoConAsignacionEnMismoHorarioYTurno(Integer comision, Integer dni) {
		Boolean alumnoConAsignacionEnMismoHorarioYTurno = false;
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getAlumno().getDni().equals(dni)
					&& this.asignacionesCursoAlumno.get(i).getCurso().getComision().equals(comision)
					&& this.asignacionesCursoAlumno.get(i).getCurso().getDia()
							.equals(buscarCursoPorId(comision).getDia())
					&& this.asignacionesCursoAlumno.get(i).getCurso().getHorario()
							.equals(buscarCursoPorId(comision).getHorario())) {
				alumnoConAsignacionEnMismoHorarioYTurno = true;
				return alumnoConAsignacionEnMismoHorarioYTurno;
			}
		}
		return alumnoConAsignacionEnMismoHorarioYTurno;
	}

	public Boolean asignarCursoAlProfesor(Integer comision, Integer dni) {

		if (buscarCursoPorId(comision) != null && buscarProfesorPorDni(dni) != null
				&& buscarAsignacionCursoProfe(comision, dni) == null
				&& (buscarAsignacionCursoAlumno(comision, dni).getCurso()
						.getProfesoresEnCurso() < buscarCursoPorId(comision)
								.getProfesoresNecesarios(buscarCursoPorId(comision).getAlumnosEnCurso()))) {

			if (this.profesores.contains(buscarProfesorPorDni(dni))) {
				AsignacionCursoProfe asignacionCursoProfe = new AsignacionCursoProfe(buscarCursoPorId(comision),
						buscarProfesorPorDni(dni));
				if (!asignacionesCursoProfesor.contains(asignacionCursoProfe)) {
					buscarCursoPorId(comision).setProfesoresEnCurso(1);
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

	public AsignacionCursoAlumno buscarAsignacionCursoAlumno(Integer comision, Integer dni) {
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getCurso().getComision().equals(comision)) {
				return this.asignacionesCursoAlumno.get(i);
			}
		}
		return null;
	}

	public Boolean cargarNotaAlumno(Integer comision, Integer dni, Nota nota) {
		Boolean notaCargada = false;
		
			if (buscarAsignacionCursoAlumno(comision, dni) != null) {
				if ((nota.getParcial().equals(Parcial.PRIMER_PARCIAL))
						|| nota.getParcial().equals(Parcial.RECUPERATORIO_PRIMER_PARCIAL)) {
					buscarAsignacionCursoAlumno(comision, dni).setNotaPrimerParcial(nota);
				} else {
					buscarAsignacionCursoAlumno(comision, dni).setNotaSegundoParcial(nota);
				}
				notaCargada = true;
				return notaCargada;
			}
		
//		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
//			if (this.asignacionesCursoAlumno.get(i).getCurso().equals(buscarCursoPorId(comision))
//					&& this.asignacionesCursoAlumno.get(i).getAlumno().equals(buscarAlumnoPorDni(dni))) {
//				if ((nota.getParcial().equals(Parcial.PRIMER_PARCIAL))
//						|| nota.getParcial().equals(Parcial.RECUPERATORIO_PRIMER_PARCIAL)) {
//					this.asignacionesCursoAlumno.get(i).setNotaPrimerParcial(nota);
//				} else {
//					this.asignacionesCursoAlumno.get(i).setNotaSegundoParcial(nota);
//				}
//				notaCargada = true;
//				return notaCargada;
//			}
//		}
		return notaCargada;
	}

	public ArrayList<AsignacionCursoAlumno> obtenerListadoMateriasAprobadasDeUnAlumno(Integer idAlumno) {
		ArrayList<AsignacionCursoAlumno> listadoMateriasAprobadasPorAlumno = new ArrayList<>();
		for (int i = 0; i < this.asignacionesCursoAlumno.size(); i++) {
			if (this.asignacionesCursoAlumno.get(i).getAlumno().getDni().equals(idAlumno)
					&& (this.asignacionesCursoAlumno.get(i).getPromocionado()
							|| this.asignacionesCursoAlumno.get(i).getAprobada())) {
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
							|| this.asignacionesCursoAlumno.get(i).getAprobada())) {
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
