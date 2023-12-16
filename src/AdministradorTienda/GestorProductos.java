package AdministradorTienda;

import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
	
	private Producto[] listaDeProductos;
	
	GestorProductos(Producto[] productos){
		this.listaDeProductos = productos;
	}
	
	
	// GETTERS Y SETTERS
	
	Producto[] getProductos() {
		return this.listaDeProductos;
	}
	
	Producto getProducto(int productoIndex) {
		return this.listaDeProductos[productoIndex];
	}
	
	
	// METODOS
	
	String[] obtenerListaModelos() {
		List<String> items = new ArrayList<>();

		for (int index = 0; index < this.listaDeProductos.length; index++) {
			items.add(this.listaDeProductos[index].getModelo());
		}

		// convertir de List<String> a String[]
		return items.toArray(new String[0]);
	}
	
	List<Double> obtenerListaPrecios() {
		List<Double> precios = new ArrayList<Double>();

		// recorrer los productos y solo obtener un array de los precios
		for (int index = 0; index < this.listaDeProductos.length; index++) {
			precios.add(this.listaDeProductos[index].getPrecio());
		}

		return precios;
	}
	
	int calcularCantidadVentasTotales() {
		int cantidadVentasTotales = 0;

		for (int index = 0; index < this.listaDeProductos.length; index++) {
			cantidadVentasTotales += this.listaDeProductos[index].getCantidadVentas();
		}
		
		return cantidadVentasTotales;
	}
	
	int calcularImporteAcumuladoTotal() {
		int importeAcumulado = 0;

		for (int index = 0; index < this.listaDeProductos.length; index++) {
			importeAcumulado += this.getProducto(index).getImporteTotalVendido();
		}

		return importeAcumulado;
	}
	
	double calcularPrecioPromedioDeTodosProductos() {
		List<Double> precios = this.obtenerListaPrecios();

		double promedio = precios.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		return promedio;
	}
	
	
	
}
