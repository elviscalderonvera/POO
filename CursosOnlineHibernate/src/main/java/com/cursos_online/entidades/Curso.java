package com.cursos_online.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Curso {

	
	@Id
	@GeneratedValue
	private int id;	
	private String descripcion;

	public Curso() {
		super();
	}
	
	
	public Curso(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	public Curso(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
}
