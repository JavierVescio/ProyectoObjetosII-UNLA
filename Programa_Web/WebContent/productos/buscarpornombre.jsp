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
					<th>Nombre</th>
					<th>Descripcion</th>
				</tr>
			</thead>
			<tbody>
				<%
					ProductoABM abmProducto = new ProductoABM();
					List<Producto> lista = abmProducto.traerProductos();
					for (Producto producto : lista) {
				%><tr>
					<td><%=producto.getIdProducto()%></td>
					<td><%=producto.getNombre()%></td>
					<td><%=producto.getDescripcion()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>