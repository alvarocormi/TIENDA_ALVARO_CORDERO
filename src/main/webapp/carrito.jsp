<%@page import="curso.java.tienda.model.ProductoVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito de Compras</title>
<script>
function actualizarCantidad(productoId, input) {
    var cantidad = parseInt(input.value);
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
</script>
</head>
<body>
    <h1>Carrito de Compras</h1>

    <%
    session = request.getSession();
    Map<ProductoVO, Integer> carrito = (HashMap<ProductoVO, Integer>) session.getAttribute("carrito");
    if (carrito != null) {
        for (Map.Entry<ProductoVO, Integer> entry : carrito.entrySet()) {
            ProductoVO producto = entry.getKey();
            Integer cantidad = entry.getValue();
    %>
    <form>
        <input type="text" value="<%=producto.getNombre()%>" disabled>
        <input type="number" value="<%=cantidad%>" max="<%=producto.getStock()%>" onchange="actualizarCantidad('<%=producto.getId()%>', this)">
    </form>
    <%
        }
    } 
    %>

    <a href="AñadirProductoServlet">Volver</a>
    <a href="PagarServlet">Comprar</a>
</body>
</html>


