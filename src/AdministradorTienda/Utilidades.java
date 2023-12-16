/*package AdministradorTienda;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Utilidades {

	static ImageIcon crearImagen(int ancho, int alto, String rutaRelativa) {
		ImageIcon icon = new ImageIcon(DashboardFrame.class.getResource(rutaRelativa));

		// Obtener la imagen del icono y ajustar el tamaño
		Image image = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon con la imagen ajustada
		ImageIcon scaledIcon = new ImageIcon(image);

		return scaledIcon;
	}
}*/
