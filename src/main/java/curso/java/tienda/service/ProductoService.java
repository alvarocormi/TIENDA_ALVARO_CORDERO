package curso.java.tienda.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import curso.java.tienda.model.ProductoVO;

public class ProductoService  {
	
	// Método para ordenar una lista de productos por precio de manera descendente
	    public static List<ProductoVO> ordenarProductosPorPrecioDescendente(List<ProductoVO> productos) {
	        // Copiar la lista original para no modificar la lista original
	        List<ProductoVO> listaOrdenada = new ArrayList<>(productos);

	        // Definir un Comparator para comparar por precio de manera descendente
	        Comparator<ProductoVO> comparadorPorPrecioDescendente = new Comparator<ProductoVO>() {
	            @Override
	            public int compare(ProductoVO p1, ProductoVO p2) {
	                // Comparar por precio de manera descendente
	                return Double.compare(p2.getPrecio(), p1.getPrecio());
	            }
	        };
	        // Ordenar la lista utilizando el Comparator
	        Collections.sort(listaOrdenada, comparadorPorPrecioDescendente);

	        return listaOrdenada;
	    }
	    
	    
	    public static List<ProductoVO> ordenarProductosPorStockDescendente(List<ProductoVO> productos) {
	        // Copiar la lista original para no modificar la lista original
	        List<ProductoVO> listaOrdenada = new ArrayList<>(productos);

	        // Definir un Comparator para comparar por precio de manera descendente
	        Comparator<ProductoVO> comparadorPorStockDescendente = new Comparator<ProductoVO>() {
	            @Override
	            public int compare(ProductoVO p1, ProductoVO p2) {
	                // Comparar por precio de manera descendente
	                return Double.compare(p2.getStock(), p1.getStock());
	            }
	        };
	        // Ordenar la lista utilizando el Comparator
	        Collections.sort(listaOrdenada, comparadorPorStockDescendente);

	        return listaOrdenada;
	    }
	    
	    public static List<ProductoVO> ordenarProductosPorCategoria(List<ProductoVO> productos) {
	        // Copiar la lista original para no modificar la lista original
	        List<ProductoVO> listaOrdenada = new ArrayList<>(productos);

	        // Definir un Comparator para comparar por precio de manera descendente
	        Comparator<ProductoVO> comparadorPorCategoria = new Comparator<ProductoVO>() {
	            @Override
	            public int compare(ProductoVO p1, ProductoVO p2) {
	                // Comparar por precio de manera descendente
	                return Double.compare(p2.getIdCategoria(), p1.getIdCategoria());
	            }
	        };
	        // Ordenar la lista utilizando el Comparator
	        Collections.sort(listaOrdenada, comparadorPorCategoria);

	        return listaOrdenada;
	    }

}
