$(document)
		.ready(
				function() {

//					$('#consultar').click(function() {
//						var dni = $('#dni').val();
//						var loginData = {
//								'user' : $('input[name=usuario]',
//										this).val(),
//								'pass' : $('input[name=password]',
//										this).val(),
//							};
//						$.ajax({
//							method : "POST",
//							url : "ControladorLogIn",
//							data : loginData,
//							async : false
//						}).done(function(data) {
//							$("#responsecliente").html(data);
//						})
//					});

					// ******************************************************************************
					// â–º Func : Cambia dinamicamente la url al hacer click en
					// los distintos tabs
					// â–º Obser:
					// â–º ToDo : Determinar que hacer si el navegador no
					// soporta HTML5
					// ******************************************************************************
					// $(".mdl-layout__tab").click(function() {
					// tab = $(this).attr("id");
					// var obj = { Page: 'Gestion Campus', Url: tab };
					// history.pushState(obj, obj.Page, obj.Url);
					// });

					// *******************************************************************************
					// â–º Func : Despliega el dialogo de login normal
					// â–º Obser:
					// â–º ToDo :
					// ******************************************************************************

					// *******************************************************************************
					// â–º Func : Despliega el dialogo de login forzado si el
					// usuario intenta enviar
					// un formulario sin estar loggedo
					// â–º Obser:
					// â–º ToDo :
					// ********************************************************************************

					// *******************************************************************************
					// â–º Func : Desvanece el modal y los formularios de login
					// al hacer click en
					// cualquier parte
					// â–º Obser:
					// â–º ToDo :
					// ********************************************************************************

					// *******************************************************************************
					// â–º Func : Agrega la funcion de submit a los formularios
					// de login
					// â–º Obser:
					// â–º ToDo :
//					// ********************************************************************************
//					$('#loginarea')
//							.on(
//									'submit',
//									'.js-login',
//									function(event) {
//										event.preventDefault();
//										var loginData = {
//											'user' : $('input[name=usuario]',
//													this).val(),
//											'pass' : $('input[name=password]',
//													this).val(),
//										};
//										$
//												.ajax(
//														{
//															type : 'POST', // define
//															// the
//															// type
//															// of
//															// HTTP
//															// verb
//															// we
//															// want
//															// to
//															// use
//															// (POST
//															// for
//															// our
//															// form)
//															url : '/Gestion/Login/log_in', // the
//															// url
//															// where
//															// we
//															// want
//															// to
//															// POST
//															data : loginData, // our
//														// data
//														// object
//														})
//												.done(
//														function(data) {
//															if (data != 0) {
//																$(
//																		'.mdl-layout__header-row')
//																		.find(
//																				"#login-button")
//																		.remove();
//																$("#login-area")
//																		.append(
//																				stringToMDL(data));
//																$("#modal")
//																		.trigger(
//																				"click");
//															} else {
//																mensajeError = "Error, intente nuevamente";
//																$(
//																		".mensaje-error")
//																		.html(
//																				mensajeError)
//																		.slideDown(
//																				'normal')
//																		.delay(
//																				3000)
//																		.slideUp(
//																				'normal');
//															}
//														});
//									});

					// *******************************************************************************
					// â–º Func : transforma un string html en DOM con los
					// eventos MDL asociados
					// â–º Obser:
					// â–º ToDo :
					// ********************************************************************************
					// window.stringToMDL = function(str){
					// var html = $.parseHTML(str);
					// $('*', $(html)).each(function () {
					// componentHandler.upgradeElement(this);
					// });
					// return html;
					// };
				});