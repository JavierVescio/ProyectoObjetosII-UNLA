
<%@page import="negocio.Funciones"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="negocio.sectorPersonal.*"%>
<%@page import="negocio.sectorMesa.*"%>
<%@page import="datos.sectorPersonal.*"%>
<%@page import="datos.sectorMesa.*"%>
<%@page import="negocio.sectorProducto.*"%>
<%@page import="datos.sectorProducto.*"%>
<%@page import="java.util.Set" %>	
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
	    	    document.getElementById("btnVerDetalleComanda").disabled = false;
	    } );
	} );
	
</script>
<!--  -->



</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>

	<div class="subtitulo">
		<!--Donde va el logo y el titulo-->
		<div class="container">
			<h3>Ver comanda</h3>
		</div>
	</div>

	<h5>Selección de comanda</h5>
	
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

			<form action="/Programa_Web/vercomanda" method="post">
				<input type="hidden" id="hiddenIdComanda" name="idcomanda">
				<br>
				<!-- Accent-colored raised button with ripple -->
				<button id="btnVerDetalleComanda"  disabled
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
					Ver detalle/s de comanda</button>
			</form>
			
	<ul id="lista">
		<li>
			<%Comanda comanda = (Comanda)request.getAttribute("comanda"); 
			if (comanda != null) { %>
			<h3>COMANDA Nº <%=comanda.getIdComanda()%> - MESA Nº <%=comanda.getOcupacionMesa().getMesa().getNroMesa() %></h3>
		</li>
		<%Set<DetalleComanda> detalles = comanda.getDetalleComandas();
		for(DetalleComanda detalleComanda:detalles){%>
			<li>
				ID Detalle Comanda: <%=detalleComanda.getIdDetalleComanda()%><br>
				Precio: $<%=detalleComanda.getPrecio()%><br>
				<%if(detalleComanda.getProducto() instanceof Bebida){
						Bebida bebida = (Bebida)detalleComanda.getProducto();%>
						Bebida: <%=detalleComanda.getProducto().getNombre()%><br>
						Descripción: <%=bebida.getDescripcion()%><br>
				<%}else if (detalleComanda.getProducto() instanceof Plato){
						Plato plato = (Plato)detalleComanda.getProducto();%>
						Plato: <%=detalleComanda.getProducto().getNombre()%><br>
						Descripción: <%=plato.getDescripcion()%><br><%
				}%>
				Cantidad: <%=detalleComanda.getCantidad()%><br>
			</li>
		<%}}%>
	</ul>
</body>
</html>