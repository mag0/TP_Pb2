package ar.unlam.pb2;

public class AsignacionCursoAlumno {

	private static Integer generadorId = 1;
	private Integer idAsignacionCursoAlumno;
	private Curso curso;
	private Alumno alumno;
	private Nota notaPrimerParcial;
	private Nota notaSegundoParcial;
	private Boolean promocionado;
	private Boolean aprobado;
	private Boolean desaprobado;

	public AsignacionCursoAlumno(Curso curso, Alumno alumno) {
		this.idAsignacionCursoAlumno = generadorId++;
		this.curso = curso;
		this.alumno = alumno;
		this.notaPrimerParcial = new Nota();
		this.notaSegundoParcial = new Nota();
		this.promocionado = false;
		this.aprobado = false;
		this.desaprobado = true;
	}

	public Integer getIdAsignacionCursoAlumno() {
		return idAsignacionCursoAlumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Nota getNotaPrimerParcial() {
		return this.notaPrimerParcial;
	}

	public void setNotaPrimerParcial(Nota nota) {
		this.notaPrimerParcial = nota;
		if (this.notaPrimerParcial.getValorNota() >= 4 && this.notaSegundoParcial.getValorNota() >= 4) {
			this.aprobado = true;
			this.desaprobado = false;
			this.promocionado = false;
			if (this.notaPrimerParcial.getValorNota() >= 7 && this.notaSegundoParcial.getValorNota() >= 7) {
				this.aprobado = false;
				this.desaprobado = false;
				this.promocionado = true;
			}
		} else {
			this.aprobado = false;
			this.desaprobado = true;
			this.promocionado = false;
		}
	}

	public Nota getNotaSegundoParcial() {
		return this.notaSegundoParcial;
	}

	public void setNotaSegundoParcial(Nota nota) {
		this.notaSegundoParcial = nota;
		if (this.notaPrimerParcial.getValorNota() >= 4 && this.notaSegundoParcial.getValorNota() >= 4) {
			this.aprobado = true;
			this.desaprobado = false;
			this.promocionado = false;
			if (this.notaPrimerParcial.getValorNota() >= 7 && this.notaSegundoParcial.getValorNota() >= 7) {
				this.aprobado = false;
				this.desaprobado = false;
				this.promocionado = true;
			}
		} else {
			this.aprobado = false;
			this.desaprobado = true;
			this.promocionado = false;
		}
	}

	public Boolean getAprobada() {
		return this.aprobado;
	}

	public Boolean getPromocionado() {
		return this.promocionado;
	}

	public Boolean getDesaprobado() {
		return this.desaprobado;
	}
	
	public Integer getNotaFinal() {
		return (this.notaPrimerParcial.getValorNota() + this.notaSegundoParcial.getValorNota())/2;
	}
}
