package ar.unlam.pb2;

public class Profesor extends Persona {

	private static Integer generadorId = 1;
	private Integer id;

	public Profesor(Integer dni, String nombre, String apellido) {
		super(dni, nombre, apellido);
		this.id = generadorId++;
	}

	public Integer getId() {
		return id;
	}

}
