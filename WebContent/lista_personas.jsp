<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Lista Contactos</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	
 	<jsp:include page="menu.jsp" />
  </head>
  <body>
  
   <div class="container-sm mt-4">
   <div class="row">
    <div class="col-8"><h1>Lista Contactos</h1></div>
    <div class="col-4" align="right">

    <a href="registrar_persona.jsp" class="btn btn-success">Nuevo Contacto</a>
    <br><br></div>
  	</div>
  	
  	<c:if test="${!empty mensaje}">
  		<div class="alert alert-success">
  			${mensaje}
  			<c:remove var="mensaje" scope="session"/>
  		</div>
  	</c:if>
   
  	<table class="table">
  <thead class="thead-light">
    <tr align="center">
      <th scope="col">#</th>
      <th scope="col">Nombres</th>
      <th scope="col">Apellidos</th>
      <th scope="col">Email</th>
      <th scope="col">Celular</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
  
  <c:set var="x" value="1" />
  <% int x = 1; %>
 <c:forEach var="persona" items="${listaPersonas}">
  	<tr align="center">
      <th scope="row"><%= x %></th>
      <td>${persona.nombres}</td>
      <td>${persona.apellidos}</td>
      <td>${persona.email}</td>
      <td>${persona.celular}</td>
      <td>
      <a href="personadb?opcion=modificar&id=${persona.id}" class="btn btn-light">Editar</a>
      <a onclick="return confirm('Desea eliminar?')" href="personadb?opcion=eliminar&id=${persona.id}" class="btn btn-light">Eliminar</a>
    </tr>
    <% x++; %>
</c:forEach>
  </tbody>
</table>
  
</div>
</body>
</html>