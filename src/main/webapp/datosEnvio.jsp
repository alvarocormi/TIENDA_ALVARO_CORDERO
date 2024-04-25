<%@ include file="header.jsp"%>
<!-- Start Hero Section -->
<div class="hero">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-5">
				<div class="intro-excerpt">
					<h1>Datos Envio</h1>
				</div>
			</div>
			<div class="col-lg-7"></div>
		</div>
	</div>
</div>
<!-- End Hero Section -->
<div class="untree_co-section" style="padding: 3rem 0;">
	<div class="container">
		<div class="row">
			<div class="col-md-6 mb-5 mb-md-0">
				<div class="form-group row">
					<form action="ProcesarDatosEnvioServlet" method="post" class="row">
						<%
						UsuarioVO usuario = (UsuarioVO) session.getAttribute("usuario");
						%>

						<div class="col-md-6">
							<label for="c_fname" class="text-black">Nombre <span
								class="text-danger">*</span></label> <input type="text"
								class="form-control" id="nombre" name="nombre"  value="<%= (usuario != null && usuario.getNombre() != null) ? usuario.getNombre() : "" %>">
						</div>
						<div class="col-md-6">
							<label for="c_lname" class="text-black">Primer Apellido <span
								class="text-danger">*</span></label> <input type="text"
								class="form-control" id="apellido2" name="apellido1" value="<%= (usuario != null && usuario.getApellido1() != null) ? usuario.getApellido1() : "" %>">
						</div>
						<div class="col-md-6">
							<label for="c_lname" class="text-black">Segundo Apellido
								<span class="text-danger">*</span>
							</label> <input type="text" class="form-control" id="apellido2"
								name="apellido2"value="<%= (usuario != null && usuario.getApellido2() != null) ? usuario.getApellido2() : "" %>">
						</div>
						<div class="col-md-6">
							<label for="c_lname" class="text-black">Direccion <span
								class="text-danger">*</span></label> <input type="text"
								class="form-control" id="direccion" name="direccion" value="<%= (usuario != null && usuario.getDireccion() != null) ? usuario.getDireccion() : "" %>">
						</div>
						<div class="col-md-6">
							<label for="c_lname" class="text-black">Telefono <span
								class="text-danger">*</span></label> <input type="text"
								class="form-control" id="telefono" name="telefono" value="<%= (usuario != null && usuario.getTelefono() != null) ? usuario.getTelefono() : "" %>">
						</div>
						<div class="form-group pt-4">
							<input type="submit" class="btn btn-black btn-lg py-2 btn-block"
								value="Siguiente"></input>
						</div>
					</form>
				</div>

				<a href="CarritoServlet">Volver</a>

			</div>
		</div>

	</div>
	<!-- </form> -->
</div>

<%@ include file="footer.jsp"%>
</html>