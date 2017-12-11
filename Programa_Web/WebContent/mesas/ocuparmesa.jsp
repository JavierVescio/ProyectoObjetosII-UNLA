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
  
       <div class="mdl-grid center-items">
         <div class="mdl-cell mdl-cell--4-col">
         <h2 class="mdl-card__title-text">OCUPACION DE MESA</h2>
         
            <form action="/Programa_Web/ocuparmesa" method="post">
            
            <!-- 			int idcliente = Integer.getInteger(request.getParameter("idcliente"));
			int idmesa = Integer.getInteger(request.getParameter("idmesa"));
			int cantidadcomensales = Integer.getInteger(request.getParameter("cantidadcomensales")); -->
            
               <div class="mdl-textfield mdl-js-textfield">
			    <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2" name="idcliente">
			    <label class="mdl-textfield__label" for="sample2">ID Cliente...</label>
			    <span class="mdl-textfield__error">Lo ingresado no es un número!</span>
			  </div>
               
              <div class="mdl-textfield mdl-js-textfield">
			    <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2" name="idcamarero">
			    <label class="mdl-textfield__label" for="sample2">ID Camarero...</label>
			    <span class="mdl-textfield__error">Lo ingresado no es un número!</span>
			  </div>
               
               <div class="mdl-textfield mdl-js-textfield">
			    <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2" name="idmesa">
			    <label class="mdl-textfield__label" for="sample2">ID Mesa...</label>
			    <span class="mdl-textfield__error">Lo ingresado no es un número!</span>
			  </div>
               
                <div class="mdl-textfield mdl-js-textfield">
			    <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2" name="cantidadcomensales">
			    <label class="mdl-textfield__label" for="sample2">Cantidad de comensales...</label>
			    <span class="mdl-textfield__error">Lo ingresado no es un número!</span>
			  </div>
               
               <br>
               <!-- Accent-colored raised button with ripple -->
				<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
				  Registrar ocupación de mesa
				</button>
            </form>
            
         </div>
      </div>
   </body>
</html>