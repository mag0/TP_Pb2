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
	private Boolean puedeRecuperarPrimerParcial;
	private Boolean puedeRecuperarSegundoParcial;
	
	public AsignacionCursoAlumno(Curso curso, Alumno alumno) {
		this.idAsignacionCursoAlumno = generadorId++;
		this.curso = curso;
		this.alumno = alumno;
		this.notaPrimerParcial = new Nota();
		this.notaSegundoParcial = new Nota();
		this.promocionado = false;
		this.aprobado = false;
		this.desaprobado = false;
		this.puedeRecuperarPrimerParcial = false;
		this.puedeRecuperarSegundoParcial = false;
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

	public Boolean setNota(Nota nota) {
		Boolean notaCargada = true;
		
		if(nota.getParcial().equals(Parcial.PRIMER_PARCIAL) && this.getNotaPrimerParcial().getValorNota() == 0) {
			this.notaPrimerParcial = nota;
		}else if(nota.getParcial().equals(Parcial.SEGUNDO_PARCIAL) && this.getNotaSegundoParcial().getValorNota() == 0) {
			this.notaSegundoParcial = nota;
		}else if(nota.getParcial().equals(Parcial.RECUPERATORIO_PRIMER_PARCIAL) && getPuedeRecuperarPrimerParcial()) {
			this.notaPrimerParcial = nota;
			this.puedeRecuperarPrimerParcial = false;
		}else if(nota.getParcial().equals(Parcial.RECUPERATORIO_SEGUNDO_PARCIAL) && getPuedeRecuperarSegundoParcial()) {
			this.notaSegundoParcial = nota;
			this.puedeRecuperarSegundoParcial = false;
		}else {
			notaCargada = false;
		}
		return notaCargada;

	}

	public Nota getNotaSegundoParcial() {
		return this.notaSegundoParcial;
	}
	
	public Boolean getPuedeRecuperarPrimerParcial() {
		if((this.notaPrimerParcial.getValorNota() < 4 && this.notaSegundoParcial.getValorNota() >= 4) || (this.notaPrimerParcial.getValorNota() < 7 && this.notaSegundoParcial.getValorNota() >= 7)) {
			this.puedeRecuperarPrimerParcial = true;
		}
		return this.puedeRecuperarPrimerParcial;
	}
	
	public Boolean getPuedeRecuperarSegundoParcial() {
		if((this.notaSegundoParcial.getValorNota() < 4 && this.notaPrimerParcial.getValorNota() >= 4) || (this.notaSegundoParcial.getValorNota() < 7 && this.notaPrimerParcial.getValorNota() >= 7)) {
			this.puedeRecuperarSegundoParcial = true;
		}
		return this.puedeRecuperarSegundoParcial;
	}

	public Boolean getAprobado() {
		if (((this.notaPrimerParcial.getValorNota() >= 4 && this.notaPrimerParcial.getValorNota() < 7)
				&& this.notaSegundoParcial.getValorNota() >= 4)
				|| ((this.notaSegundoParcial.getValorNota() >= 4 && this.notaSegundoParcial.getValorNota() < 7)
						&& this.notaPrimerParcial.getValorNota() >= 4)) {
			this.aprobado = true;
		}
		return this.aprobado;
	}

	public Boolean getPromocionado() {
		if(this.notaPrimerParcial.getValorNota() >= 7 && this.notaSegundoParcial.getValorNota() >= 7) {
			this.promocionado = true;
		}
		return this.promocionado;
	}

	public Boolean getDesaprobado() {
		if(this.notaPrimerParcial.getValorNota() < 4 || this.notaSegundoParcial.getValorNota() < 4) {
			this.desaprobado = true;
		}
		return this.desaprobado;
	}

	public Integer getNotaFinal() {
		return (this.notaPrimerParcial.getValorNota() + this.notaSegundoParcial.getValorNota()) / 2;
	}
}
