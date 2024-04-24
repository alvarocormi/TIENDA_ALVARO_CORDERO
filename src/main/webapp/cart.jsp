<%@page import="curso.java.tienda.model.ProductoVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ include file="header.jsp"%>
<script>

function obtenerCantidad(productoId) {
    var input= document.getElementById("cantidadInput");
    actualizarCantidad(productoId,input);
	
}

function addCantidad(productoId) {
    var input= document.getElementById("cantidadInput");
    var cantidad = parseInt(input.value);
    cantidad++;
    actualizarCantidad(productoId,cantidad);
	
}

function removeCantidad(productoId) {
    var input= document.getElementById("cantidadInput");
    var cantidad = parseInt(input.value);
    cantidad--;
    actualizarCantidad(productoId,cantidad);
	
}

function actualizarCantidad(productoId, cantidad) {
    var url = "ActualizarCantidadServlet?productoId=" + productoId + "&cantidad=" + cantidad;
    fetch(url)
        .then(response => {
            if (response.ok) {
                return response.text();
            }
            throw new Error('Error en la solicitud');
        })
        .then(data => {
            // Actualizar la cantidad en la vista si la respuesta es exitosa
            input.value = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function validarCantidad(input) {
    // Reemplazar cualquier carácter que no sea un número con una cadena vacía
    input.value = input.value.replace(/\D/g, '');

    // Verificar si el valor es mayor que el máximo permitido (esto se puede hacer si lo necesitas)
    var maximo = parseInt(input.getAttribute('max'));
    if (input.value !== '' && parseInt(input.value) > maximo) {
        input.value = maximo.toString(); // Establecer el valor al máximo permitido
    }
}


function actualizarPagina() {
    // Lógica para realizar una acción específica (por ejemplo, actualizar datos, guardar cambios, etc.)

    // Recargar la página
    location.reload();
}

</script>
<div class="hero">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-5">
				<div class="intro-excerpt">
					<h1>Cart</h1>
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
								<th class="product-thumbnail">Image</th>
								<th class="product-name">Product</th>
								<th class="product-price">Price</th>
								<th class="product-quantity">Quantity</th>
								<th class="product-total">Total</th>
								<th class="product-remove">Remove</th>
							</tr>
						</thead>
						<tbody>
							<%
							session = request.getSession();
							Map<ProductoVO, Integer> carrito = (HashMap<ProductoVO, Integer>) session.getAttribute("carrito");
							if (carrito != null) {
								for (Map.Entry<ProductoVO, Integer> entry : carrito.entrySet()) {
									ProductoVO producto = entry.getKey();
									Integer cantidad = entry.getValue();
							%>
							<script>
							 var inputElement = document.getElementById("cantidad");
							 
							</script>
							<tr>
								<td class="product-thumbnail"><img
									src="images/product-1.png" alt="Image" class="img-fluid">
								</td>
								<td class="product-name">
									<h2 class="h5 text-black"><%=producto.getNombre()%></h2>
								</td>
								<td><%=producto.getPrecio()%></td>
								<td>
									<div
										class="input-group mb-3 d-flex align-items-center quantity-container"
										style="max-width: 120px;">
										<div class="input-group-prepend">
											<button class="btn btn-outline-black decrease" 
												onclick="removeCantidad('<%=producto.getId()%>'),actualizarPagina()" type="button">&minus;</button>
										</div>
										<input id="cantidadInput" name="cantidadInput"
											class="form-control text-center quantity-amount"
											value="<%=cantidad%>" placeholder=""
											aria-label="Example text with button addon"
											aria-describedby="button-addon1"
											max="<%=producto.getStock()%>"
											oninput="validarCantidad(this)"
											onchange="actualizarCantidad('<%=producto.getId()%>', this.value)">

										<div class="input-group-append">
											<button class="btn btn-outline-black increase"
												onclick="addCantidad('<%=producto.getId()%>'),actualizarPagina()" type="button">&plus;</button>
										</div>
									</div>

								</td>
								<td><%=producto.getPrecio() * cantidad%></td>
								<td><a href="BorrarProductoCarritoServlet?producto=<%=producto%>" class="btn btn-black btn-sm">X</a></td>
							</tr>
						</tbody>
						<%
						}
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
							href="/TIENDA_ALVARO_CORDERO/">Continuar Comprando</a>
					</div>
				</div>
			</div>
			<div class="col-md-6 pl-5">
				<div class="row justify-content-end">
					<div class="col-md-7">

						<div class="row">
							<div class="col-md-12">
								<a href="PagarServlet"
									class="btn btn-black btn-lg py-3 btn-block"
									onclick="window.location='checkout.html'">Proceder con el
									pago</a>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>


<!-- End Footer Section -->


<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/custom.js"></script>

</body>

</html>
