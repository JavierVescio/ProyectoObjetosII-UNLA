<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="negocio.sectorPersonal.*"%>
<%@page import="datos.sectorPersonal.*"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<HTML>
<HEAD>
<!-- Codificacion de texto para que se puedan utilizar caracteres especiales -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- tag de titulo -->
<TITLE>Gestión Restaurant</TITLE>
<!-- Tag que sirve para activar la vista responsiva en las pantallas mobil -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Agrego soporte para jquery -->
<script type="text/javascript" src="/Programa_Web/js/jquery.min.js"></script>
<!-- Agrego soporte para jqueryValidation -->
<SCRIPT
	src="http://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"
	type="text/javascript"></SCRIPT>
<!-- Agrego las fuentes de google -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	type="text/css">
<!-- Agrego los iconos de google -->
<LINK rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- LLamo a los estilos del framework MDL (Material design lite) -->
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" />
<!-- Llamo a los javascript del framework MDL (Material design lite) -->
<SCRIPT defer src="https://code.getmdl.io/1.1.3/material.min.js"
	type="text/javascript"></SCRIPT>
<!-- Llamo a mis propios javascript personalizados globales -->
<SCRIPT src="/Programa_Web/js/global.js" type="text/javascript"></SCRIPT>
<!-- Llamo a mis propios CSS personalizados globales -->
<LINK rel="stylesheet" href="/Programa_Web/global.css" />


<!-- Esto se usa para el datatable -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var table = $('#datatable').DataTable();

		$('#datatable tbody').on('click', 'tr', function() {
			var data = table.row(this).data();
			
			document.getElementById("txtPrueba").value = data[0];
			
			alert('ID cliente hidden: ' + document.getElementById("txtPrueba").value);
		});
	});
</script>
<!--  -->



</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>

	<div class="mdl-grid center-items">

		<h2 class="mdl-card__title-text">OCUPACION DE MESA</h2>

		<form action="/Programa_Web/ocuparmesa" method="post">



			<div class="contenedortabla">
				<table id="datatable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Apellido</th>
							<th>Nombre</th>
							<th>DNI</th>
						</tr>
					</thead>
					<tbody>
						<%
							PersonaABM abmPersona = new PersonaABM();
							List<Cliente> lista = abmPersona.traerClientes();
							for (Cliente cliente : lista) {
						%><tr>
							<td><%=cliente.getIdPersona()%></td>
							<td><%=cliente.getApellido()%></td>
							<td><%=cliente.getNombre()%></td>
							<td><%=cliente.getDni()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>


			<input type="hidden" id="txtPrueba" value="-">
			
			<input type="Button" name="btnPrueba" value="Cambiar texto" onclick="myFunction()"/>
			
			<!-- <script>
				function myFunction() {
				    document.getElementById("text").style.color = "red";
				}
			</script>-->


			<div class="mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text"
					pattern="-?[0-9]*(\.[0-9]+)?" id="idNumCliente" name="idcliente">
				<label class="mdl-textfield__label" for="sample2">ID
					Cliente...</label> <span class="mdl-textfield__error">Lo ingresado
					no es un número!</span>
			</div>

			<div class="mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text"
					pattern="-?[0-9]*(\.[0-9]+)?" id="sample2" name="idcamarero">
				<label class="mdl-textfield__label" for="sample2">ID
					Camarero...</label> <span class="mdl-textfield__error">Lo ingresado
					no es un número!</span>
			</div>

			<div class="mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text"
					pattern="-?[0-9]*(\.[0-9]+)?" id="sample2" name="idmesa"> <label
					class="mdl-textfield__label" for="sample2">ID Mesa...</label> <span
					class="mdl-textfield__error">Lo ingresado no es un número!</span>
			</div>

			<div class="mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text"
					pattern="-?[0-9]*(\.[0-9]+)?" id="sample2"
					name="cantidadcomensales"> <label
					class="mdl-textfield__label" for="sample2">Cantidad de
					comensales...</label> <span class="mdl-textfield__error">Lo
					ingresado no es un número!</span>
			</div>

			<br>
			<!-- Accent-colored raised button with ripple -->
			<button
				class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
				Registrar ocupación de mesa</button>
		</form>

	</div>

</body>
</html>