package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.dao.persistence.Libro;

public interface EjemplarService {

	public List<Ejemplar> getAll();
	
	public void setEjemDAO(EjemplarDAOImp ejemDAO);
	
	public Ejemplar getById(int id);
	
	public Ejemplar update(Ejemplar ejemplar);
	
	public void delete(int id);
	
	public Ejemplar create(Ejemplar ejemplar);
}
