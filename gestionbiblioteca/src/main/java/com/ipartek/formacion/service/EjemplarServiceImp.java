package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.service.interfaces.EjemplarService;

@Service
public class EjemplarServiceImp implements EjemplarService {

	@Autowired
	EjemplarDAO ejemDAO;
	
	@Override
	public List<Ejemplar> getAll() {
		return ejemDAO.getAll();
	}

	@Override
	public void setEjemDAO(EjemplarDAOImp ejemDAO) {
		this.ejemDAO = ejemDAO;
	}

	@Override
	public Ejemplar getById(int id) {
		return ejemDAO.getById(id);
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		return ejemDAO.update(ejemplar);
	}

	@Override
	public void delete(int id) {
		ejemDAO.delete(id);
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		return ejemDAO.create(ejemplar);
	}

}
