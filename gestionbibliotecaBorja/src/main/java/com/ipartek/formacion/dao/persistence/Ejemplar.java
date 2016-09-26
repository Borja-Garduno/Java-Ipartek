package com.ipartek.formacion.dao.persistence;

public class Ejemplar extends Libro {
	
	private int codigo;
	private String editorial;
	private int nPaginas;
	private Usuario usuario;
	
	public Ejemplar(Usuario usuario) {
		super();
		setCodigo(-1);
		setEditorial("");
		setUsuario(usuario);
		setnPaginas(0);
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}