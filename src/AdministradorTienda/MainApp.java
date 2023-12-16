package AdministradorTienda;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainApp {

	// lanzar la aplicación
	public static void main(String[] args) {
		DashboardFrame frame = new DashboardFrame();
		frame.setVisible(true);
	}


	// lista de productos y gestor de productos
	
	static private Producto[] productos = {
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
	
	
	static private GestorProductos gestorProductos = new GestorProductos(productos);

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
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// GETTERS Y SETTERS
	
	public static GestorProductos getGestorProductos() {
		return gestorProductos;
	}
	
	////////////////

	public static double getPorcentaje1() {
		return porcentaje1;
	}

	public static void setPorcentaje1(double porcentaje1) {
		MainApp.porcentaje1 = porcentaje1;
	}

	public static double getPorcentaje2() {
		return porcentaje2;
	}

	public static void setPorcentaje2(double porcentaje2) {
		MainApp.porcentaje2 = porcentaje2;
	}

	public static double getPorcentaje3() {
		return porcentaje3;
	}

	public static void setPorcentaje3(double porcentaje3) {
		MainApp.porcentaje3 = porcentaje3;
	}

	public static double getPorcentaje4() {
		return porcentaje4;
	}

	public static void setPorcentaje4(double porcentaje4) {
		MainApp.porcentaje4 = porcentaje4;
	}
	
	public static String getTipoObsequio() {
		return tipoObsequio;
	}
	
	public static void setTipoObsequio(String nombreObsequio) {
		tipoObsequio = nombreObsequio;
	}

	public static int getObsequioCantidad1() {
		return obsequioCantidad1;
	}

	public static void setObsequioCantidad1(int obsequioCantidad1) {
		MainApp.obsequioCantidad1 = obsequioCantidad1;
	}

	public static int getObsequioCantidad2() {
		return obsequioCantidad2;
	}

	public static void setObsequioCantidad2(int obsequioCantidad2) {
		MainApp.obsequioCantidad2 = obsequioCantidad2;
	}

	public static int getObsequioCantidad3() {
		return obsequioCantidad3;
	}

	public static void setObsequioCantidad3(int obsequioCantidad3) {
		MainApp.obsequioCantidad3 = obsequioCantidad3;
	}

	public static int getCantidadOptima() {
		return cantidadOptima;
	}
	
	public static void setCantidadOptima(int valor) {
		cantidadOptima = valor;
	}

	public static double getCuotaDiaria() {
		return cuotaDiaria;
	}

	public static void setCuotaDiaria(double valor) {
		cuotaDiaria = valor;
	}

	
	// OTROS METODOS
	
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

	
	// OTROS
	
	/*static ImageIcon crearImagen(int ancho, int alto, String rutaRelativa) {
		ImageIcon icon = new ImageIcon(DashboardFrame.class.getResource(rutaRelativa));

		// Obtener la imagen del icono y ajustar el tamaño
		Image image = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon con la imagen ajustada
		ImageIcon scaledIcon = new ImageIcon(image);

		return scaledIcon;
	}*/
	

	// TODO: NO SE DONDE PONER
	
	static Double calcularPorcentajeCuotaDiariaRespectoImporteTotal(double cantidadAcumulada) {
		return (100 * cantidadAcumulada) / cuotaDiaria;
	}

}
