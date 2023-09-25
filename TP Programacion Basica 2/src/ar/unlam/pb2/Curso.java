package ar.unlam.pb2;

import java.util.Objects;

public class Curso {

	private Integer comision;
	private Materia materia;
	private Dia dia;
	private Horario horario;
	private CicloLectivo cicloLectivo;
	private Aula aula;
	private Integer profesoresEnCurso;
	private Integer alumnosEnCurso;
	private Integer profesoresNecesarios;

	public Curso(Integer comision, Materia materia, Dia dia, Horario horario, CicloLectivo cicloLectivo, Aula aula) {
		this.comision = comision;
		this.materia = materia;
		this.dia = dia;
		this.horario = horario;
		this.cicloLectivo = cicloLectivo;
		this.aula = aula;
		this.profesoresEnCurso = 0;
		this.alumnosEnCurso = 0;
	}

	public Integer getAlumnosEnCurso() {
		return alumnosEnCurso;
	}

	public void setAlumnosEnCurso(Integer alumnosEnCurso) {
		this.alumnosEnCurso += alumnosEnCurso;
	}

	public Integer getProfesoresEnCurso() {
		return profesoresEnCurso;
	}

	public void setProfesoresEnCurso(Integer profesoresEnCurso) {
		this.profesoresEnCurso += profesoresEnCurso;
	}

	public Integer getProfesoresNecesarios(Integer cantidadDeAlumnos) {
		if (cantidadDeAlumnos <= 20) {
			this.profesoresNecesarios = 1;
		} else if (cantidadDeAlumnos > 20 && cantidadDeAlumnos <= 40) {
			this.profesoresNecesarios = 2;
		} else if (cantidadDeAlumnos > 40 && cantidadDeAlumnos <= 60) {
			this.profesoresNecesarios = 3;
		} else {
			this.profesoresNecesarios = 4;
		}
		return this.profesoresNecesarios;
	}

	public Integer getComision() {
		return comision;
	}

	public void setComision(Integer codigoCurso) {
		this.comision = codigoCurso;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comision);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(comision, other.comision);
	}

}
