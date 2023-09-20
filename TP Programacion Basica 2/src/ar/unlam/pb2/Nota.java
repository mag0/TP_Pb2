package ar.unlam.pb2;

public class Nota {

	private Parcial parcial;
	private Integer nota;

	public Nota() {
		this.nota = 0;
		this.parcial = null;
	}

	public Boolean setNota(Integer nota) {
		if (nota >= 1 && nota <= 10) {
			this.nota = nota;
			return true;
		}

		return false;
	}

	public Integer getValorNota() {
		return this.nota;
	}

	public void setParcial(Parcial parcial) {
		this.parcial = parcial;
	}

	public Parcial getParcial() {
		return this.parcial;
	}

}
