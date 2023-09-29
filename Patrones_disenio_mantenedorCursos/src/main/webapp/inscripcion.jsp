<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cl.omarin.entidades.FormaDePagoDTO" %>
<%@ page import="cl.omarin.entidades.CursoDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscripciones</title>
<link href="./common/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<%
/*aca debo crear las listas que utilizare en la pagina y recibir los atributos provenientes del servlet*/
 List<CursoDTO> cursos;
 List<FormaDePagoDTO> formasPago;
 
 cursos = (List<CursoDTO>)request.getAttribute("cursos");
 formasPago = (List<FormaDePagoDTO>)request.getAttribute("formasPago");
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
					<li class="nav-item"><a class="nav-link"
						href="/Patrones_disenio_mantenedorCursos/preListarInscripciones">Inscripciones</a>
					</li>
					<li class="</div>nav-item"><a class="nav-link"
						href="/Patrones_disenio_mantenedorCursos/preInscripcion">Inscribir</a>
					</li>

				</ul>
			</div>
		</div>
	</nav>
	<div class="fadeIn first">
		<img src="./common/img/earth.png" id="icon" alt="User Icon" />
	</div>
	<div class="container">
		<div class="d-flex flex-column mb-3">
			<form action="/posInscripcion">
				<div class="form-group">
					<label>Nombre</label>
					<input type="text" name="nombre" id="nombre">
				</div>
				<div>
					<label>Telefono</label>
					<input type="text" name="telefono">
				</div>
				<div>
					<label>Cursos:</label> 
					<select name="idCurso">
						<%
						for(CursoDTO dto:cursos){
						%> 
						<option value="<%= dto.getIdCurso()%>">
							<%=dto.getDescripcion()%>
						</option>
						<%
						}
						%>
					</select>
				</div>
				<div>
					<label>Formas de pago:</label> 
					<select name="idFormaPago">
						<%for(FormaDePagoDTO dto:formasPago){ %>
							<option value="<%= dto.getId_forma_de_pago()%>"><%=dto.getDescripcion() %></option>
						<%}%>
					</select>
				</div>
				<button type="submit" class="btn btn-default">enviar</button>
			</form>
		</div>
	</div>
</body>
</html>