<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="curso.java.tienda.model.UsuarioVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="curso.java.tienda.dao.ProductoDAO"%>
<%@ page import="java.util.List,curso.java.tienda.model.ProductoVO"%>
<%@ include file="header.jsp"%>

<!-- Modal -->
<div class="modal fade bg-white" id="templatemo_search" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="w-100 pt-1 mb-5 text-right">
			<button type="button" class="btn-close" data-bs-dismiss="modal"
				aria-label="Close"></button>
		</div>
		<form action="" method="get"
			class="modal-content modal-body border-0 p-0">
			<div class="input-group mb-2">
				<input type="text" class="form-control" id="inputModalSearch"
					name="q" placeholder="Search ...">
				<button type="submit" class="input-group-text bg-success text-light">
					<i class="fa fa-fw fa-search text-white"></i>
				</button>
			</div>
		</form>
	</div>
</div>

<%
ProductoVO producto = (ProductoVO) request.getAttribute("producto");
%>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var currentValue = 1;
        var maxValue = <%= producto.getStock() %>; // Obtener el stock máximo del producto desde tu servidor

        // Función para actualizar la cantidad mostrada y el valor del campo oculto
        function updateQuantity(value) {
            if (value >= 1 && value <= maxValue) {
                currentValue = value;
                document.getElementById('var-value').textContent = currentValue;
                document.getElementById('product-quantity').value = currentValue;
            }
        }

        // Botón de incremento
        document.getElementById('btn-plus').addEventListener('click', function() {
            if (currentValue < maxValue) {
                updateQuantity(currentValue + 1);
            }
        });

        // Botón de decremento
        document.getElementById('btn-minus').addEventListener('click', function() {
            if (currentValue > 1) {
                updateQuantity(currentValue - 1);
            }
        });

        // Inicializar el valor de la cantidad
        updateQuantity(currentValue);
    });
</script>
<!-- Open Content -->
<section class="mb-5">
	<div class="container pb-5">
		<div class="row">
			<div class="col-lg-5 mt-5">
				<div class="card mb-3">
					<img class="card-img img-fluid"
						src="images/<%=producto.getImagen()%>" alt="Card image cap"
						id="product-detail">
				</div>
			</div>
			<div class="col-lg-7 mt-5">
				<div class="card" style="height: 524px;">
					<div class="card-body">
						<h1 class="h2"><%=producto.getNombre()%></h1>
						<p class="h3 py-2"><%=producto.getPrecio() + "€"%></p>
						<h6>Description:</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed do eiusmod temp incididunt ut labore et dolore magna aliqua.
							Quis ipsum suspendisse. Donec condimentum elementum convallis.
							Nunc sed orci a diam ultrices aliquet interdum quis nulla.</p>
						<ul class="list-inline">
							<li class="list-inline-item">
								<h6>Stock disponible :</h6>
							</li>
							<li class="list-inline-item">
								<p class="text-muted">
									<strong><%=producto.getStock()%></strong>
								</p>
							</li>
						</ul>
					</div>
					<form action="AñadirProductoServlet" method="GET">
						<input type="hidden" name="id" value="<%=producto.getId()%>">
						<input type="hidden" name="product-quantity" id="product-quantity"
							value="1">

						<!-- Botones de incremento y decremento -->
						<div class="col-auto">
							<ul class="list-inline pb-3">
								<li class="list-inline-item text-right">Quantity</li>
								<li class="list-inline-item"><span class="btn btn-success"
									id="btn-minus">-</span></li>
								<li class="list-inline-item"><span
									class="badge bg-secondary" id="var-value">1</span></li>
								<li class="list-inline-item"><span class="btn btn-success"
									id="btn-plus">+</span></li>
							</ul>
						</div>

						<!-- Botón de submit -->
						<input class="btn m-3" type="submit" value="Añadir al Carrito">
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="footer.jsp"%>
<!-- End Footer Section -->

<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/custom.js"></script>


</body>

</html>