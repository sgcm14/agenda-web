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

<!--     <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/cover/"> -->
	
    <!-- Bootstrap core CSS -->
<!-- <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet"> -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 	<link href="css/cover.css" rel="stylesheet"> -->
 
  </head>
  <body>
   <div class="container-sm mt-4">
   <div class="row">
    <div class="col-8"><h1>Lista Contactos</h1></div>
    <div class="col-4" align="right">
<!--     <button type="button" class="btn btn-success" onclick="window.location.href = 'registrar_alumno.jsp';">Nuevo Alumno</button> -->
    <a href="registrar_persona.jsp" class="btn btn-success">Nuevo Contacto</a>
    <br><br></div>
  	</div>
   
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
 <c:forEach var="persona" items="${listaPersonas}">
  	<tr align="center">
      <th scope="row">${persona.id}</th>
      <td>${persona.nombres}</td>
      <td>${persona.apellidos}</td>
      <td>${persona.email}</td>
      <td>${persona.celular}</td>
      <td>
      <a href="personadb?opcion=modificar&id=${persona.id}" class="btn btn-light">Editar</a>
      <a onclick="return confirm('Desea eliminar?')" href="personadb?opcion=eliminar&id=${persona.id}" class="btn btn-light">Eliminar</a>
    </tr>
</c:forEach>
  </tbody>
</table>
  
</div>
</body>
</html>