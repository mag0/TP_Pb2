package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.Objects;

public class Materia {

	private static Integer generadorId = 1;
	private Integer id;
	private Integer codigoMateria;
	private String nombre;
	private ArrayList<Materia> materiasCorrelativas;

	public Materia(Integer codigoMateria, String nombre) {
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
		this.materiasCorrelativas = new ArrayList<>();
		this.id = generadorId++;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Materia> getMateriasCorrelativas() {
		return materiasCorrelativas;
	}

	public Boolean setMateriaCorrelativa(Materia Materiacorrelativa) {
		if (materiasCorrelativas.contains(Materiacorrelativa))
			return false;
		return materiasCorrelativas.add(Materiacorrelativa);
	}

	public Boolean eliminarMateriaCorrelativa(Integer id) {
		for (int i = 0; i < this.materiasCorrelativas.size(); i++) {
			if (this.materiasCorrelativas.get(i).getCodigoMateria().equals(id)) {
				return this.materiasCorrelativas.remove(this.materiasCorrelativas.get(i));
			}
		}
		return false;
	}

	public Integer getCantidadMateriasCorrelativas() {
		return materiasCorrelativas.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoMateria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(codigoMateria, other.codigoMateria);
	}

}
