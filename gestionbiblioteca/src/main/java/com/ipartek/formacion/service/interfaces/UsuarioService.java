package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.persistence.Usuario;

public interface UsuarioService {
	
	public List<Usuario> getAll();
	
	public void setAlumDAO(UsuarioDAOImp usuDAO);
	
	public Usuario getById(int id);
	
	public Usuario update(Usuario usuario);
	
	public void delete(int id);
	
	public Usuario create(Usuario usuario);
}
