<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="datos.sectorMesa.*" %>
<%@page import="java.util.Set" %>	
	
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
</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>

	<ul id="lista">
		<li>
			<%Comanda comanda = (Comanda)request.getAttribute("comanda"); %>
			<h3>COMANDA Nº <%=comanda.getIdComanda()%></h3>
			<p><%=comanda.toString() %></p>
		</li>
		<%Set<DetalleComanda> detalles = comanda.getDetalleComandas();
		for(DetalleComanda detalleComanda:detalles){%>
			<li>
				ID Detalle Comanda: <%=detalleComanda.getIdDetalleComanda()%><br>
				Precio: $<%=detalleComanda.getPrecio()%><br>
				Cantidad: <%=detalleComanda.getCantidad()%><br>
			</li>
		<%}%>
	</ul>

</body>
</html>