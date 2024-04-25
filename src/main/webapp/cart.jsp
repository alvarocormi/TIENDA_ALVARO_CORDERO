<%@page import="curso.java.tienda.model.ProductoVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ include file="header.jsp"%>
<script>
function addCantidad(productoId,stockProducto) {
    var input= document.getElementById("cantidadInput"+productoId);
    var cantidad = parseInt(input.value);
    if(cantidad<stockProducto){
    	 cantidad++;
    	    actualizarCantidad(productoId,cantidad);
    }  
}

function removeCantidad(productoId,stockProducto) {
    var input= document.getElementById("cantidadInput"+productoId);
    var cantidad = parseInt(input.value);
    if(cantidad>1){
    cantidad--;
    actualizarCantidad(productoId,cantidad);
    validarCantidad(input,stockProducto);
    }
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

function validarCantidad(input,stockProducto) {
    // Convertir el valor a un número entero
    var cantidad = parseInt(input.value);
    // Verificar si el valor es menor que cero (negativo)
    if (cantidad < 1) {
        // Si es negativo, establecer el valor como cero
        input.value = 1;
    } else {
        // Verificar si el valor es mayor que el máximo permitido (esto se puede hacer si lo necesitas)
        var maximo = stockProducto;
        if (cantidad > maximo) {
            // Si es mayor que el máximo permitido, establecer el valor al máximo permitido
            input.value = maximo.toString();
        }
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
							if (carrito != null) {
								for (Map.Entry<ProductoVO, Integer> entry : carrito.entrySet()) {
									ProductoVO producto = entry.getKey();
									Integer cantidad = entry.getValue();
							%>
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
												onclick="removeCantidad('<%=producto.getId()%>','<%=producto.getStock()%>'),actualizarPagina()" type="button">&minus;</button>
										</div>
										<input id="cantidadInput<%=+producto.getId()%>" name="cantidadInput"
											class="form-control text-center quantity-amount"
											value="<%=cantidad%>" placeholder=""
											aria-label="Example text with button addon"
											aria-describedby="button-addon1"
											onchange="validarCantidad(this,'<%=producto.getStock()%>'),actualizarCantidad('<%=producto.getId()%>', this.value),actualizarPagina()">

										<div class="input-group-append">
											<button class="btn btn-outline-black increase"
												onclick="addCantidad('<%=producto.getId()%>','<%=producto.getStock()%>'), actualizarPagina()" type="button">&plus;</button>
										</div>
									</div>

								</td>
								<td><%=producto.getPrecio() * cantidad%></td>
								<td><a href="BorrarProductoCarritoServlet?idProducto=<%=producto.getId()%>" class="btn btn-black btn-sm">X</a></td>
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
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/custom.js"></script>

</body>

</html>
