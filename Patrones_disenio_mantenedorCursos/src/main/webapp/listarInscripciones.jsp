<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cl.omarin.entidades.InscripcionDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscripciones</title>
<link href="./common/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
List<InscripcionDTO> inscripciones;
inscripciones = (List<InscripcionDTO>)request.getAttribute("listaInscripcionesAlumno");
%>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<p class="navbar-brand" href="#">Mantenedor</p>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="listarInscripciones.jsp">Inscripciones</a>
					</li>
					
				</ul>
			</div>
		</div>
	</nav>
	<div class="fadeIn first d-flex p-2">
		<img src="./common/img/earth.png" id="icon" alt="User Icon" />
		<div>
		<div class="container">
  <h2>Listado de inscripciones</h2>
  <p>Listado de inscripciones</p>            
  <table class="table">
    <thead>
      <tr>
        <th>Id Inscripcion</th>
        <th>Nombre</th>
        <th>Telefono</th>
        <th>Id Curso</th>
        <th>Id Forma de Pago</th>
      </tr>
    </thead>
    <tbody>
    	<%
			for(InscripcionDTO dto : inscripciones){
		%> 
      <tr>
        <td><%= dto.getId_inscription()%></td>
        <td><%= dto.getNombre()%></td>
        <td><%= dto.getTelefono()%></td>
        <td><%= dto.getId_curso()%></td>
        <td><%= dto.getId_forma_pago()%></td>
      </tr>
      <% } %>
    </tbody>
  </table>
</div>
	</div>
	</div>
	
</body>
</html>