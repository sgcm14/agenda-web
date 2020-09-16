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
    <title>Registrar Contacto</title>

<!--     <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/cover/"> -->
	
    <!-- Bootstrap core CSS -->
<!-- <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet"> -->
	<link href="css/floating-labels.css" rel="stylesheet">
	<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 	<link href="css/cover.css" rel="stylesheet"> -->
 
  </head>
  <body>
   <form action="personadb" method="post" class="form-signin">
   <input type="hidden" class="form-control" name="opcion" value="insertar">
   <h1>Registrar Contacto</h1><br>
  <div class="form-group">
    <label>Nombres</label>
    <input type="text" class="form-control" name="nombres">
  </div>
  <div class="form-group">
    <label>Apellidos</label>
    <input type="text" class="form-control" name="apellidos">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label>Celular</label>
    <input type="text" class="form-control" name="celular">
  </div>
  <!-- <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div> -->
  <button type="submit" class="btn btn-primary">Grabar</button>
  <a href="personadb" class="btn btn-secondary">Cancelar</a>
  
</form>
  


</body>
</html>