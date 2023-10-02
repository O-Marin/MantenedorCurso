<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de Confirmacion</title>
<link href="./common/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<%
	int idInscripcion = (Integer)request.getAttribute("idInscripcion");
	String telefono = (String)request.getAttribute("telefono");
	String nombre = (String) request.getAttribute("nombre");
	String idCurso = (String)request.getAttribute("idCurso");
	String idFormaPago = (String)request.getAttribute("idFormaPago");
%>
<body>
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
					<li class="nav-item"><a class="nav-link" href="/Patrones_disenio_mantenedorCursos/preListarInscripciones">Inscripciones</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/Patrones_disenio_mantenedorCursos/preInscripcion">Inscribir</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="fadeIn first">
		<img src="./common/img/earth.png" id="icon" alt="User Icon" />
	</div>
	<h1>Solicitud Generada Correctamente</h1>
	<p>Su codigo de inscripción es: <%=idInscripcion%></p>
	<p>Telefono: <%=telefono%></p>
	<p>Nombre: <%=nombre%></p>
	<p>id del Curso: <%=idCurso%></p>
	<p>Id de la forma de pago: <%=idFormaPago%></p>
</body>
</html>