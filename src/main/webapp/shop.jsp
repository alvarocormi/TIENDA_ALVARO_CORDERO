<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%
session = request.getSession();
%>
<div class="hero">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-5">
				<div class="intro-excerpt">
					<h1>Tienda</h1>
				</div>
			</div>
			<div class="col-lg-7"></div>
		</div>
	</div>
</div>
<div class="untree_co-section product-section before-footer-section">
	<form action="TiendaServlet" method="get">
    <label for="filtros">Filtrar:</label>
    <select id="filtros" name="filtros">
        <option value="c.nombre" <%= (request.getParameter("filtros") != null && request.getParameter("filtros").equals("c.nombre")) ? "selected" : "" %>>Categoria</option>
        <option value="p.precio" <%= (request.getParameter("filtros") != null && request.getParameter("filtros").equals("p.precio")) ? "selected" : "" %>>Precio</option>
        <option value="p.stock" <%= (request.getParameter("filtros") != null && request.getParameter("filtros").equals("p.stock")) ? "selected" : "" %>>Stock</option>
    </select>
    <input type="submit" value="Enviar">
</form>

	<div class="container">

		<div class="row">
			<%
			List<ProductoVO> catalogo = (List<ProductoVO>) request.getAttribute("catalogo");

			for (ProductoVO producto : catalogo) {
			%>

			<!-- Start Column 1 -->
			<div class="col-12 col-md-4 col-lg-3 mb-5">
				<a class="product-item" href="AñadirProductoServlet?id=<%=producto.getId()%>"> <img
					src="images/product-3.png" class="img-fluid product-thumbnail">
					<h3 class="product-title"><%=producto.getNombre()%></h3> <strong
					class="product-price"><%=producto.getPrecio() + "€"%></strong> <span
					class="icon-cross"> <img src="images/cross.svg"
						class="img-fluid">
						<a
						href="AñadirProductoServlet?id=<%=producto.getId()%>">
				</span>
				</a>
			</div>

			<%
			}
			%>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
</html>
