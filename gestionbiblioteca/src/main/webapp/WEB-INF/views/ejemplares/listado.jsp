<%@page import="com.ipartek.formacion.dao.persistence.Ejemplar"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Ejemplares</title>
</head>
<body>

		<a href="home">Inicio</a>
		
		<a href="ejemplares/addEjemplar">Crear Ejemplar</a>

		<p><b>Listado de Ejemplares:</b></p>
		
		<%
			List<Ejemplar> ejemplares = (List<Ejemplar>) request.getAttribute("listado-ejemplares");
			if(ejemplares!=null){
				if(ejemplares.size()>0){
					for(Ejemplar ejemplar: ejemplares){
						out.print("<p><a href='ejemplares/" + ejemplar.getCodigo() + "'>" + ejemplar.getLibro().getCodigo() + " - " +  ejemplar.getEditorial() + " - " + ejemplar.getnPaginas() + "</a> <b><a href='ejemplares/delete/" + ejemplar.getCodigo() + "'>Borrar Ejemplar</a></b></p>");
					}
				} else{
					%>
						<p>No se han encontrado ejemplares en la Base de Datos.</p>
					<%
				}
			} else{
				System.out.println("Ejemplares es nulo.");
			}
		%>

</body>
</html>