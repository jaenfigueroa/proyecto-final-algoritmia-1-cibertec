package utilidades;

import java.awt.Image;
import javax.swing.ImageIcon;

import clases.Tienda;
import frames.DashboardFrame;

public class Utilidades {
	
	public static double calcularPorcentajeDescuento(int cantidadCajas) {
		double procentajeDescuento = 0;

		if (cantidadCajas >= 1 && cantidadCajas <= 5) {
			procentajeDescuento = Tienda.getPorcentaje1();
		}
		else if (cantidadCajas <= 10) {
			procentajeDescuento = Tienda.getPorcentaje2();
		}
		else if (cantidadCajas <= 15) {
			procentajeDescuento = Tienda.getPorcentaje3();
		}
		else {
			procentajeDescuento = Tienda.getPorcentaje4();
		}

		return procentajeDescuento;
	}

	public static int calcularCantidadObsequios(int UnidadesAdquiridas) {
		int cantidadObsequios = 0;

		if (UnidadesAdquiridas >= 1 && UnidadesAdquiridas <= 5) {
			cantidadObsequios = Tienda.getObsequioCantidad1();
		}
		else if (UnidadesAdquiridas <= 10) {
			cantidadObsequios = Tienda.getObsequioCantidad2();
		}
		else {
			cantidadObsequios = Tienda.getObsequioCantidad3();
		}

		return cantidadObsequios;
	}
	
	public static Double calcularPorcentajeCuotaDiariaRespectoImporteTotal(double cantidadAcumulada) {
		return (100 * cantidadAcumulada) / Tienda.getCuotaDiaria();
	}
	
	// UTILIDADES USADO EN GENERAR REPORTES
	
	public static String compararDouble(double valor1, double valor2) {
		double diferenciAbs = Math.abs(valor1 - valor2);

		if (valor1 > valor2) {
			return diferenciAbs + " mas";
		} else {
			return diferenciAbs + " menos";
		}
	}

	public static String compararInt(int valor1, int valor2) {
		int diferenciaAbs = Math.abs(valor1 - valor2);

		if (valor1 > valor2) {
			return diferenciaAbs + " mas";
		} else {
			return diferenciaAbs + " menos";
		}
	}

	// OTROS

	public static ImageIcon crearImagen(int ancho, int alto, String rutaRelativa) {
		ImageIcon icon = new ImageIcon(DashboardFrame.class.getResource(rutaRelativa));

		// Obtener la imagen del icono y ajustar el tamaño
		Image image = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon con la imagen ajustada
		ImageIcon scaledIcon = new ImageIcon(image);

		return scaledIcon;
	}
}
