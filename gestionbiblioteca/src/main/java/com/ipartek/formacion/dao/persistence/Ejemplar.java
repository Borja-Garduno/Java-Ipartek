package com.ipartek.formacion.dao.persistence;

public class Ejemplar {

	private int codigo;
	private String editorial;
	private int nPaginas;
	
	public Ejemplar() {
		super();
		setCodigo(-1);
		setEditorial("");
		setnPaginas(-1);
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public int getnPaginas() {
		return nPaginas;
	}
	
	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}
}
