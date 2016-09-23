package com.ipartek.formacion.dao.persistence;

public class Ejemplar {
	
	private Libro libro;
	private Usuario usuario;
	private int codigo;
	private String editorial;
	private int nPaginas;
	
	public Ejemplar() {
		super();
		setLibro(new Libro());
		setUsuario(new Usuario());
		setCodigo(-1);
		setEditorial("");
		setnPaginas(-1);
	}
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
