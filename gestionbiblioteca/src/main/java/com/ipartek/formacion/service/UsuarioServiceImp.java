package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.persistence.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	UsuarioDAO usuDAO;
	
	@Override
	public List<Usuario> getAll() {	
		return usuDAO.getAll();
	}

	@Override
	public void setAlumDAO(UsuarioDAOImp usuDAO) {
		this.usuDAO = usuDAO;
	}

	@Override
	public Usuario getById(int id) {
		return usuDAO.getById(id);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return usuDAO.update(usuario);
	}

	@Override
	public void delete(int id) {
		usuDAO.delete(id);		
	}

	@Override
	public Usuario create(Usuario usuario) {
		return usuDAO.create(usuario);
	}
}
