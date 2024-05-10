<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="curso.java.tienda.model.PedidoVO"%>
<%@ include file="header.jsp"%>
<!-- Start Hero Section -->
<div class="hero">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-5">
				<div class="intro-excerpt">
					<h1>Listado Pedidos</h1>
				</div>
			</div>
			<div class="col-lg-7"></div>
		</div>
	</div>
</div>
<!-- End Hero Section -->

<div class="untree_co-section before-footer-section">
	<div class="container">
		<div class="row mb-5">
			<form class="col-md-12" method="post">
				<div class="site-blocks-table">
					<table class="table">
						<thead>
							<tr>
								<th class="product-detail">Detalle</th>
								<th class="product-thumbnail">NumFactura</th>
								<th class="product-name">Fecha <a
									style="text-decoration: none"
									; href="ListadoPedidosServlet?orden=asc"> <i
										class="fas fa-arrow-up"></i>
								</a> <a style="text-decoration: none;"
									href="ListadoPedidosServlet?orden=desc"> <i
										class="fas fa-arrow-down"></i>
								</a></th>
								<th class="product-price">MetodoPago</th>
								<th class="product-quantity">Estado</th>
								<th class="product-total">Total</th>
								<th class="product-remove">Remove</th>

							</tr>
						</thead>
						<tbody>
							<%
							session = request.getSession();

							List<PedidoVO> pedidos = (List<PedidoVO>) request.getAttribute("pedidos");

							for (PedidoVO pedido : pedidos) {
							%>

							<tr>
								<td><a href="DetallePedidoServlet?idPedido=<%= pedido.getId() %>"
									style="text-decoration: none">Ver</a></td>
								<td class="product-name">
									<h2 class="h5 text-black"><%=pedido.getNumFactura() != null ? pedido.getNumFactura() : ""  %></h2>
								</td>
								<td><%=pedido.getFecha()%></td>
								<td><%=pedido.getMetodoPago()%></td>
								<td><%=pedido.getEstado()%></td>
								<td><%=pedido.getTotal()  != 0 ? pedido.getTotal() : "" %></td>
								<td><a
									href="BorrarPedidoListadoServlet?id=<%=pedido.getId()%>"
									class="btn btn-black btn-sm">X</a></td>
							</tr>
						</tbody>
						<%
						}
						%>
					</table>
				</div>
			</form>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="row mb-5">
					<div class="col-md-6">
						<a class="btn btn-outline-black btn-sm btn-block"
							href="PerfilServlet">Volver</a>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>
</html>
