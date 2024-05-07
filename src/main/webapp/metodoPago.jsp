<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- End Hero Section -->
<%
session = request.getSession();
String total = (String) session.getAttribute("total");
%>
<div class="untree_co-section" style="padding: 3rem 0;">
	<div class="container">
		<div class="row">
			<div class="col-md-6 mb-5 mb-md-0">
				<div class="form-group row"></div>
				<div class="row mb-5">
					<div class="col-md-12">
						<div>Complete su compra</div>
						<div class="p-3 p-lg-5 border bg-white" style="border-radius: 10px;">
							<h2 class="h3 mb-3 text-black">Metodo de pago</h2>
							<p>Precio final: <b><%= total %>€</b></p>
							<form action="ProcesarPagoPedidoServlet" method="post"
								class="row" ">
								<div class="form-check" style="margin-left: 10px;">
									<label class="form-check-label" for="flexRadioDefault1"><input
										class="form-check-input text-black mb-3" type="radio"
										name="metodoPago" value="paypal" checked> PayPal</label>
								</div>
								<div class="form-check" style="margin-left: 10px;">

									<label class="form-check-label" for="flexRadioDefault2"><input
										class="form-check-input text-black mb-3" type="radio"
										name="metodoPago" value="bizum">Bizum</label>
								</div>
								<div class="form-check"style="margin-left: 10px;">

									<label class="form-check-label" for="flexRadioDefault2"><input
										class="form-check-input text-black mb-3" type="radio"
										name="metodoPago" value="tarjeta">Tarjeta Credito</label>
								</div>
								<div style="margin-top: 10px;">		
								<input class="btn" style="width: 50%" type="submit" value="Continuar">
								<a class="btn" style="background: white; color: black" href="PagarServlet">Volver</a>
								</div>
								
							</form>
							
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

