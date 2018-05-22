<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

$(document).ready( function () {
    $('#datatable').DataTable();
} );
	
</script>
<!--  -->

</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>

<a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="/Programa_Web/administracion.jsp">Volver al menú principal</a>

	<div class="mdl-grid center-items">
		<div class="mdl-cell mdl-cell--4-col">
			<h2 class="mdl-card__title-text">CONSULTA DE PRODUCTOS</h2>

		</div>
	</div>

	<div class="contenedortabla">
		<table id="datatable">
			<thead>
				<tr>
					<th>ID Producto</th>
					<th>Tipo</th>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Nota</th>
				</tr>
			</thead>
			<tbody>
				<%try{
					ProductoABM abmProducto = new ProductoABM();
					List<Producto> lista = abmProducto.traerProductos();
					for (Producto producto : lista) {
						String tipo = "Plato";
						String nota = "";
						if (producto instanceof Bebida){
							tipo = "Bebida";
							nota = ((Bebida)producto).getNotas();
						}else {
							nota = ((Plato)producto).getNotas();
						}
				%><tr>
					<td><%=producto.getIdProducto()%></td>
					<td><%=tipo%>
					<td><%=producto.getNombre()%></td>
					<td><%=producto.getDescripcion()%></td>
					<td><%=nota%>
				</tr>
				<%
					}
				}catch(Exception e){
					
				}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>