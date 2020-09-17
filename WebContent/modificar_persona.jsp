<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Modificar Contacto</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
 	<jsp:include page="menu.jsp" />
  </head>
  <body>
  <div class="container-sm mt-4">
   <form action="personadb" method="post" class="form-signin">
   
   <input type="hidden" class="form-control" name="opcion" value="actualizar">
   <input type="hidden" class="form-control" name="id" value="${Persona.id}">
   <h1>Modificar Contacto</h1><br>
  <div class="form-group">
    <label>Nombres</label>
    <input type="text" class="form-control" name="nombres" value="${Persona.nombres}">
  </div>
  <div class="form-group">
    <label>Apellidos</label>
    <input type="text" class="form-control" name="apellidos" value="${Persona.apellidos}">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" value="${Persona.email}">
  </div>
  <div class="form-group">
    <label>Celular</label>
    <input type="text" class="form-control" name="celular" value="${Persona.celular}">
  </div>
  <button type="submit" class="btn btn-primary">Grabar</button>
  <a href="personadb" class="btn btn-secondary">Cancelar</a>
  
</form>
 </div>
</body>
</html>