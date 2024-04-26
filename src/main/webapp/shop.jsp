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
	<div class="form-group" style="width: 10%; margin-left: 16%; margin-top: -70px;">
		<form action="TiendaServlet" method="get" style="margin-bottom: 60px">
			<label for="filtros" class="text-black">Filtrar <span
				class="text-danger"></span></label> <select id="filtros" name="filtros"
				class="form-control">
				<option value="c.nombre"
					<%=(request.getParameter("filtros") != null && request.getParameter("filtros").equals("c.nombre")) ? "selected"
		: ""%>>Categoria</option>
				<option value="p.precio"
					<%=(request.getParameter("filtros") != null && request.getParameter("filtros").equals("p.precio")) ? "selected"
		: ""%>>Precio</option>
				<option value="p.stock"
					<%=(request.getParameter("filtros") != null && request.getParameter("filtros").equals("p.stock")) ? "selected"
		: ""%>>Stock</option>
			</select> <input type="submit" value="Enviar">
		</form>
	</div>


	<div class="container">

		<div class="row">
			<%
			List<ProductoVO> catalogo = (List<ProductoVO>) request.getAttribute("catalogo");

			for (ProductoVO producto : catalogo) {
			%>

			<!-- Start Column 1 -->
			<div class="col-12 col-md-4 col-lg-3 mb-5">
				<a class="product-item"
					href="DetalleProductoServlet?id=<%=producto.getId()%>"> <img
					src="images/<%=producto.getImagen()%>" class="img-fluid product-thumbnail">
					<h3 class="product-title"><%=producto.getNombre()%></h3> <strong
					class="product-price"><%=producto.getPrecio() + "€"%></strong> <span
					class="icon-cross"> <img src="images/cross.svg"
						class="img-fluid"></span>
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
