package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorProductos {
	
	private Producto[] listaDeProductos;
	
	
	public GestorProductos(Producto[] productos){
		this.listaDeProductos = productos;
	}
	
	
	// GETTERS Y SETTERS
	
	public Producto[] getProductos() {
		return this.listaDeProductos;
	}
	
	public Producto getProducto(int productoIndex) {
		return this.listaDeProductos[productoIndex];
	}
	
	
	// METODOS
	
	public String[] obtenerListaModelos() {
		List<String> items = new ArrayList<>();

		for (int index = 0; index < this.listaDeProductos.length; index++) {
			items.add(this.listaDeProductos[index].getModelo());
		}

		// convertir de List<String> a String[]
		return items.toArray(new String[0]);
	}
	
	public List<Double> obtenerListaPrecios() {
		List<Double> precios = new ArrayList<Double>();

		// recorrer los productos y solo obtener un array de los precios
		for (int index = 0; index < this.listaDeProductos.length; index++) {
			precios.add(this.listaDeProductos[index].getPrecio());
		}

		return precios;
	}
	
	public int calcularCantidadVentasTotales() {
		int cantidadVentasTotales = 0;

		for (int index = 0; index < this.listaDeProductos.length; index++) {
			cantidadVentasTotales += this.listaDeProductos[index].getCantidadVentas();
		}
		
		return cantidadVentasTotales;
	}
	
	public int calcularImporteAcumuladoTotal() {
		int importeAcumulado = 0;

		for (int index = 0; index < this.listaDeProductos.length; index++) {
			importeAcumulado += this.getProducto(index).getImporteTotalVendido();
		}

		return importeAcumulado;
	}
	
	public double calcularPrecioPromedioDeTodosProductos() {
		List<Double> precios = this.obtenerListaPrecios();

		double promedio = precios.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		return promedio;
	}
	
	
	public double calcularPrecioMayorProductos() {
		return Collections.max(this.obtenerListaPrecios());
	}

	public double calcularPrecioMenorProductos() {
		return Collections.min(this.obtenerListaPrecios());
	}
	
	
}
