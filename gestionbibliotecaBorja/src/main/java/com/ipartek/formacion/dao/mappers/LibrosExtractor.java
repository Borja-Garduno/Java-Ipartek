package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.dao.persistence.Libro;
import com.ipartek.formacion.dao.persistence.Usuario;

public class LibrosExtractor implements ResultSetExtractor<List<Libro>> {

	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;

		while (rs.next()) {
			Integer id = rs.getInt("codigo");
			libro = map.get(id);
			
			if (libro == null) {
				libro = new Libro();
				libro.setCodigo(rs.getInt("codigo"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setIsbn(rs.getString("isbn"));
				map.put(id, libro);
			}
			
			Usuario usuario = new Usuario();
			usuario.setCodigo(rs.getInt("codigo"));
			Ejemplar ejemplar = new Ejemplar(usuario);
			ejemplar.setEditorial(rs.getString("editorial"));
			ejemplar.setnPaginas(rs.getInt("nPaginas"));
			libro.addEjemplar(ejemplar);
		}
		return new ArrayList<Libro>(map.values());
	}

}