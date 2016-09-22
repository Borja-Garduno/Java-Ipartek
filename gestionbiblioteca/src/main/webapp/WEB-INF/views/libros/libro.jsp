<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Libro</title>
	</head>
	
	<body>
		
		<form:form action="save" modelAttribute="libro" commandName="libro">
			<c:if test="${!empty libro}">
				<form:label path="codigo">
					<spring:message text="Codigo: " />
				</form:label>
				<form:input path="codigo" readonlye="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			
			<br/>
			
			<form:label path="titulo">
				<spring:message text="Titulo: "/>
			</form:label>
			<form:input path="titulo" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="titulo" />
			
			<br/>
			
			<form:label path="autor">
				<spring:message text="Autor: " />
			</form:label>
			<form:input path="autor" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="autor" />
			
			<br/>
			
			<form:label path="isbn">
				<spring:message text="ISBN: " />
			</form:label>
			<form:input path="isbn" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="isbn" />

			<br/>
			
			<c:if test="${libro.codigo>0}">
				<input type="submit" value="<spring:message text="Editar Libro"/>"/>
			</c:if>
			
			<c:if test="${libro.codigo<0}">
				<input type="submit" value="<spring:message text="Crear Libro"/>"/>
			</c:if>
			
			<a href="cancel">Cancelar</a>
			
		</form:form>
		
	</body>
</html>