package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(rs.getInt("codigo"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellidos(rs.getString("apellidos"));
		usuario.setEmail(rs.getString("email"));
		usuario.setfNacimiento(rs.getDate("fNacimiento"));
		usuario.setUsername(rs.getString("username"));
		usuario.setPassword(rs.getString("password"));

		return usuario;
	}

}