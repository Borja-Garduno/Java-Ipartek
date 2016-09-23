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

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.mappers.EjemplarMapper;
import com.ipartek.formacion.dao.persistence.Ejemplar;

public class EjemplarDAOImp implements EjemplarDAO {

	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	private static final Logger logger = LoggerFactory.getLogger(EjemplarDAOImp.class);
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		this.jdbctemplate = new JdbcTemplate(dataSource);			
	}

	@Override
	public List<Ejemplar> getAll() {
		List<Ejemplar> ejemplares = null;
		
		final String sql = "SELECT * FROM ejemplar;";
		
		try{
			ejemplares = jdbctemplate.query(sql, new EjemplarMapper());
		} catch(EmptyResultDataAccessException e){
			ejemplares = new ArrayList<Ejemplar>();
		} catch(Exception e){
			
		}
		
		return ejemplares;
	}
	
	@Override
	public List getEjemplaresLibrosAll(){
		List lista = null;
		
		final String sql = "SELECT l.codigo as Codigo_Libro, e.codigo as Codigo_Ejemplar, l.titulo as Titulo_Libro "
							+ "FROM ejemplar e "
							+ "INNER JOIN libro l "
							+ "ON e.codigoLibro=l.codigo;";
		
		try{
			lista = jdbctemplate.queryForList(sql);
			//logger.info("Datos lista: " + lista.toString());
			
			for(int i=0; i<lista.size(); i++){
				System.out.println(lista.get(i));
			}
		} catch(EmptyResultDataAccessException e){
			lista = new ArrayList();
		} catch(Exception e){
			
		}
		
		return lista;
	}
	
	/*
	SELECT l.codigo as Codigo_Libro, e.codigo as Codigo_Ejemplar, l.titulo as Titulo_Libro
	FROM ejemplar e 
	INNER JOIN libro l
	ON e.codigoLibro=l.codigo;
	
	Codigo_Libro 	Codigo_Ejemplar 	Titulo_Libro 	
	1 				6 					LOS PILARES DE LA TIERRA
	2 				7 					HARRY POTTER Y LA PIEDRA FILOSOFAL
	2 				8 					HARRY POTTER Y LA PIEDRA FILOSOFAL
	4 				9 					DIEZ NEGRITOS
	*/
	
	@Override
	public Ejemplar getById(int id) {
		Ejemplar ejemplar = null;
		
		final String sql = "SELECT * FROM ejemplar WHERE codigo = ?;";
		
		try{
			ejemplar = jdbctemplate.queryForObject(sql, new Object[]{id}, new EjemplarMapper());
		} catch(EmptyResultDataAccessException e){
			ejemplar = new Ejemplar();
		} catch(Exception e){
			
		}
		
		return ejemplar;
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		final String sql = "INSERT INTO ejemplar (codigoLibro, editorial, nPaginas)"
				+ "			VALUES (?, UPPER(?), ? );";

		jdbctemplate.update(sql, new Object[]{ejemplar.getCodigoLibro(), ejemplar.getEditorial(), ejemplar.getnPaginas()});
		
		// ESTE METODO PARA SACAR LA ID DEL EJEMPLAR INSERTADO NO SE DEBERIA USAR
		// SE DEBEN USAR PROCEDIMIENTOS ALMACENADOS
		// PODRIA DAR CONFLICTOS CON VARIAS OPERACIONES AL MISMO TIEMPO
		String sql2 ="SELECT MAX(codigo) FROM ejemplar;";
		int id = jdbctemplate.queryForObject(sql2, int.class);
		ejemplar.setCodigo(id);
		
		logger.info("Libro " + ejemplar.getCodigo() + " creado correctamente: (id libro) " + ejemplar.getCodigoLibro() + " - (editorial) " + ejemplar.getEditorial().toUpperCase());
		return ejemplar;
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		final String sql = "UPDATE ejemplar SET codigoLibro=?, editorial=UPPER(?), nPaginas=? WHERE codigo = ?;";
		jdbctemplate.update(sql, new Object[]{ejemplar.getCodigoLibro(), ejemplar.getEditorial(), ejemplar.getnPaginas(), ejemplar.getCodigo()});
		
		logger.info("Ejemplar " + ejemplar.getCodigo() + " actualizado correctamente: (id libro) " + ejemplar.getCodigoLibro() + " - (editorial) " + ejemplar.getEditorial().toUpperCase());
		
		return ejemplar;
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM ejemplar WHERE codigo = ?;";
		jdbctemplate.update(sql, new Object[]{id});
		logger.info("Ejemplar borrado correctamente: (id) " + id);
	}

}
