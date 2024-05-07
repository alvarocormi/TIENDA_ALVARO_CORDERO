<%@ include file="header.jsp"%>
<!-- Start Hero Section -->
<div class="hero">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-5">
				<div class="intro-excerpt">
					<h1>Registro</h1>
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
					<form action="RegistroServlet" method="post" class="row">
						<div class="col-md-6">
							<label for="c_fname" class="text-black">Email <span
								class="text-danger">*</span></label> <input type="email"
								class="form-control" id="c_fname" name="email">
						</div>
						<div class="col-md-6">
							<label for="c_lname" class="text-black">Password <span
								class="text-danger">*</span></label> <input type="password"
								class="form-control" id="c_lname" name="clave">
						</div>
						<div class="col-md-6" style="width: 100%;">
							<label for="c_lname" class="text-black">Repetir Password <span
								class="text-danger">*</span></label> <input type="password"
								class="form-control" id="c_lname" name="claveRepetida">
						</div>
						<div class="form-group pt-4">
							<input type="submit" class="btn"
								value="Registrarse"></input>
						</div>
					</form>
				</div>


			</div>
		</div>

	</div>
	<!-- </form> -->
</div>

<%@ include file="footer.jsp"%>
</html>