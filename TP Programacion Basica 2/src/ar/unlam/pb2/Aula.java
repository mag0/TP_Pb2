package ar.unlam.pb2;

public class Aula {

	private Integer numeroAula;
	private final Integer CAPACIDAD_MAXIMA;

	public Aula(Integer numeroAula, Integer capacidadMaxima) {
		this.numeroAula = numeroAula;
		this.CAPACIDAD_MAXIMA = capacidadMaxima;
	}

	public Integer getNumeroAula() {
		return this.numeroAula;
	}

	public void setNumeroAula(Integer numeroAula) {
		this.numeroAula = numeroAula;
	}

	public Integer getCAPACIDAD_MAXIMA() {
		return this.CAPACIDAD_MAXIMA;
	}

}
