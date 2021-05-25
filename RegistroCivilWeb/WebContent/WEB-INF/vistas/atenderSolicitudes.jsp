<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">



	<div class="columns is-centered">
		<div class="columns is-6">
			<form method="POST" action="AtenderSolicitudController.do">
				<div class="card">
					<div class="card-header has-background-primary">
						<span class="card-header-title">Atender Solicitud</span>
					</div>
					<div class="card-content has-text-centered">
						<div class="field">
							<label class="label mt-4 " for="tipoSolicitud-select">Tipo
								de Solicitud</label>
							<div class="control">
								<div class="select is-primary">
									<select id="tipoSolicitud-select" name="tipoSolicitud-select">
										<option>Solicitud de Cédula de Identidad</option>
										<option>Retiro de Cédula de Identidad</option>
										<option>Solicitud de Certificado de Nacimiento</option>
										<option>Solicitud de Certificado de Defunción</option>
									</select>
								</div>
							</div>
						</div>
						<div class="field">
							<button type="submit" class="button is-primary">Filtrar</button>
						</div>
						<div class="field">

							<table class="table is-bordered is-fullwidth is-hoverable">
								<thead class="has-background-primary">
									<tr>
										<th>N° de Atención</th>
										<th>Nombre Cliente</th>
										<th>Tipo de Solicitud</th>
										<th>Atender</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="solicitud" items="${solicitudes}">
										<tr>
											<td></td>
											<td>${solicitud.nombreCliente}</td>
											<td>${solicitud.tipoSolicitud}</td>
											<td><a href="AtenderSolicitudController.do?eliminarSolicitud=${solicitud.nombreCliente}">Atender</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</main>
</body>
</html>