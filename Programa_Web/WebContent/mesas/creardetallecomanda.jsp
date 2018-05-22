
<%@page import="negocio.Funciones"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="negocio.sectorPersonal.*"%>
<%@page import="negocio.sectorMesa.*"%>
<%@page import="datos.sectorPersonal.*"%>
<%@page import="datos.sectorMesa.*"%>
<%@page import="negocio.sectorProducto.*"%>
<%@page import="datos.sectorProducto.*"%>
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
	    var tableC = $('#tablaComanda').DataTable();
	    $('#tablaComanda tbody').on( 'click', 'tr', function () {
	    		tableC.$('tr.selected').removeClass('selected');
	        	$(this).addClass('selected');
	    	    var data = tableC.row(this).data();
	    	    document.getElementById("hiddenIdComanda").value = data[0];
	    } );
	    
	    var tableP = $('#tablaProducto').DataTable();
	    $('#tablaProducto tbody').on( 'click', 'tr', function () {
	    		tableP.$('tr.selected').removeClass('selected');
	        	$(this).addClass('selected');
	    	    data = tableP.row(this).data();
	    	    document.getElementById("hiddenIdProducto").value = data[0];
	    } );
	} );
	
</script>
<!--  -->
</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>
	
	<a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="/Programa_Web/administracion.jsp">Volver al menú principal</a>
	
	<div class="subtitulo">
		<!--Donde va el logo y el titulo-->
		<div class="container">
			<h3>Detalle de comanda</h3>
		</div>
	</div>
	
	<p class="error">
			<%String strMensajeError = (String)request.getAttribute("msgError"); 
			if (strMensajeError == null)
				strMensajeError = ""; //Si no se hace esto aca, se mostraria el texto 'null' siempre que no haya un msg de error
			%>
			<%=strMensajeError%>
	 </p>
	 
	 <p class="todobien">
	 		<%String strMensajeTodoBien = (String)request.getAttribute("msgTodoBien"); 
			if (strMensajeTodoBien == null)
				strMensajeTodoBien = ""; 
			%>
			<%=strMensajeTodoBien%>
	 </p>
	
	<h5>1.- Selección de comanda</h5>
	
	<div class="contenedortabla">
		<table id="tablaComanda">
			<thead>
				<tr>
					<th>ID</th>
					<th>Mesa Nº</th>
					<th>Cliente</th>
					<th>Camarero</th>
					<th>Cantidad comensales</th>
					<th>Horario apertura mesa</th>
					<th>Horario apertura comanda</th>
				</tr>
			</thead>
			<tbody>
				<%try{
					ComandaABM abmComanda = new ComandaABM();
					List<Comanda> listaComanda = abmComanda.traerComandas();
					for (Comanda comanda : listaComanda) {
						OcupacionMesa ocupacionMesa = comanda.getOcupacionMesa();
						Cliente cliente = ocupacionMesa.getCliente();
						Personal camarero = ocupacionMesa.getCamarero();
						Mesa mesa = ocupacionMesa.getMesa();
						String fecha_hora_inicio_ocupacion = Funciones.traerFechaLarga(ocupacionMesa.getFechaHoraInicio()) + " - " + Funciones.traerHorario(ocupacionMesa.getFechaHoraInicio());
						String fecha_hora_inicio_comanda = Funciones.traerFechaLarga(comanda.getFechaHora()) + " - " + Funciones.traerHorario(comanda.getFechaHora());
				%><tr>
					<td><%=comanda.getIdComanda()%></td>
					<td><%=mesa.getNroMesa()%></td>
					<td><%=cliente.getApellido() + " " + cliente.getNombre()%></td>
					<td><%=camarero.getApellido() + " " + camarero.getNombre()%></td>
					<td><%=ocupacionMesa.getCantidadComensales()%></td>
					<td><%=fecha_hora_inicio_ocupacion%></td>
					<td><%=fecha_hora_inicio_comanda%></td>
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
	
	<h5>2.- Selección de producto</h5>
	
	<div class="contenedortabla">
		<table id="tablaProducto">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Nota</th>
				</tr>
			</thead>
			<tbody>
				<%
				try{
					ProductoABM abmProducto = new ProductoABM();
					List<Producto> listaProducto = abmProducto.traerProductos();
					for (Producto producto : listaProducto) {
						String infoPlatoBebida = "";
						if (producto instanceof Plato){
							infoPlatoBebida = "Plato " + ((Plato)producto).getNotas();
						}else{
							infoPlatoBebida = "Bebida " + ((Bebida)producto).getNotas();
						}
				%><tr>
					<td><%=producto.getIdProducto()%></td>
					<td><%=producto.getNombre()%></td>
					<td><%=producto.getDescripcion()%></td>
					<td><%=infoPlatoBebida%></td>
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

	<form action="/Programa_Web/creardetallecomanda" method="post">
		<input id="hiddenIdComanda" type="hidden" name="idcomanda" value="-1">
		<input id="hiddenIdProducto" type="hidden" name="idproducto" value="-1">
		
		<h5>3.- Cantidad pedida</h5>
		
		<div class="mdl-textfield mdl-js-textfield">
			<input class="mdl-textfield__input" type="text"
				pattern="-?[0-9]*(\.[0-9]+)?" id="sample2" name="cantidad" value="1">
			<label class="mdl-textfield__label" for="sample2">Cantidad...</label> <span class="mdl-textfield__error">Lo
				ingresado no es un número!</span>
		</div>

		<br>
		<!-- Accent-colored raised button with ripple -->
		<button
			class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
			Nuevo detalle de comanda</button>
	</form>
</body>
</html>