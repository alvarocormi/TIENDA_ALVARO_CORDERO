<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="curso.java.tienda.model.UsuarioVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="curso.java.tienda.dao.ProductoDAO"%>
<%@ page import="java.util.List,curso.java.tienda.model.ProductoVO"%>
<!doctype html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="Alvaro Cordero Miñambres" content="Untree.co">
<link rel="shortcut icon" href="favicon.png">

<meta name="description" content="Alvaro Cordero Miñambres Serbatic Web" />
<meta name="keywords" content="bootstrap, bootstrap4" />

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<link href="css/tiny-slider.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Alvaro Cordero Miñambres - Serbatic Web</title>
</head>

<body>

	<!-- Start Header/Navigation -->
	<nav
		class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark"
		arial-label="Furni navigation bar">

		<div class="container">
			<a class="navbar-brand" href="/TIENDA_ALVARO_CORDERO/">Amuebla</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarsFurni"
				aria-controls="navbarsFurni" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsFurni">
				<ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link"
						href="/TIENDA_ALVARO_CORDERO/">Inicio</a></li>
					<li><a class="nav-link" href="TiendaServlet">Tienda</a></li>
					<li><a class="nav-link" href="ContactServlet">Contactar</a></li>
				</ul>

				<ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
					<li><a class="nav-link" href="PerfilServlet"><img
							src="images/user.svg"> <%
 if (session.getAttribute("usuario") != null) {
 	UsuarioVO u = (UsuarioVO) session.getAttribute("usuario");
 	out.println(u.getEmail());
 }
 %> </a></li>
					<%
					if (session.getAttribute("usuario") != null) {
						UsuarioVO u = (UsuarioVO) session.getAttribute("usuario");
					
					%>
					<li style="padding: 0; margin-top: 10px; margin-right: 15px"><a href="LogoutServlet"><i
							class="fas fa-sign-out-alt fa-inverse fa-lg"></i></a></li>

					<%} %>
					<li><a class="nav-link" href="CarritoServlet"> <img
							src="images/cart.svg"> <%
 Map<ProductoVO, Integer> carrito = (Map<ProductoVO, Integer>) request.getSession().getAttribute("carrito");

 out.println(carrito != null ? carrito.size() : "");
 %>
					</a></li>
				</ul>
			</div>
		</div>

	</nav>