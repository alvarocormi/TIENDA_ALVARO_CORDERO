<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%
session = request.getSession();
%>
<!-- Start Hero Section -->
<div class="hero">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-5">
				<div class="intro-excerpt">
					<h1>
						Interiores Modernos <span class="d-block"></span>
					</h1>
					<p class="mb-4">Explora nuestra colección de muebles modernos
						que fusionan elegancia contemporánea con funcionalidad innovadora.</p>
					<p>
						<a href="TiendaServlet" class="btn btn-secondary me-2">Comprar Ahora</a>
					</p>
				</div>
			</div>
			<div class="col-lg-7">
				<div class="hero-img-wrap">
					<img src="images/couch.png" class="img-fluid">
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End Hero Section -->

<!-- Start Product Section -->
<div class="product-section">
	<div class="container">
		<div class="row">
			<%
			List<ProductoVO> catalogo = (List<ProductoVO>) request.getAttribute("catalogo");

			for (ProductoVO producto : catalogo) {
			%>
			<!-- Start Column 2 -->
			<div class="col-12 col-md-4 col-lg-3 mb-5 mb-md-0">
				<div class="product-item">
					<a style="text-decoration: none"
						href="DetalleProductoServlet?id=<%=producto.getId()%>"> <img
						src="images/<%=producto.getImagen()%>"
						class="img-fluid product-thumbnail">
						<h3 class="product-title"><%=producto.getNombre()%></h3> <strong
						class="product-price"><%=producto.getPrecio() + "€"%></strong>

					</a> 
				
					<a
						style="display: flex; justify-content: center; padding-top: 15px; text-decoration: none; "
						href="AñadirProductoServlet?id=<%=producto.getId()%>&product-quantity=1"
						class="img-fluid"><i class="fa-solid fa-circle-plus fa-2x"></i></a>
	

				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>
</div>
<!-- End Product Section -->

<!-- Start Why Choose Us Section -->
<div class="why-choose-section">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-6">
				<h2 class="section-title">Porque comprar aqui?</h2>
				<p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac
					aliquet velit. Aliquam vulputate velit imperdiet dolor tempor
					tristique.</p>

				<div class="row my-5">
					<div class="col-6 col-md-6">
						<div class="feature">
							<div class="icon">
								<img src="images/truck.svg" alt="Image" class="imf-fluid">
							</div>
							<h3>Fast &amp; Free Shipping</h3>
							<p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac
								aliquet velit. Aliquam vulputate.</p>
						</div>
					</div>

					<div class="col-6 col-md-6">
						<div class="feature">
							<div class="icon">
								<img src="images/bag.svg" alt="Image" class="imf-fluid">
							</div>
							<h3>Easy to Shop</h3>
							<p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac
								aliquet velit. Aliquam vulputate.</p>
						</div>
					</div>

					<div class="col-6 col-md-6">
						<div class="feature">
							<div class="icon">
								<img src="images/support.svg" alt="Image" class="imf-fluid">
							</div>
							<h3>24/7 Support</h3>
							<p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac
								aliquet velit. Aliquam vulputate.</p>
						</div>
					</div>

					<div class="col-6 col-md-6">
						<div class="feature">
							<div class="icon">
								<img src="images/return.svg" alt="Image" class="imf-fluid">
							</div>
							<h3>Hassle Free Returns</h3>
							<p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac
								aliquet velit. Aliquam vulputate.</p>
						</div>
					</div>

				</div>
			</div>

			<div class="col-lg-5">
				<div class="img-wrap">
					<img src="images/why-choose-us-img.jpg" alt="Image"
						class="img-fluid">
				</div>
			</div>

		</div>
	</div>
</div>
<!-- End Why Choose Us Section -->

<!-- Start We Help Section -->
<div class="we-help-section">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-7 mb-5 mb-lg-0">
				<div class="imgs-grid">
					<div class="grid grid-1">
						<img src="images/img-grid-1.jpg" alt="Untree.co">
					</div>
					<div class="grid grid-2">
						<img src="images/img-grid-2.jpg" alt="Untree.co">
					</div>
					<div class="grid grid-3">
						<img src="images/img-grid-3.jpg" alt="Untree.co">
					</div>
				</div>
			</div>
			<div class="col-lg-5 ps-lg-5">
				<h2 class="section-title mb-4">Nosotros te ayudamos a diseñar el interior de tu casa</h2>
				<p>Donec facilisis quam ut purus rutrum lobortis. Donec vitae
					odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam
					vulputate velit imperdiet dolor tempor tristique. Pellentesque
					habitant morbi tristique senectus et netus et malesuada</p>

				<ul class="list-unstyled custom-list my-4">
					<li>Donec vitae odio quis nisl dapibus malesuada</li>
					<li>Donec vitae odio quis nisl dapibus malesuada</li>
					<li>Donec vitae odio quis nisl dapibus malesuada</li>
					<li>Donec vitae odio quis nisl dapibus malesuada</li>
				</ul>
				<p>
					<a href="TiendaServlet" class="btn">Explorar</a>
				</p>
			</div>
		</div>
	</div>
</div>
<!-- End We Help Section -->

<!-- Start Testimonial Slider -->
<div class="testimonial-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-7 mx-auto text-center">
				<h2 class="section-title">Opiniones</h2>
			</div>
		</div>

		<div class="row justify-content-center">
			<div class="col-lg-12">
				<div class="testimonial-slider-wrap text-center">

					<div id="testimonial-nav">
						<span class="prev" data-controls="prev"><span
							class="fa fa-chevron-left"></span></span> <span class="next"
							data-controls="next"><span class="fa fa-chevron-right"></span></span>
					</div>

					<div class="testimonial-slider">

						<div class="item">
							<div class="row justify-content-center">
								<div class="col-lg-8 mx-auto">

									<div class="testimonial-block text-center">
										<blockquote class="mb-5">
											<p>&ldquo;Donec facilisis quam ut purus rutrum lobortis.
												Donec vitae odio quis nisl dapibus malesuada. Nullam ac
												aliquet velit. Aliquam vulputate velit imperdiet dolor
												tempor tristique. Pellentesque habitant morbi tristique
												senectus et netus et malesuada fames ac turpis egestas.
												Integer convallis volutpat dui quis scelerisque.&rdquo;</p>
										</blockquote>

										<div class="author-info">
											<div class="author-pic">
												<img src="images/person-1.png" alt="Maria Jones"
													class="img-fluid">
											</div>
											<h3 class="font-weight-bold">Maria Jones</h3>
											<span class="position d-block mb-3">CEO, Co-Founder,
												XYZ Inc.</span>
										</div>
									</div>

								</div>
							</div>
						</div>
						<!-- END item -->

						<div class="item">
							<div class="row justify-content-center">
								<div class="col-lg-8 mx-auto">

									<div class="testimonial-block text-center">
										<blockquote class="mb-5">
											<p>&ldquo;Donec facilisis quam ut purus rutrum lobortis.
												Donec vitae odio quis nisl dapibus malesuada. Nullam ac
												aliquet velit. Aliquam vulputate velit imperdiet dolor
												tempor tristique. Pellentesque habitant morbi tristique
												senectus et netus et malesuada fames ac turpis egestas.
												Integer convallis volutpat dui quis scelerisque.&rdquo;</p>
										</blockquote>

										<div class="author-info">
											<div class="author-pic">
												<img src="images/person-1.png" alt="Maria Jones"
													class="img-fluid">
											</div>
											<h3 class="font-weight-bold">Maria Jones</h3>
											<span class="position d-block mb-3">CEO, Co-Founder,
												XYZ Inc.</span>
										</div>
									</div>

								</div>
							</div>
						</div>
						<!-- END item -->

						<div class="item">
							<div class="row justify-content-center">
								<div class="col-lg-8 mx-auto">

									<div class="testimonial-block text-center">
										<blockquote class="mb-5">
											<p>&ldquo;Donec facilisis quam ut purus rutrum lobortis.
												Donec vitae odio quis nisl dapibus malesuada. Nullam ac
												aliquet velit. Aliquam vulputate velit imperdiet dolor
												tempor tristique. Pellentesque habitant morbi tristique
												senectus et netus et malesuada fames ac turpis egestas.
												Integer convallis volutpat dui quis scelerisque.&rdquo;</p>
										</blockquote>

										<div class="author-info">
											<div class="author-pic">
												<img src="images/person-1.png" alt="Maria Jones"
													class="img-fluid">
											</div>
											<h3 class="font-weight-bold">Maria Jones</h3>
											<span class="position d-block mb-3">CEO, Co-Founder,
												XYZ Inc.</span>
										</div>
									</div>

								</div>
							</div>
						</div>
						<!-- END item -->

					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<!-- End Testimonial Slider -->
<!-- Start Footer Section -->
<%@ include file="footer.jsp"%>
<!-- End Footer Section -->

<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/custom.js"></script>
</body>

</html>
