
$(document).ready(function() {
	
	$('#btn-ingresar').click(function() {

		var usuario = $('#usuario').val();
		var password = $('#password').val();
		if (usuario==''||password=='') {
			mensajeError = "Por favor complete los campos";
			$(".mensaje-error").html(mensajeError).slideDown('normal').delay(3000).slideUp('normal');
	
		} else {
			$.ajax({
				method : "POST",
				url : "login",
				data : {
					usuario : usuario,
					password : password
				},
				async : false
			}).success(function(data) {
				$("#loginarea").empty();
				$("#contenido").html(data);
				/*window.location.replace("/Programa_Web/administracion.jsp");*/
		
			})
			.fail(function(jqXHR,textStatus,errorThrown) {
				mensajeError = "Usuario o Contrasenia Incorrecta";
				$(".mensaje-error").html(mensajeError).slideDown('normal').delay(3000).slideUp('normal');
		
			})
	}

	});
	$('#agregarPlato').click(function() {

		var nombre = $('#nombre').val();
		var descripcion  = $('#descripcion').val();
		var nota  = $('#nota').val();
		if (nombre=='') {
			mensajeError = "Por favor complete los campos";
			$(".mensaje-error").html(mensajeError).slideDown('normal').delay(3000).slideUp('normal');
	
		} else {
			$.ajax({
				method : "POST",
				url : "login",
				data : {
					usuario : usuario,
					password : password
				},
				async : false
			}).success(function(data) {
				$("#loginarea").empty();
				$("#contenido").html(data);
				/*window.location.replace("/Programa_Web/administracion.jsp");*/
		
			})
			.fail(function(jqXHR,textStatus,errorThrown) {
				mensajeError = "Usuario o Contrasenia Incorrecta";
				$(".mensaje-error").html(mensajeError).slideDown('normal').delay(3000).slideUp('normal');
		
			})
	}

	});

});