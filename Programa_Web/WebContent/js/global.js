/**
 * 
 */
$(document).ready(function(){

	// ******************************************************************************
	// â–º Func : Carga la pagina que corresponda segun un el modulo y el Tab
	// â–º Obser: 
	// â–º ToDo :
	// ******************************************************************************
	 window.loadPage = function(modulo, tab){
	 	$("#"+modulo).addClass('current-module');
	 	$('.mdl-layout__tab').removeClass('is-active');
	 	$('section').removeClass('is-active');
		$("#"+tab).addClass('is-active');
		var href = $("#"+tab).attr('href');
		$(href).addClass('is-active');
	};

	// *******************************************************************************
	// â–º Func : Extrae el modulo y el TAB de la URL para cargar la pagina 
	//					y llama a loadPage
	// â–º Obser:
	// â–º ToDo : 
	// *******************************************************************************
	var match = location.pathname.split('/');
	loadPage(match[2 /*modulo*/],match[3 /*tab*/]);

	// *******************************************************************************
	// â–º Func : Llama a la funcion loadPage al activarse el evento popstate
	// â–º Obser: El evento popstate se dispara al hacer click en las flechas de 
	// 				  avanzar y retroceder de la ventana del navegador.
	// â–º ToDo : 
	// *******************************************************************************
	$(window).bind("popstate", function() {
		var match = location.pathname.split('/');
		loadPage(match[2 /*modulo*/],match[3 /*tab*/]);
	});

	// ******************************************************************************
	// â–º Func : Cambia dinamicamente la url al hacer click en los distintos tabs
	// â–º Obser:
	// â–º ToDo : Determinar que hacer si el navegador no soporta HTML5
	// ******************************************************************************
	$(".mdl-layout__tab").click(function() {
		tab = $(this).attr("id");
		var obj = { Page: 'GestiÃ³n Campus', Url: tab };
		history.pushState(obj, obj.Page, obj.Url);
	});

	// *******************************************************************************
	// â–º Func : Despliega el dialogo de login normal
	// â–º Obser:
	// â–º ToDo :
	// ******************************************************************************
	$("#login-button").click(function(){
			$("#modal").fadeIn('fast');
			$("#login-normal").fadeIn('fast');
	});

	// *******************************************************************************
	// â–º Func : Despliega el dialogo de login forzado si el usuario intenta enviar
	//					un formulario sin estar loggedo
	// â–º Obser:
	// â–º ToDo :
	// ********************************************************************************
	$(".js-login-require").click(function(event){
		var form = $(event.target).closest("form");
		event.preventDefault();

		//chequeamos si el usuario se encuentra loggeado en el sistema
		$.post( "../Login/isLogged", function( data ) {
			if(data == false){
				  	$("#modal").fadeIn('fast');
				  	$("#login-forzado").fadeIn('fast');
			}else{
					$(form).submit();
			}
		});
	});

	// *******************************************************************************
	// â–º Func : Desvanece el modal y los formularios de login al hacer click en 
	//					cualquier parte
	// â–º Obser:
	// â–º ToDo :
	// ********************************************************************************
	$('#login-contenedor').on('click','#modal' ,function(event) {
			$("#modal").fadeOut('fast');
			$("#login-normal").fadeOut('fast');
			$("#login-forzado").fadeOut('fast');
	});

	// *******************************************************************************
	// â–º Func : Agrega la funcion de submit a los formularios de login
	// â–º Obser:
	// â–º ToDo :
	// ********************************************************************************
	$('#login-normal, #login-forzado').on('submit','.js-login' ,function(event) {
		event.preventDefault();
		var loginData = {
		    'user'   : $('input[name=usuario]', this).val(),
		    'pass'   : $('input[name=password]',this).val(),
		  };
		$.ajax({
		    type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
		    url         : '/Gestion/Login/log_in', // the url where we want to POST
		    data        : loginData, // our data object
		})
		.done(function(data) {
			if(data != 0)
			{
					$('.mdl-layout__header-row').find("#login-button").remove();
					$( "#login-area" ).append(stringToMDL(data));
					$( "#modal" ).trigger("click");
			}else{
					mensajeError = "Error, intente nuevamente";
					$(".mensaje-error").html(mensajeError).slideDown('normal').delay(3000).slideUp('normal');
			}
		});
	});

	// *******************************************************************************
	// â–º Func : transforma un string html en DOM con los eventos MDL asociados
	// â–º Obser:
	// â–º ToDo :
	// ********************************************************************************
	window.stringToMDL = function(str){
		var html = $.parseHTML(str);
		$('*', $(html)).each(function () {
			componentHandler.upgradeElement(this);
		});
		return html;
	};
});