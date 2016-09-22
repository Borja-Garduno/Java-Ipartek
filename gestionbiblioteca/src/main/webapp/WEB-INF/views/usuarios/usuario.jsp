<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Usuario</title>
	</head>
	
	<body>
		
		<form:form action="save" modelAttribute="usuario" commandName="usuario">
			<c:if test="${!empty usuario}">
				<form:label path="codigo">
					<spring:message text="Codigo: " />
				</form:label>
				<form:input path="codigo" readonlye="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			
			<br/>
			
			<form:label path="nombre">
				<spring:message text="Nombre: "/>
			</form:label>
			<form:input path="nombre" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="nombre" />
			
			<br/>
			
			<form:label path="apellidos">
				<spring:message text="Apellidos: " />
			</form:label>
			<form:input path="apellidos" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="apellidos" />
			
			<br/>
			
			<form:label path="fNacimiento">
				<spring:message text="Fecha Nacimento: " />
			</form:label>
			<form:input path="fNacimiento" placeholder="dd/MM/yyyy" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="fNacimiento" />
			
			<br/>
			
			<form:label path="email">
				<spring:message text="Email: " />
			</form:label>
			<form:input path="email" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="email" />

			<br/>
			
			<c:if test="${usuario.codigo>0}">
				<input type="submit" value="<spring:message text="Editar Usuario"/>"/>
			</c:if>
			
			<c:if test="${usuario.codigo<0}">
				<input type="submit" value="<spring:message text="Crear Usuario"/>"/>
			</c:if>
			
			<a href="cancel">Cancelar</a>
			
		</form:form>
		
	</body>
</html>