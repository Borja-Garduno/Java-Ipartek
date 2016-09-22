package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.mappers.LibroMapper;
import com.ipartek.formacion.dao.mappers.UsuarioMapper;
import com.ipartek.formacion.dao.persistence.Libro;
import com.ipartek.formacion.dao.persistence.Usuario;

public class LibroDAOImp implements LibroDAO {

	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImp.class);
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		this.jdbctemplate = new JdbcTemplate(dataSource);	
	}

	@Override
	public List<Libro> getAll() {
		List<Libro> libros = null;
		
		final String sql = "SELECT * FROM libro";
		
		try{
			libros = jdbctemplate.query(sql, new LibroMapper());
		} catch(EmptyResultDataAccessException e){
			libros = new ArrayList<Libro>();
		} catch(Exception e){
			
		}
		
		return null;
	}

	@Override
	public Libro getById(int id) {
		Libro libro = null;
		
		final String sql = "SELECT * FROM libro WHERE codigo = ?";
		
		try{
			libro = jdbctemplate.queryForObject(sql, new Object[]{id}, new LibroMapper());
		} catch(EmptyResultDataAccessException e){
			libro = new Libro();
		} catch(Exception e){
			
		}
		
		return libro;
	}

	@Override
	public Libro create(Libro libro) {
		final String sql = "INSERT INTO libro (titulo, autor, isbn)"
				+ "			VALUES ( UPPER(?), UPPER(?), UPPER(?) );";

		jdbctemplate.update(sql, new Object[]{libro.getTitulo(), libro.getAutor(), libro.getIsbn()});
		
		// ESTE METODO PARA SACAR LA ID DEL LIBRO INSERTADO NO SE DEBERIA USAR
		// SE DEBEN USAR PROCEDIMIENTOS ALMACENADOS
		// PODRIA DAR CONFLICTOS CON VARIAS OPERACIONES AL MISMO TIEMPO
		String sql2 ="SELECT MAX(codigo) FROM libro;";
		int id = jdbctemplate.queryForObject(sql2, int.class);
		libro.setCodigo(id);
		
		logger.info("Libro " + libro.getCodigo() + " creado correctamente: " + libro.getTitulo().toUpperCase());
		return libro;
	}

	@Override
	public Libro update(Libro libro) {
		final String sql = "UPDATE libro SET titulo=UPPER(?), autor=UPPER(?), isbn=UPPER(?) WHERE codigo = ?";
		jdbctemplate.update(sql, new Object[]{libro.getTitulo(), libro.getAutor(), 
											libro.getIsbn(), libro.getCodigo()});
		
		logger.info("Libro " + libro.getCodigo() + " actualizado correctamente: " + libro.getTitulo().toUpperCase());
		
		return libro;
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM libro WHERE codigo = ?";
		jdbctemplate.update(sql, new Object[]{id});
		logger.info("Libro borrado correctamente: (id) " + id);
	}
}
