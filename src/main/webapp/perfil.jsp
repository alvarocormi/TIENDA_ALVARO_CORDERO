<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Start Hero Section -->
<div class="hero">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-5">
				<div class="intro-excerpt">
					<h1>Perfil</h1>
				</div>
			</div>
			<div class="col-lg-7"></div>
		</div>
	</div>
</div>
	<%
						UsuarioVO usuario = (UsuarioVO) session.getAttribute("usuario");
						%>
<!-- End Hero Section -->
<div class="untree_co-section" style="padding: 3rem 0;">
	<div class="container">
		<div class="row">
			<div class="col-md-6 mb-5 mb-md-0">
				<a href="AñadirProductoServlet">Volver</a> 
				<a href="ListadoPedidosServlet">Ver Pedidos</a>
				<a href="EditarPerfilServlet">Editar Perfil</a>  
			</div>
		</div>

	</div>
	<!-- </form> -->
</div>

<%@ include file="footer.jsp"%>
</html>
