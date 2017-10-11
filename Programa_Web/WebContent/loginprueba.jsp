<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Restaurant</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.light_green-amber.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script type="text/javascript" language="JavaScript">
	function carga() {
		document.getElementById("usuario").focus();
	}

	function valideDatos() {
		var usuario = document.getElementById("usuario");
		var password = document.getElementById("password");
		if ((usuario.value == "" || usuario.value == '' || usuario.value == null)
				&& (password.value == "" || password.value == '' || password.value == null)) {
			alert("Ingrese el usuario y la contraseña");
			usuario.focus();
			return false;
		} else if (usuario.value == "" || usuario.value == ''
				|| usuario.value == null) {
			alert("Ingrese el Usuario");
			usuario.focus();
			return false;
		} else if (password.value == "" || password.value == ''
				|| password.value == null) {
			alert("Ingrese la Contraseña");
			password.focus();
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body>
<center>
	<div class='mdl-card__title mdl-card--expand'>
		<h2 class='mdl-card__title-text'>Ingresar al sistema</h2>
	</div>
	<form action="loginWeb.jr" method="POST"
		onsubmit="return valideDatos();">

		<div
			class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label'>
			<input class='mdl-textfield__input' type='text' name='usuario'>
			<label class='mdl-textfield__label' for='usuario'>Usuario</label>
		</div>
		<div
			class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label'>
			<input class='mdl-textfield__input' type='password' name='password'>
			<label class='mdl-textfield__label' for='password'>Contraseña</label>
		</div>
		<button
			class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
			Ingresar</button>



	</form>
</center>
</body>
</html>