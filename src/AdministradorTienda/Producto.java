package AdministradorTienda;

import java.util.ArrayList;
import java.util.List;

class Producto {
	public String modelo;
	public double precio;
	public double ancho;
	public double largo;
	public double espesor;
	public int contenido;
	
	public String imagen;
	public List<Double> historialPrecios = new ArrayList<>();

	// contadores y acumuladores
	public int cantidadVentas = 0;
	public int cantidadCajasVendidas = 0;
	public double importeTotalVendido = 0;

	public Producto(String modelo, double precio, double ancho, double largo, double espesor, int contenido, String imagen) {
		this.modelo = modelo;
		this.precio = precio;
		this.ancho = ancho;
		this.largo = largo;
		this.espesor = espesor;
		this.contenido = contenido;
		this.imagen = imagen;
		this.historialPrecios.add(precio);
	}

	void updateProducto(double nuevoPrecio, double nuevoAncho, double nuevoLargo, double nuevoEspesor, int nuevoContenido) {
		addPrecioHistorial(nuevoPrecio); // modificar el historial antes que el precio

		this.precio = nuevoPrecio;
		this.ancho = nuevoAncho;
		this.largo = nuevoLargo;
		this.espesor = nuevoEspesor;
		this.contenido = nuevoContenido;
	}

	void venderProducto(int cajasVendidas, double importePagar) {
		cantidadVentas++;
		cantidadCajasVendidas += cajasVendidas;
		importeTotalVendido += importePagar;
	}

	void addPrecioHistorial(double nuevoPrecio) {

		if (nuevoPrecio != this.precio) {
			this.historialPrecios.add(nuevoPrecio);
		}
	}

	String[] getHistorial() {
		return this.historialPrecios.toArray(new String[0]);
	}

	double getPrecioPromedio() {
		double promedio = this.historialPrecios.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		return promedio;
	}
}