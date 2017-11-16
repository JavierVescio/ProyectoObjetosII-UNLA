<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<!-- Codificacion de texto para que se puedan utilizar caracteres especiales -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- tag de titulo -->
<TITLE>Gesti�n Restaurant</TITLE>
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
<LINK rel="stylesheet" href="/Programa_Web/css/global.css" />
</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>
 <main>
        <style>
        </style>
        <div class="banner-index">
        </div>
        <div class="mdl-grid card-centered">
          <div class="mdl-cell mdl-cell--3-col mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title comandas">
              <h2 class="mdl-card__title-text">
                Comandas
              </h2>
            </div>
            <div class="mdl-card__supporting-text">
             Gesti�n de pedidos y estados de comandas 
            </div>
            <div class="mdl-card__actions mdl-card--border">
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/Comandas">
              Ver Comandas
              </a>
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/BuscarComanda">
              Buscar una Comanda
              </a>
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/CrearComanda">
              Crear una Comanda
              </a>              
            </div>
          </div>
          <div class="mdl-cell mdl-cell--3-col mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title salon">
              <h2 class="mdl-card__title-text">
                Salon
              </h2>
            </div>
            <div class="mdl-card__supporting-text">
              Administracion e informes del estado del salon
            </div>
            <div class="mdl-card__actions mdl-card--border">
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/EstadoSalon">
              Estado de salon
              </a>
              <span class="split">
              </span>
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/VerMapa">
              Ver mapa(layout)
              </a>
              <span class="split">
              </span>
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/AcomodarClientes">
              Acomodar clientes(punto 20)
              </a>
            </div>
          </div>
          <div class="mdl-cell mdl-cell--3-col mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title facturacion">
              <h2 class="mdl-card__title-text">
                Facturacion
              </h2>
            </div>
            <div class="mdl-card__supporting-text">
              Administracion, Consultas y generacion de tickets
            </div>
            <div class="mdl-card__actions mdl-card--border">
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect middle" href="/GenerarTicket" title="Pr�ximamente">
              Generar ticket
              </a>
              <span class="split">
              </span>
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect middle" href="/GenerarPreTicket" title="Pr�ximamente">
              Generar pre-ticket
              </a>
              <span class="split">
              </span>
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect middle" href="/ConsultarTicket" title="Pr�ximamente">
              Consultar ticket
              </a>
            </div>
          </div>
          <div class="mdl-cell mdl-cell--3-col mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title otros">
              <h2 class="mdl-card__title-text">
                Otros
              </h2>
            </div>
            <div class="mdl-card__supporting-text">
              Cosas a agregar
            </div>
            <div class="mdl-card__actions mdl-card--border">
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect middle" href="" title="Pr�ximamente">
              otros
              </a>
              <span class="split">
              </span>
              <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect middle" href="" title="Pr�ximamente">
             otros
              </a>
            </div>
          </div>
        </div>

</body>
</html>