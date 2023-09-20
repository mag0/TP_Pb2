package ar.unlam.pb2;

import java.util.ArrayList;

public class Materia {
	
	private Integer codigoMateria;
	private String nombre;
	private ArrayList<Materia> materiasCorrelativas;
	
	public Materia(Integer codigoMateria, String nombre) {
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
		this.materiasCorrelativas = new ArrayList<>();
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
		if(materiasCorrelativas.contains(Materiacorrelativa))
			return false;
		return materiasCorrelativas.add(Materiacorrelativa);
	}
	
	public Boolean eliminarMateriaCorrelativa(Integer id) {
		for(int i=0;i<this.materiasCorrelativas.size();i++) {
			if(this.materiasCorrelativas.get(i).getCodigoMateria().equals(id)) {
				return this.materiasCorrelativas.remove(this.materiasCorrelativas.get(i));
			}
		}
		return false;
	}
	
	public Materia buscarMateriaCorrelativa(Integer id) {
		for(int i=0;i<this.materiasCorrelativas.size();i++) {
			if(this.materiasCorrelativas.get(i).getCodigoMateria().equals(id)) {
				return this.materiasCorrelativas.get(i);
			}
		}
		return null;
	}
	
	public Integer getCantidadMateriasCorrelativas() {
		return materiasCorrelativas.size();
	}
	
}
