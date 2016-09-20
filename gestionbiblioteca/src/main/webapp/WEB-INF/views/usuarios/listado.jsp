<%@page import="com.ipartek.formacion.dao.persistence.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Usuarios</title>
</head>
<body>

		<a href="home">Inicio</a>
		
		<a href="usuarios/addUsuario">Crear Usuario</a>

		<p><b>Listado de Usuarios:</b></p>
		
		<%
			List<Usuario> usuarios = (List<Usuario>) request.getAttribute("listado-usuarios");
			if(usuarios.size()>0){
				for(Usuario usuario: usuarios){
					out.print("<p><a href='alumnos/" + usuario.getCodigo() + "'>" + usuario.getNombre() + " " + usuario.getApellidos() + "</a> <b><a href='usuarios/delete/" + usuario.getCodigo() + "'>Borrar Usuario</a></b></p>");
				}
			} else{
				%>
					<p>No se han encontrado usuarios en la Base de Datos.</p>
				<%
			}
		%>

</body>
</html>