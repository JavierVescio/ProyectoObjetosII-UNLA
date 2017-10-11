<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Restaurant</title>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.light_green-amber.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<LINK rel="stylesheet" href="global.css" />
<SCRIPT src="global.js" type="text/javascript"></SCRIPT>
</head>

<body>
	<div id="login-contenedor">
		<div class="mdl-layout mdl-js-layout mdl-color--grey-100">
			<main class="mdl-layout__content">
			<div class="mdl-card mdl-shadow--6dp">
				<div
					class="mdl-card__title mdl-color--primary mdl-color-text--white">
					<h2 class='mdl-card__title-text'>Ingresar al sistema</h2>
				</div>
				<div class="mdl-card__supporting-text">
					<form action="#">
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<input class='mdl-textfield__input' type='text' name='usuario'>
							<label class='mdl-textfield__label' for='usuario'>Usuario</label>
						</div>
						<div
							class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label'>
							<input class='mdl-textfield__input' type='password'
								name='password'> <label class='mdl-textfield__label'
								for='password'>Contraseña</label>
						</div>
					</form>
				</div>
				<div class="middle mdl-card__actions mdl-card--border ">
					<button
						class=" mdl-color--primary mdl-color-text--white mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
						Ingresar</button>
					<button
						class="left mdl-color--primary mdl-color-text--white mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
						Volver</button>
				</div>
			</div>
			</main>
		</div>

	</div>
	<div
		class="mdl-layout mdl-js-layout mdl-layout--fixed-header
      mdl-layout--fixed-tabs mdl-layout--fixed-drawer">
		<HEADER class="mdl-layout__header">
		<div id="login-area">

			<button id='login-button'
				class='mdl-button mdl-js-button mdl-button--icon'>
				<i class='material-icons'>input</i>
			</button>
		</div>
		</HEADER>
	</DIV>
	


</body>
</html>