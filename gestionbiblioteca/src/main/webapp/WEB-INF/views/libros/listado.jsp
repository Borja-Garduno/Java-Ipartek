<%@page import="com.ipartek.formacion.dao.persistence.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Libros</title>
</head>
<body>

		<a href="home">Inicio</a>
		
		<a href="libros/addLibro">Crear Libro</a>

		<p><b>Listado de Libros:</b></p>
		
		<%
			List<Libro> libros = (List<Libro>) request.getAttribute("listado-libros");
			if(libros!=null){
				if(libros.size()>0){
					for(Libro libro: libros){
						out.print("<p><a href='libros/" + libro.getCodigo() + "'>" + libro.getTitulo() + " - " + libro.getAutor() + "</a> <b><a href='libros/delete/" + libro.getCodigo() + "'>Borrar Libro</a></b></p>");
					}
				} else{
					%>
						<p>No se han encontrado libros en la Base de Datos.</p>
					<%
				}
			} else{
				System.out.println("Libros es nulo.");
			}
		%>

</body>
</html>