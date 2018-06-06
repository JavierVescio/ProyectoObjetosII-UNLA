
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
	    var tableC = $('#tablaTicket').DataTable({
            "dom": 'T<"clear">lfrtip',
            "tableTools": {
                "sRowSelect": "multi",
                "aButtons": [
                    {
                        "sExtends": "select_none",
                        "sButtonText": "Borrar selección"
                    }]
            },
            "pagingType": "simple_numbers",
//Actualizo las etiquetas de mi tabla para mostrarlas en español
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por página.",
                "zeroRecords": "No se encontró registro.",
                "info": "  _START_ de _END_ (_TOTAL_ registros totales).",
                "infoEmpty": "0 de 0 de 0 registros",
                "infoFiltered": "(Encontrado de _MAX_ registros)",
                "search": "Buscar: ",
                "processing": "Procesando la información",
                "paginate": {
                    "first": " |< ",
                    "previous": "Ant.",
                    "next": "Sig.",
                    "last": " >| "
                }
            }
        });
	    $('#tablaTicket tbody').on( 'click', 'tr', function () {
	    		tableC.$('tr.selected').removeClass('selected');
	        	$(this).addClass('selected');
	    	    var data = tableC.row(this).data();
	    	    document.getElementById("hiddenIdTicket").value = data[0];
	    	    document.getElementById("btnVerDetalleTicket").disabled = false;
	    } );
	} );
	
</script>
<!--  -->


</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>

	<a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent bt_nav" href="/Programa_Web/administracion.jsp">Volver</a>

	<div class="subtitulo">
		<!--Donde va el logo y el titulo-->
		<div class="container">
			<h3>Ver ticket</h3>
		</div>
	</div>

	<h5>Selección de ticket</h5>
	
	<div class="contenedortabla">
		<table id="tablaTicket">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nro mesa</th>
					<th>Cliente</th>
					<th>Camarero</th>
					<th>Cajero</th>
					<th>Comensales</th>
					<th>Hra apertura</th>
					<th>Hra cierre</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<%try{
					TicketABM abmTicket = new TicketABM();
					List<Ticket> listaTicket = abmTicket.traerTickets(); 
					for (Ticket ticket : listaTicket) {
						Personal cajero = ticket.getPersonal();
						Comanda comanda = ticket.getComanda();
						OcupacionMesa ocupacionMesa = comanda.getOcupacionMesa();
						Cliente cliente = ocupacionMesa.getCliente();
						Personal camarero = ocupacionMesa.getCamarero();
						Mesa mesa = ocupacionMesa.getMesa();
						String fecha_hora_inicio_ocupacion = Funciones.traerFechaLarga(ocupacionMesa.getFechaHoraInicio()) + " - " + Funciones.traerHorario(ocupacionMesa.getFechaHoraInicio());
						String fecha_hora_fin_ocupacion = Funciones.traerFechaLarga(ocupacionMesa.getFechaHoraFin()) + " - " + Funciones.traerHorario(ocupacionMesa.getFechaHoraFin());
				%><tr>
					<td><%=ticket.getIdTicket()%></td>
					<td><%=mesa.getNroMesa()%></td>
					<td><%=cliente.getApellido() + " " + cliente.getNombre()%></td>
					<td><%=camarero.getApellido() + " " + camarero.getNombre()%></td>
					<td><%=cajero.getApellido() + " " + cajero.getNombre()%></td>
					<td><%=ocupacionMesa.getCantidadComensales()%></td>
					<td><%=fecha_hora_inicio_ocupacion%></td>
					<td><%=fecha_hora_fin_ocupacion%></td>
					<td>$ <%=ticket.getImporteTotal()%></td>
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
		

	<form action="/Programa_Web/verticket" method="get">
		<input type="hidden" id="hiddenIdTicket" name="idticket">

		<br>
		<!-- Accent-colored raised button with ripple -->
		<button id="btnVerDetalleTicket" disabled
			class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent bt-form">
			Ver detalle del ticket</button>
	</form>
	<br>
	<br>
	<ul id="lista">
		<li>
			<%Ticket ticket = (Ticket)request.getAttribute("ticket");
			if (ticket != null) { 
				Comanda comanda = ticket.getComanda(); %>
				<h3>TICKET Nº <%=ticket.getIdTicket()%> - COMANDA Nº <%=comanda.getIdComanda() %></h3>
				Mesa Nº: <%=comanda.getOcupacionMesa().getMesa().getNroMesa()%>
				<br>Importe total: $ <%=ticket.getImporteTotal()%>
		</li>
		<%Set<DetalleComanda> detalles = comanda.getDetalleComandas();
		for(DetalleComanda detalleComanda:detalles){%>
			<li>
				ID Detalle Comanda: <%=detalleComanda.getIdDetalleComanda()%><br>
				<%if(detalleComanda.getProducto() instanceof Bebida){
						Bebida bebida = (Bebida)detalleComanda.getProducto();%>
						Bebida: <%=detalleComanda.getProducto().getNombre()%><br>
						Descripción: <%=bebida.getDescripcion()%><br>
				<%}else if (detalleComanda.getProducto() instanceof Plato){
						Plato plato = (Plato)detalleComanda.getProducto();%>
						Plato: <%=detalleComanda.getProducto().getNombre()%><br>
						Descripción: <%=plato.getDescripcion()%><br><%
				}%>
				Precio: $<%=detalleComanda.getPrecio()%><br>
				Cantidad: <%=detalleComanda.getCantidad()%><br>
				Total: $<%=detalleComanda.getPrecio()*detalleComanda.getCantidad()%><br>
			</li>
		<%}}%>
	</ul>

</body>
</html>