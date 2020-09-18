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
	<!--datables CSS básico-->
    <link rel="stylesheet" type="text/css" href="datatables/datatables.min.css"/>
    <!--datables estilo bootstrap 4 CSS-->  
    <link rel="stylesheet"  type="text/css" href="datatables/css/dataTables.bootstrap4.min.css">
    
 	<jsp:include page="menu.jsp" />
  </head>
  <body>
  
   <div class="container-sm mt-4">
   <div class="row">
    <div class="col-8"><h1>Lista Contactos</h1></div>
    <div class="col-4" align="right">

    <a href="personadb?opcion=registrar" class="btn btn-primary">Nuevo Contacto</a>
    <br><br></div>
  	</div>
  	
  	<c:if test="${!empty mensaje}">
  		<div class="alert alert-success">
  			${mensaje}
  			<c:remove var="mensaje" scope="session"/>
  		</div>
  	</c:if>
  <div class="table-responsive">  
  <table id="example" class="table table-striped table-bordered" style="width:100%">
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
      <td>${persona.nombres.toUpperCase().charAt(0)}${persona.nombres.substring(1, persona.nombres.length())}</td>
      <td>${persona.apellidos.toUpperCase()}</td>
      <td>${persona.email}</td>
      <td>${persona.celular}</td>
      <td>
      <a href="personadb?opcion=modificar&id=${persona.id}" class="btn btn-outline-primary">Editar</a>
      <a onclick="return confirm('Desea eliminar?')" href="personadb?opcion=eliminar&id=${persona.id}" class="btn btn-outline-primary">Eliminar</a>
    </tr>
    <% x++; %>
</c:forEach>
  </tbody>
</table></div>
  
</div>

<!-- jQuery, Popper.js, Bootstrap JS -->
    <script src="jquery/jquery-3.3.1.min.js"></script>
    <script src="popper/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
        
    <!-- datatables JS -->
    <script type="text/javascript" src="main.js"></script>  
    <script type="text/javascript" src="datatables/datatables.min.js"></script>
</body>
</html>