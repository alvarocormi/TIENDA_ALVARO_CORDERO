<%@page import="curso.java.tienda.model.UsuarioVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="curso.java.tienda.dao.ProductoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List,curso.java.tienda.model.ProductoVO"%>
<%
session = request.getSession();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
	<h1>ESTA SERA LA PAGINA DE INICIO Y DE CATALOGO</h1>

	<a href="CarritoServlet"><i class="fas fa-shopping-cart"> <%
 Object totalCarrito = session.getAttribute("totalCarrito");

 out.println(totalCarrito != null ? totalCarrito : "");
 %>

	</i> </a>
	<a href="PerfilServlet"><i class="fas fa-user"></i></a>
	<%
	if (session.getAttribute("usuario") != null) {
		UsuarioVO u = (UsuarioVO) session.getAttribute("usuario");
		out.println(u.getEmail());
	}
	%>
	<form action="/TIENDA_ALVARO_CORDERO/" method="get">
        <label for="filtros">Filtar:</label>
        <select id="filtros" name="filtros">
            <option value="c.nombre">Categoria</option>
            <option value="p.precio">Precio</option>
            <option value="p.stock">Stock</option>
        </select>

        <input type="submit" value="Enviar">
    </form>
	<%
	List<ProductoVO> catalogo = (List<ProductoVO>) request.getAttribute("catalogo");

	for (ProductoVO producto : catalogo) {
	%>
	<h2>
		Descripcion:<%=producto.getDescripcion()%></h2>
	<h3>
		Nombre:<%=producto.getNombre()%></h3>
	<h3>
		Precio:<%=producto.getPrecio()%></h3>
	<h3>
		Stock:<%=producto.getStock()%></h3>
	<h3>
		Categoria:<%=producto.getIdCategoria()%></h3>

	<a href="AñadirProductoServlet?id=<%=producto.getId()%>">Comprar</a>
	<%
	}
	%>
</body>
</html>