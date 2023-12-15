package AdministradorTienda;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		DashboardFrame frame = new DashboardFrame();
		frame.setVisible(true);
	}
	

	// productos
	static Producto[] productos = {
			new Producto("Cinza Plus", 92.56, 62.0, 62.0, 8, 6, "/azulejos/azulejo-1.jpg"),
			new Producto("Luxury", 42.77, 60, 60, 8.5, 4, "/azulejos/azulejo-2.jpg"),
			new Producto("Austria", 52.45, 45, 45, 6.5, 12, "/azulejos/azulejo-3.jpg"),
			new Producto("Yungay Mix", 55.89, 80, 120, 6.8, 9, "/azulejos/azulejo-4.jpg"),
			new Producto("Thalía", 45, 45, 11.8, 7.2, 10, "/azulejos/azulejo-5.jpg"),
			new Producto("Ébano Supreme", 80.52, 62.0, 62.0, 8, 6, "/azulejos/azulejo-6.jpg"),
			new Producto("Vienna Elite", 60.59, 60, 60, 8.5, 4, "/azulejos/azulejo-7.jpg"),
			new Producto("Harmony Blend", 35.45, 55, 55, 6.5, 12, "/azulejos/azulejo-8.jpg"),
			new Producto("Mystic Glam", 35.54, 80, 80, 6.8, 9, "/azulejos/azulejo-9.jpg"),
			new Producto("Cinderella Charm", 46.32, 45, 45, 7.2, 10, "/azulejos/azulejo-10.jpg"),
			new Producto("Regal Essence", 64.85, 62.0, 62.0, 8, 3, "/azulejos/azulejo-11.jpg"),
			new Producto("Nordic Serenity", 62.58, 60, 60, 8.5, 4, "/azulejos/azulejo-12.jpg"),
			new Producto("Imperial Radiance", 76.65, 45, 45, 6.5, 12, "/azulejos/azulejo-13.jpg"),
			new Producto("Seraphic Splendor", 78.52, 80, 80, 6.8, 7, "/azulejos/azulejo-14.jpg"),
			new Producto("Ethereal Allure", 78.85, 45, 45, 7.2, 10, "/azulejos/azulejo-15.jpg"),
			new Producto("Royal Velvet", 95.65, 62.0, 62.0, 8, 6, "/azulejos/azulejo-16.jpg"),
			new Producto("Celestial Harmony", 23.57, 56, 56, 8.5, 4, "/azulejos/azulejo-17.jpg"),
			new Producto("Pompeii Lux", 68.45, 60, 60, 6.5, 12, "/azulejos/azulejo-18.jpg"),
			new Producto("Aurora Lux", 49.89, 70, 70, 6.8, 9, "/azulejos/azulejo-19.jpg"),
			new Producto("Velvet Essence", 73, 63, 63, 7.2, 10, "/azulejos/azulejo-20.jpg")
		};

	// Porcentajes de descuento
	static private double porcentaje1 = 7.5;
	static private double porcentaje2 = 10.0;
	static private double porcentaje3 = 12.5;
	static private double porcentaje4 = 15.0;

	// Obsequios
	static private String tipoObsequio = "Lapicero";

	static private int obsequioCantidad1 = 2;
	static private int obsequioCantidad2 = 3;
	static private int obsequioCantidad3 = 4;

	// cantidades por defecto
	static private int cantidadOptima = 10;
	static private double cuotaDiaria = 30000;
	
	
	// METODOS
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/// UTILIDADES
	/// UTILIDADES
	/// UTILIDADES
	/// UTILIDADES
	


	static double calcularPorcentajeDescuento(int cantidadCajas) {
		double procentajeDescuento = 0;

		if (cantidadCajas >= 1 && cantidadCajas <= 5) {
			procentajeDescuento = porcentaje1;
		}
		else if (cantidadCajas <= 10) {
			procentajeDescuento = porcentaje2;
		}
		else if (cantidadCajas <= 15) {
			procentajeDescuento = porcentaje3;
		}
		else {
			procentajeDescuento = porcentaje4;
		}

		return procentajeDescuento;
	}

	static int calcularCantidadObsequios(int UnidadesAdquiridas) {
		int cantidadObsequios = 0;

		if (UnidadesAdquiridas >= 1 && UnidadesAdquiridas <= 5) {
			cantidadObsequios = obsequioCantidad1;
		}
		else if (UnidadesAdquiridas <= 10) {
			cantidadObsequios = obsequioCantidad2;
		}
		else {
			cantidadObsequios = obsequioCantidad3;
		}

		return cantidadObsequios;
	}

	static  ImageIcon crearImagen(int ancho, int alto, String rutaRelativa) {
		ImageIcon icon = new ImageIcon(DashboardFrame.class.getResource(rutaRelativa));

		// Obtener la imagen del icono y ajustar el tamaño
		Image image = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon con la imagen ajustada
		ImageIcon scaledIcon = new ImageIcon(image);

		return scaledIcon;
	}

	
	// PRODUCTOS EN CONJUNTO
	// PRODUCTOS EN CONJUNTO
	// PRODUCTOS EN CONJUNTO

	
	
	// MANTENIMIENTO
	static String generarListadoProductos() {
		String mensaje = "LISTADO DE CERÄMICOS";

		for (int index = 0; index < productos.length; index++) {
			mensaje += "\n\nModelo\t: " + productos[index].getModelo() + "\n";
			mensaje += "Precio\t: S/. " + productos[index].getPrecio() + "\n";
			mensaje += "Ancho (cm)\t: " + productos[index].getAncho() + " cm\n";
			mensaje += "Largo (cm)\t: " + productos[index].getLargo() + " cm\n";
			mensaje += "Espesor (mm)\t: " + productos[index].getEspesor() + " mm\n";
			mensaje += "Contenido\t: " + productos[index].getContenido() + " unidades";
		}

		return mensaje;
	}

	static  String[] obtenerModelosDeProductos() {
		List<String> items = new ArrayList<>();

		for (int index = 0; index < productos.length; index++) {
			items.add(productos[index].getModelo());
		}

		// convertir de List<String> a String[]
		return items.toArray(new String[0]);
	}

	static  List<Double> obtenerListaPrecioProductos() {
		List<Double> precios = new ArrayList<Double>();

		// recorrer los productos y solo obtener un array de los precios
		for (int index = 0; index < productos.length; index++) {
			precios.add(productos[index].getPrecio());
		}

		return precios;
	}

	// SECCION VENDER
	// SECCION VENDER
	// SECCION VENDER
	// SECCION VENDER

	static void verificarVentaMultiplo5() { // VERIFICAR, CREO QUE YA TENGO LA CANTIDAD DE VENTAS COMO VARIABLE GLOBAL
		int cantidadVentasTotales = calcularCantidadVentasTotales();
		boolean multiploDe5 = cantidadVentasTotales % 5 == 0;


		if (multiploDe5 && cantidadVentasTotales > 0) {

			// declaracion de variables
			double importeAcumulado = 0;
			double porcentajeDeLaCuotaDiaria = 0;

			// obtener valores totales
			for (int index = 0; index < productos.length; index++) {
				importeAcumulado += productos[index].getImporteTotalVendido();
			}

			porcentajeDeLaCuotaDiaria = getPorcentajeCuotaDiariaRespectoImporteTotal(importeAcumulado);

			mostrarAviso5ventas(cantidadVentasTotales, importeAcumulado, porcentajeDeLaCuotaDiaria);
		}
	}
	
	static int calcularCantidadVentasTotales() {
		int cantidadVentasTotales = 0;

		for (int index = 0; index < productos.length; index++) {
			cantidadVentasTotales += productos[index].getCantidadVentas();
		}
		
		return cantidadVentasTotales;
	}

	static void mostrarAviso5ventas(int cantidadVentasTotales, double importeAcumulado, double porcentajeDeLaCuotaDiaria) {

		String mensaje = "Venta Nro. " + cantidadVentasTotales + "\n";
		mensaje += "Importe total general acumulado: S/. " + importeAcumulado + "\n";
		mensaje += "Porcentaje de la cuota diaria: " + porcentajeDeLaCuotaDiaria + " %";

		JOptionPane.showMessageDialog(null, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
	}

	static Double getPorcentajeCuotaDiariaRespectoImporteTotal(double cantidadAcumulada) {
		return (100 * cantidadAcumulada) / cuotaDiaria;
	}

	// SECCION GENERAR REPORTES
	// SECCION GENERAR REPORTES
	// SECCION GENERAR REPORTES

	static String getResporteTipo1() {
		String mensaje = "VENTAS POR MODELO";

		for (int index = 0; index < productos.length; index++) {
			mensaje += "\n\nModelo\t\t: " + productos[index].getModelo() + "\n";
			mensaje += "Cantidad de ventas\t: " + productos[index].getCantidadVentas() + "\n";
			mensaje += "Cantidad de cajas vendidas\t: " + productos[index].getCantidadCajasVendidas() + "\n";
			mensaje += "Importe total vendido\t: S/. " +productos[index].getImporteTotalVendido() + "\n";
			mensaje += "Aporte a la cuota diaria\t: "
					+ getPorcentajeCuotaDiariaRespectoImporteTotal(productos[index].getImporteTotalVendido()) + " %";
		}

		return mensaje;
	}

	static String getResporteTipo2() {
		String mensaje = "COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO";

		for (int index = 0; index < productos.length; index++) {

			String modelo = productos[index].getModelo();
			double precio = productos[index].getPrecio();
			//double precioPromedio = productos[index].getPrecioPromedio(); // MOdiFICAR EL ES METOOD, ESTE NO DEBEERIA IR
			double precioPromedio = getPrecioPromedioDeTodosProductos(); 
			String comparacion = compararDouble(precio, precioPromedio);

			mensaje += "\n\nModelo\t\t: " + modelo + "\n";
			mensaje += "Precio\t\t: S/. " + precio + "\n";
			mensaje += "Precio promedio\t: S/. " + precioPromedio + "\n";
			mensaje += "Comparación\t\t: " + comparacion + " que el promedio";
		}

		return mensaje;
	}

	static String compararDouble(double primerValor, double segundoValor) {
		double diferencia = primerValor - segundoValor;

		if (primerValor > segundoValor) {
			return Math.abs(diferencia) + " mas";
		} else {
			return Math.abs(diferencia) + " menos";
		}
	}

	static String compararInt(int primerValor, int segundoValor) {
		int diferencia = primerValor - segundoValor;

		if (primerValor > segundoValor) {
			return Math.abs(diferencia) + " mas";
		} else {
			return Math.abs(diferencia) + " menos";
		}
	}

	static String getResporteTipo3() {
		String mensaje = "COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA";

		for (int index = 0; index < productos.length; index++) {

			String modelo = productos[index].getModelo();
			int cantidadCajasVendidas = productos[index].getCantidadCajasVendidas();
			//int cantidadOptima = cantidadOptima;
			String comparacion = compararInt(cantidadCajasVendidas, cantidadOptima);

			mensaje += "\n\nModelo\t\t: " + modelo + "\n";
			mensaje += "Cantidad de cajas vendidas\t: " + cantidadCajasVendidas + "\n";
			mensaje += "Cantidad óptima\t: " + cantidadOptima + "\n";
			mensaje += "Comparación\t\t: " + comparacion + " que la cantidad óptima";
		}

		return mensaje;
	}

	static String getResporteTipo4() {
		double precioPromedioTotal = getPrecioPromedioDeTodosProductos();
		double precioMayor = getPrecioMayorProductos();
		double precioMenor = getPrecioMenorProductos();

		String mensaje = "ESTADISTICA SOBRE EL PRECIO\n\n";
		mensaje += "Precio promedio\t: S/. " + precioPromedioTotal + "\n";
		mensaje += "Precio mayor\t\t: S/. " + precioMayor + "\n";
		mensaje += "Precio menor\t\t: S/. " + precioMenor;

		return mensaje;
	}

	static double getPrecioPromedioDeTodosProductos() {
		List<Double> precios = obtenerListaPrecioProductos();

		double promedio = precios.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		return promedio;
	}

	static double getPrecioMayorProductos() {
		return Collections.max(obtenerListaPrecioProductos());
	}

	static double getPrecioMenorProductos() {
		return Collections.min(obtenerListaPrecioProductos());
	}

	// SECCION CONFIGURACIÓN
	// SECCION CONFIGURACIÓN
	// SECCION CONFIGURACIÓN

	static double[] getPorcentajesDescuento() {
		double[] valores = { porcentaje1, porcentaje2, porcentaje3, porcentaje4 };
		return valores;
	}

	static String getTipoObsequio() {
		return tipoObsequio;
	}

	static int[] getCantidadesObsequios() {
		int[] valores = { obsequioCantidad1, obsequioCantidad2, obsequioCantidad3 };
		return valores;
	}

	static int getCantidadOptima() {
		return cantidadOptima;
	}

	static double getCuotaDiaria() {
		return cuotaDiaria;
	}

	static void setPorcentajesDescuento(double[] nuevosValores) {
		porcentaje1 = nuevosValores[0];
		porcentaje2 = nuevosValores[1];
		porcentaje3 = nuevosValores[2];
		porcentaje4 = nuevosValores[3];
	}

	static void setTipoObsequio(String nombreObsequio) {
		tipoObsequio = nombreObsequio;
	}

	static void setCantidadesObsequios(int[] nuevosValores) {
		obsequioCantidad1 = nuevosValores[0];
		obsequioCantidad2 = nuevosValores[1];
		obsequioCantidad3 = nuevosValores[2];
	}

	static void setCantidadOptima(int valor) {
		cantidadOptima = valor;
	}

	static void setCuotaDiaria(double valor) {
		cuotaDiaria = valor;
	}


}
