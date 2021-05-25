<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">

	<c:if test="${errores !=null}">
	<div class="columns is-centered mb-6">
		<div class="column is-6">
			<div class="notification is-warning">
				<h6>Errores:</h6>	
				<div class="content">
					<ul>
						<c:forEach var="error" items="${errores}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</c:if>
	
	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="AgregarSolicitudController.do">
				<div class="card">
					<div class="card-header has-background-primary">
						<span class="card-header-title">Ingreso Solicitud</span>
					</div>
					<div class="card-content">
						<div class="field" for="rutCliente-txt">
							<label>Rut Cliente</label>
						</div>
						<div class="control">
							<input type="text" class="input" id="rutCilente-txt" name="rutCliente-txt"/>
						</div>
						<div class="field mt-4" for="nombreCliente-txt">
							<label>Nombre Cliente</label>
						</div>
						<div class="control">
							<input type="text" class="input" id="nombreCilente-txt" name="nombreCliente-txt"/>
						</div>
						
						<div class="field">
							<label class="label mt-4" for="tipoSolicitud-select">Tipo de Solicitud</label>
							<div class="control">
								<div class="select is-primary">
									<select id="tipoSolicitud-select" name="tipoSolicitud-select">
										<option>Solicitud de Cédula de Identidad</option>
										<option>Retiro de Cédula de Identidad</option>
										<option>Solicitud de Certificado de Nacimiento</option>
										<option>Solicitud de Certificado de Defunción</option>
									</select>
						<!--  		<div class="field" for="nroAtencion-txt">
							<label>Escriba su número de solicitud original</label>
						</div>
						<div class="control">
							<input type="text" class="input" id="nroAtencion-txt" name="nroAtencion-txt"/>
						</div>
								-->
								</div>
							</div>
						</div>
						
						<div class="field">
						
						</div>
					</div>
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary">Ingresar Solicitud</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</main>
</body>
</html>