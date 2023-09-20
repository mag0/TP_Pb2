package ar.unlam.pb2;

public class AsignacionCursoProfe {

	private static Integer generadorId = 1;
	private Integer idAsignacionCursoProfe;
	private Curso curso;
	private Profesor profesor;

	public AsignacionCursoProfe(Curso curso, Profesor profesor) {
		this.idAsignacionCursoProfe = generadorId++;
		this.curso = curso;
		this.profesor = profesor;

	}

	public Integer getIdAsignacionCursoProfe() {
		return idAsignacionCursoProfe;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}
