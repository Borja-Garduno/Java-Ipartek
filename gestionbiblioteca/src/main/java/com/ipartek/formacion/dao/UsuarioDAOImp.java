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

import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.mappers.UsuarioMapper;
import com.ipartek.formacion.dao.persistence.Usuario;

public class UsuarioDAOImp implements UsuarioDAO {
	
	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImp.class);

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		this.jdbctemplate = new JdbcTemplate(dataSource);		
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		
		final String sql = "SELECT * FROM usuario";
		
		try{
			usuarios = jdbctemplate.query(sql, new UsuarioMapper());
		} catch(EmptyResultDataAccessException e){
			usuarios = new ArrayList<Usuario>();
		} catch(Exception e){
			
		}
		
		return usuarios;
	}

	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;
		
		final String sql = "SELECT * FROM usuario WHERE codigo = ?";
		
		try{
			usuario = jdbctemplate.queryForObject(sql, new Object[]{id}, new UsuarioMapper());
		} catch(EmptyResultDataAccessException e){
			usuario = new Usuario();
		} catch(Exception e){
			
		}
		
		return usuario;
	}

	@Override
	public Usuario create(Usuario usuario) {
		final String sql = "INSERT INTO usuario (nombre, apellidos, fNacimiento, email)"
				+ "			VALUES ( UPPER(?), UPPER(?), ?, UPPER(?) );";

		jdbctemplate.update(sql, new Object[]{usuario.getNombre(), usuario.getApellidos(), usuario.getfNacimiento(), usuario.getEmail()});
		
		logger.info("Usuario creado correctamente: " + usuario.getNombre().toUpperCase() + " " + usuario.getApellidos().toUpperCase());
		
		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		final String sql = "UPDATE usuario SET nombre=UPPER(?), apellidos=UPPER(?), fNacimiento=?, email=UPPER(?) WHERE codigo = ?";
		jdbctemplate.update(sql, new Object[]{usuario.getNombre(), usuario.getApellidos(), 
											usuario.getfNacimiento(), usuario.getEmail(), 
											usuario.getCodigo()});
		
		logger.info("Usuario " + usuario.getCodigo() + " actualizado correctamente: " + usuario.getNombre().toUpperCase() + " " + usuario.getApellidos().toUpperCase());
		
		return usuario;
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM usuario WHERE codigo = ?";
		jdbctemplate.update(sql, new Object[]{id});
		logger.info("Usuario borrado correctamente: (id) " + id);		
	}
}
