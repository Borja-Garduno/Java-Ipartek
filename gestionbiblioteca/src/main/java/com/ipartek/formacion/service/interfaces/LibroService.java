package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.persistence.Libro;

public interface LibroService {
	
	public List<Libro> getAll();
	
	public void setLibroDAO(LibroDAOImp libroDAO);
	
	public Libro getById(int id);
	
	public Libro update(Libro libro);
	
	public void delete(int id);
	
	public Libro create(Libro libro);
}
