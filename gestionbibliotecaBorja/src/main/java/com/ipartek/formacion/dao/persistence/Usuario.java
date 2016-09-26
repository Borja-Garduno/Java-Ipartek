package com.ipartek.formacion.dao.persistence;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String email;
	private String username;
	private String password;

	public Usuario() {
		super();

		setCodigo(-1);
		setNombre("");
		setApellidos("");
		setfNacimiento(new Date());
		setEmail("");
		setUsername("");
		setPassword("");
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}