<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="negocio.sectorPersonal.*"%>
<%@page import="negocio.sectorMesa.*"%>
<%@page import="datos.sectorPersonal.*"%>
<%@page import="datos.sectorMesa.*"%>
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
	    var tableC = $('#tablaCliente').DataTable();
	    $('#tablaCliente tbody').on( 'click', 'tr', function () {
	    		tableC.$('tr.selected').removeClass('selected');
	        	$(this).addClass('selected');
	    	    var data = tableC.row(this).data();
	    	    document.getElementById("lblClienteSeleccionado").value = "Cliente seleccionado: " + data[1] + ", " + data[2];
	    	    document.getElementById("hiddenIdCliente").value = data[0];
	    } );
	    
	    var tableD = $('#tablaCamarero').DataTable();
	    $('#tablaCamarero tbody').on( 'click', 'tr', function () {
	    		tableD.$('tr.selected').removeClass('selected');
	        	$(this).addClass('selected');
	    	    var data = tableD.row(this).data();
	    	    document.getElementById("lblCamareroSeleccionado").value = "Camarero seleccionado: " + data[1] + ", " + data[2];
	    	    document.getElementById("hiddenIdCamarero").value = data[0];
	    	    
	    } );
	    
	} );
	
</script>
<!--  -->



</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>

<a href="/Programa_Web/administracion.jsp">Volver al menú principal</a>

	<div class="subtitulo">
		<!--Donde va el logo y el titulo-->
		<div class="container">
			<h3>Acomodar clientes</h3>
		</div>
	</div>


	<h5>1.- Selección de cliente</h5>

	<div class="contenedortabla">
		<table id="tablaCliente">
			<thead>
				<tr>
					<th>ID</th>
					<th>Apellido</th>
					<th>Nombre</th>
					<th>DNI</th>
				</tr>
			</thead>
			<tbody>
				<%try{
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
				}
				catch(Exception e){
					
				}
				%>
			</tbody>
		</table>
	</div>

	<h5>2.- Selección de camarero</h5>
	
	
	<div class="contenedortabla">
		<table id="tablaCamarero">
			<thead>
				<tr>
					<th>ID</th>
					<th>Apellido</th>
					<th>Nombre</th>
					<th>DNI</th> 
					<th>Cant. Mesas Asignadas</th>
				</tr>
			</thead>
			<tbody>
				<%
				try{
					PersonaABM abmPersona = new PersonaABM();
					List<Personal> listaPersonal = abmPersona.traerCamareros();
					for (Personal personal : listaPersonal) {
						int cantidad = abmPersona.traerPersonalConCantidadDeMesasAsignadas(personal.getIdPersona());
				%><tr>
					<td><%=personal.getIdPersona()%></td>
					<td><%=personal.getApellido()%></td>
					<td><%=personal.getNombre()%></td>
					<td><%=personal.getDni()%></td>
					<td><%=abmPersona.traerPersonalConCantidadDeMesasAsignadas(personal.getIdPersona())%></td>
				</tr>
				<%
					}
				}
				catch(Exception e){
					
				}
				%>
			</tbody>
		</table>
	</div>


	<div class="mdl-textfield mdl-js-textfield">
		<input class="mdl-textfield__input" type="text"
			id="lblClienteSeleccionado" readonly>
	</div>
	<br>
	<div class="mdl-textfield mdl-js-textfield">
		<input class="mdl-textfield__input" type="text"
			id="lblCamareroSeleccionado" readonly>
	</div>
	<br>

	<script type="text/javascript">
		function validateForm() {
			
			var salida = false;
			if (document.getElementById("hiddenIdCliente").value == "")
				salida = false;
			if (document.getElementById("hiddenIdCamarero").value == "")
				salida = false;
			if (document.getElementById("idmesa").value == "")
				salida = false;
			if (document.getElementById("cantidadcomensales").value == "")
				salida = false;
			
			return salida; //Por las que devuelva falseo, se tira error http nº 500
		}
	</script>

	<form action="/Programa_Web/ocuparmesa" method="post" onsubmit="return validateForm()">
		<input type="hidden" id="hiddenIdCliente" name="idcliente" > 
		<input type="hidden" id="hiddenIdCamarero" name="idcamarero" >
		
		<h5>3.- Selección de mesa</h5>
		<select name="idmesa" >
			<%
				MesaABM abmMesa = new MesaABM();
				List<Mesa> listaMesas = abmMesa.traerMesas();
				for (Mesa mesa : listaMesas) {
					if (mesa.getEstado() == 0) {
					%>
						<option value="<%=mesa.getIdMesa()%>"><%="Nº "+mesa.getNroMesa()%></option>
					<%
				}}
			%>
		</select>	
		<br>
		<h5>4.- Cantidad de comensales</h5>
		<div class="mdl-textfield mdl-js-textfield">
			<input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="txtCantidadComensales" name="cantidadcomensales">
			<label class="mdl-textfield__label" for="sample2">Cantidad de comensales...</label>
			<span class="mdl-textfield__error">Lo ingresado no es un número!</span>
		</div>
		<br>
		<br>

		<!-- Accent-colored raised button with ripple -->
		<button id="btnRegistrarOcupacion"
			class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
			Registrar ocupación de mesa</button>
	</form>



</body>
</html>