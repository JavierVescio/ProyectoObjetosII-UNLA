<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   
<%@page import="negocio.Funciones"%>
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
	    var tableC = $('#tablaComanda').DataTable({
            "dom": 'T<"clear">lfrtip',
            "tableTools": {
                "sRowSelect": "multi",
                "aButtons": [
                    {
                        "sExtends": "select_none",
                        "sButtonText": "Borrar selección"
                    }]
            },"ordering": true,
            "pagingType": "simple_numbers",
//Actualizo las etiquetas de mi tabla para mostrarlas en español
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por página.",
                "zeroRecords": "No se encontró registro.",
                "info": "  _START_ de _END_ (_TOTAL_registros totales).",
                "infoEmpty": "0 de 0 de 0 registros",
                "infoFiltered": "(Encontrado de _MAX_registros)",
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
	    $('#tablaComanda tbody').on( 'click', 'tr', function () {
	    		tableC.$('tr.selected').removeClass('selected');
	        	$(this).addClass('selected');
	    	    var data = tableC.row(this).data();
	    	    document.getElementById("hiddenIdComanda").value = data[0];
	    } );
	    
	    var tableD = $('#tablaCamarero').DataTable({
            "dom": 'T<"clear">lfrtip',
            "tableTools": {
                "sRowSelect": "multi",
                "aButtons": [
                    {
                        "sExtends": "select_none",
                        "sButtonText": "Borrar selección"
                    }]
            },"ordering": true,
            "pagingType": "simple_numbers",
//Actualizo las etiquetas de mi tabla para mostrarlas en español
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por página.",
                "zeroRecords": "No se encontró registro.",
                "info": "  _START_ de _END_ (_TOTAL_registros totales).",
                "infoEmpty": "0 de 0 de 0 registros",
                "infoFiltered": "(Encontrado de _MAX_registros)",
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
	    $('#tablaCamarero tbody').on( 'click', 'tr', function () {
	    		tableD.$('tr.selected').removeClass('selected');
	        	$(this).addClass('selected');
	    	    var data = tableD.row(this).data();
	    	    document.getElementById("hiddenIdPersonal").value = data[0];
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
			<h3>Generar Ticket</h3>
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
				<%
				try{
					ComandaABM abmComanda = new ComandaABM();
					List<Comanda> listaComanda = abmComanda.traerComandasAptasParaGenerarTicket();
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
      
      
      	<h5>2.- Selección de cajero</h5>
	
	
	<div class="contenedortabla">
		<table id="tablaCamarero">
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
					List<Personal> listaPersonal = abmPersona.traerCamareros();
					for (Personal personal : listaPersonal) {
				%><tr>
					<td><%=personal.getIdPersona()%></td>
					<td><%=personal.getApellido()%></td>
					<td><%=personal.getNombre()%></td>
					<td><%=personal.getDni()%></td>
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
  

            <form action="/Programa_Web/generarticket" method="post">
            	<input type="hidden" id="hiddenIdComanda" name="idcomanda" value = "-1"> 
				<input type="hidden" id="hiddenIdPersonal" name="idpersonal" value = "-1"> 
               
               <br>
               <!-- Accent-colored raised button with ripple -->
				<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent bt-form">
				  Generar ticket
				</button>
            </form>
            
   </body>
</html>