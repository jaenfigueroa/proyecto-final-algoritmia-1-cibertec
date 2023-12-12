package AdministradorTienda;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarCermico;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_12;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblNewLabel;

	// PRODUCTOS
	Producto[] productos = { new Producto("Cinza Plus", 92.56, 62.0, 62.0, 8, 6, "/azulejos/azulejo-1.jpg"),
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
			new Producto("Velvet Essence", 73, 63, 63, 7.2, 10, "/azulejos/azulejo-20.jpg") };

	// Porcentajes de descuento
	double porcentaje1 = 7.5;
	double porcentaje2 = 10.0;
	double porcentaje3 = 12.5;
	double porcentaje4 = 15.0;

	// Obsequio
	String tipoObsequio = "Lapicero";

	int obsequioCantidad1 = 2;
	int obsequioCantidad2 = 3;
	int obsequioCantidad3 = 4;

	// cantidades por defecto
	int cantidadOptima = 10;
	double cuotaDiaria = 30000;

	// contadores y acumuladores
	int cantidadVentasRealizadas = 0;
	int importeTotalAcumulado = 0, porcentajeCuotaDiaria = 0;
	private JPanel panel;

	/**
	 * lanzar la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFrame frame = new AppFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AppFrame.class.getResource("/icons/store-32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 638);

		setTitle("Panel de administración de cerámica Italia");

		// Centra la ventana en la pantalla
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(crearImagen(872, 545, "/italia/local.jpg"));
		lblNewLabel.setBounds(0, 81, 872, 520);
		contentPane.add(lblNewLabel);

		panel = new JPanel();
		panel.setBackground(new Color(11, 34, 57));
		panel.setBounds(0, 0, 872, 82);
		contentPane.add(panel);
		panel.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(21, 10, 723, 62);
		panel.add(menuBar);
		menuBar.setBorderPainted(false);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setForeground(new Color(0, 0, 255));
		menuBar.setBackground(new Color(11, 34, 57));

		mnNewMenu = new JMenu("  Archivo  ");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/carpeta.png")));
		mnNewMenu.setFont(new Font("Dialog", Font.PLAIN, 17));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/delete-32.png")));
		mntmNewMenuItem.setFont(new Font("Dialog", Font.PLAIN, 17));
		mntmNewMenuItem.setBackground(new Color(240, 240, 240));
		mntmNewMenuItem.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// mostrar mensaje de advertencia y guardar el resultado
				int cerrarAplicacion = JOptionPane.showOptionDialog(rootPane,
						"Se va a cerrar la aplicación ¿estas seguro?", "Confirma acción", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null, null, null);

				// si el valor escogigo es YES_OPTION
				if (cerrarAplicacion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		mnMantenimiento = new JMenu("  Mantenimiento  ");
		mnMantenimiento.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/reporte.png")));
		mnMantenimiento.setFont(new Font("Dialog", Font.PLAIN, 16));
		mnMantenimiento.setForeground(new Color(255, 255, 255));
		menuBar.add(mnMantenimiento);

		mntmConsultarCermico = new JMenuItem("Consultar cerámico");
		mntmConsultarCermico.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/idea-32.png")));
		mntmConsultarCermico.setFont(new Font("Dialog", Font.PLAIN, 17));
		mntmConsultarCermico.setForeground(new Color(0, 0, 255));
		mntmConsultarCermico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProductoFrame frame = new ConsultarProductoFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);

			}
		});
		mnMantenimiento.add(mntmConsultarCermico);

		mntmNewMenuItem_4 = new JMenuItem("Modificar cerámico");
		mntmNewMenuItem_4.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/notes-32.png")));
		mntmNewMenuItem_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		mntmNewMenuItem_4.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ModificarProductoFrame frame = new ModificarProductoFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmNewMenuItem_4);

		mntmNewMenuItem_5 = new JMenuItem("Listar cerámicos");
		mntmNewMenuItem_5.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/books-32.png")));
		mntmNewMenuItem_5.setFont(new Font("Dialog", Font.PLAIN, 17));
		mntmNewMenuItem_5.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProductosFrame frame = new ListarProductosFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmNewMenuItem_5);

		mnNewMenu_2 = new JMenu("  Ventas  ");
		mnNewMenu_2.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/credit-48.png")));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_6 = new JMenuItem("Vender");
		mntmNewMenuItem_6.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/shopping-32.png")));
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_6.setForeground(new Color(0, 0, 255));

		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VenderFrame frame = new VenderFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);

		mntmNewMenuItem_7 = new JMenuItem("Generar reportes");
		mntmNewMenuItem_7.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/bar-32.png")));
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_7.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarReportesFrame frame = new GenerarReportesFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);

		mnNewMenu_3 = new JMenu("  Configuración  ");
		mnNewMenu_3.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/settings-48.png")));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_3);

		mntmNewMenuItem_9 = new JMenuItem("Configurar descuentos");
		mntmNewMenuItem_9.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/pig-32.png")));
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_9.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarDescuentosFrame frame = new ConfigurarDescuentosFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);

		mntmNewMenuItem_10 = new JMenuItem("Configurar obsequios");
		mntmNewMenuItem_10.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/gift-32.png")));
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_10.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarObsequiosFrame frame = new ConfigurarObsequiosFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);

		mntmNewMenuItem_11 = new JMenuItem("Configurar cantidad óptima");
		mntmNewMenuItem_11.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/money-32.png")));
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_11.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarCantidadOptimaFrame frame = new ConfigurarCantidadOptimaFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);

		mntmNewMenuItem_1 = new JMenuItem("Configurar cuota diaria");
		mntmNewMenuItem_1.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/briefcase-32.png")));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_1.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarCuotaDiariaFrame frame = new ConfigurarCuotaDiariaFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);

		mnNewMenu_1 = new JMenu("  Ayuda");
		mnNewMenu_1.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/help-48.png")));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem_12 = new JMenuItem("Acerca de la Tienda");
		mntmNewMenuItem_12.setIcon(new ImageIcon(AppFrame.class.getResource("/icons/store-32.png")));
		mntmNewMenuItem_12.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_12.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AcerdaDeTiendaFrame frame = new AcerdaDeTiendaFrame(AppFrame.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_12);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/// UTILIDADES
	/// UTILIDADES
	/// UTILIDADES
	/// UTILIDADES

	double getPorcentajeDescuento(int cantidadCajas) {
		double procentajeDescuento = 0;

		if (cantidadCajas >= 1 && cantidadCajas <= 5) {
			procentajeDescuento = porcentaje1;
		} else if (cantidadCajas <= 10) {
			procentajeDescuento = porcentaje2;
		} else if (cantidadCajas <= 15) {
			procentajeDescuento = porcentaje3;
		} else {
			procentajeDescuento = porcentaje4;
		}

		return procentajeDescuento;
	}

	int getCantidadObsequios(int UnidadesAdquiridas) {
		int cantidadObsequios = 0;

		if (UnidadesAdquiridas >= 1 && UnidadesAdquiridas <= 5) {
			cantidadObsequios = obsequioCantidad1;
		} else if (UnidadesAdquiridas <= 10) {
			cantidadObsequios = obsequioCantidad2;
		} else {
			cantidadObsequios = obsequioCantidad3;
		}

		return cantidadObsequios;
	}

	ImageIcon crearImagen(int ancho, int alto, String rutaRelativa) {
		ImageIcon icon = new ImageIcon(AppFrame.class.getResource(rutaRelativa));

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
	String generateListadoProductos() {
		String mensaje = "LISTADO DE CERÄMICOS";

		for (int index = 0; index < this.productos.length; index++) {
			mensaje += "\n\nModelo\t: " + this.productos[index].modelo + "\n";
			mensaje += "Precio\t: S/. " + this.productos[index].precio + "\n";
			mensaje += "Ancho (cm)\t: " + this.productos[index].ancho + " cm\n";
			mensaje += "Largo (cm)\t: " + this.productos[index].largo + " cm\n";
			mensaje += "Espesor (mm)\t: " + this.productos[index].espesor + " mm\n";
			mensaje += "Contenido\t: " + this.productos[index].contenido + " unidades";
		}

		return mensaje;
	}

	String[] getModelosDeProductos() {
		List<String> items = new ArrayList<>();

		for (int index = 0; index < productos.length; index++) {
			items.add(productos[index].modelo);
		}

		// convertir de List<String> a String[]
		return items.toArray(new String[0]);
	}

	List<Double> getListaPrecioProductos() {
		List<Double> precios = new ArrayList<Double>();

		// recorrer los productos y solo obtener un array de los precios
		for (int index = 0; index < productos.length; index++) {
			precios.add(productos[index].precio);
		}

		return precios;
	}

	// SECCION VENDER
	// SECCION VENDER
	// SECCION VENDER
	// SECCION VENDER

	void verificar5ventas() {
		int cantidadVentasTotales = 0;
		boolean multiploDe5 = false;

		for (int index = 0; index < productos.length; index++) {
			cantidadVentasTotales += productos[index].cantidadVentas;
		}

		multiploDe5 = cantidadVentasTotales % 5 == 0;

		if (cantidadVentasTotales > 0 && multiploDe5) {

			// declaracion de variables
			double importeAcumulado = 0, porcentajeDeLaCuotaDiaria = 0;

			// obtener valores totales
			for (int index = 0; index < productos.length; index++) {
				importeAcumulado += productos[index].importeTotalVendido;
			}

			porcentajeDeLaCuotaDiaria = getPorcentajeCuotaDiariaRespectoImporteTotal(importeAcumulado);

			mostrarAviso5ventas(cantidadVentasTotales, importeAcumulado, porcentajeDeLaCuotaDiaria);
		}
	}

	void mostrarAviso5ventas(int cantidadVentasTotales, double importeAcumulado, double porcentajeDeLaCuotaDiaria) {

		String mensaje = "Venta Nro. " + cantidadVentasTotales + "\n";
		mensaje += "Importe total general acumulado: S/. " + importeAcumulado + "\n";
		mensaje += "Porcentaje de la cuota diaria: " + porcentajeDeLaCuotaDiaria + " %";

		JOptionPane.showMessageDialog(rootPane, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
	}

	Double getPorcentajeCuotaDiariaRespectoImporteTotal(double cantidadAcumulada) {
		return (100 * cantidadAcumulada) / cuotaDiaria;
	}

	// SECCION GENERAR REPORTES
	// SECCION GENERAR REPORTES
	// SECCION GENERAR REPORTES

	String getResporteTipo1() {
		String mensaje = "VENTAS POR MODELO";

		for (int index = 0; index < this.productos.length; index++) {
			mensaje += "\n\nModelo\t\t: " + this.productos[index].modelo + "\n";
			mensaje += "Cantidad de ventas\t: " + this.productos[index].cantidadVentas + "\n";
			mensaje += "Cantidad de cajas vendidas\t: " + this.productos[index].cantidadCajasVendidas + "\n";
			mensaje += "Importe total vendido\t: S/. " + this.productos[index].importeTotalVendido + "\n";
			mensaje += "Aporte a la cuota diaria\t: "
					+ getPorcentajeCuotaDiariaRespectoImporteTotal(this.productos[index].importeTotalVendido) + " %";
		}

		return mensaje;
	}

	String getResporteTipo2() {
		String mensaje = "COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO";

		for (int index = 0; index < this.productos.length; index++) {

			String modelo = this.productos[index].modelo;
			double precio = this.productos[index].precio;
			double precioPromedio = this.productos[index].getPrecioPromedio();
			String comparacion = compararDouble(precio, precioPromedio);

			mensaje += "\n\nModelo\t\t: " + modelo + "\n";
			mensaje += "Precio\t\t: S/. " + precio + "\n";
			mensaje += "Precio promedio\t: S/. " + precioPromedio + "\n";
			mensaje += "Comparación\t\t: " + comparacion + " que el promedio";
		}

		return mensaje;
	}

	String compararDouble(double primerValor, double segundoValor) {
		double diferencia = primerValor - segundoValor;

		if (primerValor > segundoValor) {
			return Math.abs(diferencia) + " mas";
		} else {
			return Math.abs(diferencia) + " menos";
		}
	}

	String compararInt(int primerValor, int segundoValor) {
		int diferencia = primerValor - segundoValor;

		if (primerValor > segundoValor) {
			return Math.abs(diferencia) + " mas";
		} else {
			return Math.abs(diferencia) + " menos";
		}
	}

	String getResporteTipo3() {
		String mensaje = "COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA";

		for (int index = 0; index < this.productos.length; index++) {

			String modelo = this.productos[index].modelo;
			int cantidadCajasVendidas = this.productos[index].cantidadCajasVendidas;
			int cantidadOptima = this.cantidadOptima;
			String comparacion = compararInt(cantidadCajasVendidas, cantidadOptima);

			mensaje += "\n\nModelo\t\t: " + modelo + "\n";
			mensaje += "Cantidad de cajas vendidas\t: " + cantidadCajasVendidas + "\n";
			mensaje += "Cantidad óptima\t: " + cantidadOptima + "\n";
			mensaje += "Comparación\t\t: " + comparacion + " que la cantidad óptima";
		}

		return mensaje;
	}

	String getResporteTipo4() {
		double precioPromedioTotal = getPrecioPromedioDeTodosProductos();
		double precioMayor = getPrecioMayorProductos();
		double precioMenor = getPrecioMenorProductos();

		String mensaje = "ESTADISTICA SOBRE EL PRECIO\n\n";
		mensaje += "Precio promedio\t: S/. " + precioPromedioTotal + "\n";
		mensaje += "Precio mayor\t\t: S/. " + precioMayor + "\n";
		mensaje += "Precio menor\t\t: S/. " + precioMenor;

		return mensaje;
	}

	double getPrecioPromedioDeTodosProductos() {
		List<Double> precios = getListaPrecioProductos();

		double promedio = precios.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		return promedio;
	}

	double getPrecioMayorProductos() {
		return Collections.max(getListaPrecioProductos());
	}

	double getPrecioMenorProductos() {
		return Collections.min(getListaPrecioProductos());
	}

	// SECCION CONFIGURACIÓN
	// SECCION CONFIGURACIÓN
	// SECCION CONFIGURACIÓN

	double[] getPorcentajesDescuento() {
		double[] valores = { porcentaje1, porcentaje2, porcentaje3, porcentaje4 };
		return valores;
	}

	String getTipoObsequio() {
		return tipoObsequio;
	}

	int[] getCantidadesObsequios() {
		int[] valores = { obsequioCantidad1, obsequioCantidad2, obsequioCantidad3 };
		return valores;
	}

	int getCantidadOptima() {
		return cantidadOptima;
	}

	double getCuotaDiaria() {
		return cuotaDiaria;
	}

	void setPorcentajesDescuento(double[] valores) {
		porcentaje1 = valores[0];
		porcentaje2 = valores[1];
		porcentaje3 = valores[2];
		porcentaje4 = valores[3];
	}

	void setTipoObsequio(String nombreObsequio) {
		this.tipoObsequio = nombreObsequio;
	}

	void setCantidadesObsequios(int[] valores) {
		obsequioCantidad1 = valores[0];
		obsequioCantidad2 = valores[1];
		obsequioCantidad3 = valores[2];
	}

	void setCantidadOptima(int valor) {
		cantidadOptima = valor;
	}

	void setCuotaDiaria(double valor) {
		cuotaDiaria = valor;
	}
}