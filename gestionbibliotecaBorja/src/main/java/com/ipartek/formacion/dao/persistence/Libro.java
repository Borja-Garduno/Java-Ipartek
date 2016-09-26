package com.ipartek.formacion.dao.persistence;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	private int codigo;
	private String titulo;
	private String autor;
	private String isbn;
	private List<Ejemplar> ejemplares;

	public Libro() {
		super();
		setCodigo(-1);
		setTitulo("");
		setIsbn("");
		setEjemplares(new ArrayList<Ejemplar>());
	}

	public void addEjemplar(Ejemplar ejemplar) {
		this.ejemplares.add(ejemplar);
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
