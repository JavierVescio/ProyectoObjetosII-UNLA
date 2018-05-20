<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
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
  	
  	<a href="/Programa_Web/administracion.jsp">Volver al menú principal</a>
  
      <div class="mdl-grid center-items">
         <div class="mdl-cell mdl-cell--4-col">
         <h2 class="mdl-card__title-text">ALTA DE PLATO</h2>
            <form action="/Programa_Web/altaplato" method="post">
               <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input class="mdl-textfield__input" type="text" id="sample3" name="nombreProducto">
                  <label class="mdl-textfield__label" for="sample3">Nombre producto</label>
               </div>
               <div class="mdl-textfield mdl-js-textfield">
                  <textarea class="mdl-textfield__input" type="text" rows= "3" id="sample5" name="descripcionProducto"></textarea>
                  <label class="mdl-textfield__label" for="sample5">Descripción producto (opcional)</label>
               </div>
               <div class="mdl-textfield mdl-js-textfield">
                  <textarea class="mdl-textfield__input" type="text" rows= "3" id="sample5" name="notasPlato"></textarea>
                  <label class="mdl-textfield__label" for="sample5">Nota plato (opcional)</label>
               </div>
               
               <div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text"
						id="sample2" name="precio" value="">
				<label class="mdl-textfield__label" for="sample2">Precio...</label>
				</div>
               
               <br>
               <!-- Accent-colored raised button with ripple -->
				<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
				  Agregar plato
				</button>
            </form>
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
		
   </body>
</html>