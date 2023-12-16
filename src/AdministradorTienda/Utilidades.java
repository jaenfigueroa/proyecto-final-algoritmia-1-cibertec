package AdministradorTienda;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Utilidades {
	
	static double calcularPorcentajeDescuento(int cantidadCajas) {
		double procentajeDescuento = 0;

		if (cantidadCajas >= 1 && cantidadCajas <= 5) {
			procentajeDescuento = MainApp.getPorcentaje1();
		}
		else if (cantidadCajas <= 10) {
			procentajeDescuento = MainApp.getPorcentaje2();
		}
		else if (cantidadCajas <= 15) {
			procentajeDescuento = MainApp.getPorcentaje3();
		}
		else {
			procentajeDescuento = MainApp.getPorcentaje4();
		}

		return procentajeDescuento;
	}

	static int calcularCantidadObsequios(int UnidadesAdquiridas) {
		int cantidadObsequios = 0;

		if (UnidadesAdquiridas >= 1 && UnidadesAdquiridas <= 5) {
			cantidadObsequios = MainApp.getObsequioCantidad1();
		}
		else if (UnidadesAdquiridas <= 10) {
			cantidadObsequios = MainApp.getObsequioCantidad2();
		}
		else {
			cantidadObsequios = MainApp.getObsequioCantidad3();
		}

		return cantidadObsequios;
	}
	
	static Double calcularPorcentajeCuotaDiariaRespectoImporteTotal(double cantidadAcumulada) {
		return (100 * cantidadAcumulada) / MainApp.getCuotaDiaria();
	}
	
	// UTLIDADES USADO EN GENERAR REPORTES
	
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


	static ImageIcon crearImagen(int ancho, int alto, String rutaRelativa) {
		ImageIcon icon = new ImageIcon(DashboardFrame.class.getResource(rutaRelativa));

		// Obtener la imagen del icono y ajustar el tamaño
		Image image = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon con la imagen ajustada
		ImageIcon scaledIcon = new ImageIcon(image);

		return scaledIcon;
	}
}
