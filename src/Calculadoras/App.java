package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;

//PRODUCTO//////////
class Producto {
 public String modelo;
 public double precio;
 public double ancho;
 public double largo;
 public double espesor;
 public int contenido;
 
 public int cantidadVentas = 0;
 public int cantidadCajasVendidas = 0;
 public double importeTotalVendido = 0;

 public Producto(String modelo, double precio, double ancho, double largo, double espesor, int contenido) {
     this.modelo = modelo;
     this.precio = precio;
     this.ancho = ancho;
     this.largo = largo;
     this.espesor = espesor;
     this.contenido = contenido;
 }
}
/////////////////////

public class App extends JFrame {

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
	
	// PRODUCTOS
	Producto[] productos = {
            new Producto("Cinza Plus", 92.56, 62.0, 62.0, 8, 6),
            new Producto("Luxury", 42.77, 60, 60, 8.5, 4),
            new Producto("Austria", 52.45, 45, 45, 6.5, 12),
            new Producto("Yungay Mix", 55.89, 80, 120, 6.8, 9),
            new Producto("Thalía", 45, 45, 11.8, 7.2, 10)
        };

	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
 
	// Obsequio
	public static String tipoObsequio = "Lapicero";

	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;

	// Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;

	// Cuota diaria
	public static double cuotaDiaria = 30000;

	// PROPIOS
	int cantidadVentasRealizadas = 0;
	int importeTotalAcumulado = 0, procentajeCuotaDiaria = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 487);
		setTitle("Tienda 1.0");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(218, 218, 218));
		menuBar.setBounds(0, 0, 764, 36);
		contentPane.add(menuBar);

		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmConsultarCermico = new JMenuItem("Consultar cerámico");
		mntmConsultarCermico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCeramicoFrame frame = new ConsultarCeramicoFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);

			}
		});
		mnMantenimiento.add(mntmConsultarCermico);

		mntmNewMenuItem_4 = new JMenuItem("Modificar ceramico");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCeramicoFrame frame = new ModificarCeramicoFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmNewMenuItem_4);

		mntmNewMenuItem_5 = new JMenuItem("Listar cerámicos");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCeramicosFrame frame = new ListarCeramicosFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmNewMenuItem_5);

		mnNewMenu_2 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_6 = new JMenuItem("Vender");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VenderFrame frame = new VenderFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);

		mntmNewMenuItem_7 = new JMenuItem("Generar reportes");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarReportesFrame frame = new GenerarReportesFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);

		mnNewMenu_3 = new JMenu("Configuración");
		menuBar.add(mnNewMenu_3);

		mntmNewMenuItem_9 = new JMenuItem("Configurar descuentos");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarDescuentosFrame frame = new ConfigurarDescuentosFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);

		mntmNewMenuItem_10 = new JMenuItem("Configurar obsequios");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarObsequiosFrame frame = new ConfigurarObsequiosFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);

		mntmNewMenuItem_11 = new JMenuItem("Configurar cantidad óptima");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarCantidadOptimaFrame frame = new ConfigurarCantidadOptimaFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);

		mntmNewMenuItem_1 = new JMenuItem("Configurar cuota diaria");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarCuotaDiariaFrame frame = new ConfigurarCuotaDiariaFrame(App.this);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);

		mnNewMenu_1 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem_12 = new JMenuItem("Acerca de la Tienda");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcerdaDeFrame frame = new AcerdaDeFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_12);
	}
	
	// METODOS
	String[] getModelosDeProductos() {
		String[] items = {
				productos[0].modelo,
				productos[1].modelo,
				productos[2].modelo,
				productos[3].modelo,
				productos[4].modelo
			};
		
		return items;
	}
	
	Producto getProducto(int index){
		return this.productos[index];
	}
	
	void updateProducto(int productoIndex, Producto productoActualizado) {
		this.productos[productoIndex] = productoActualizado;
	}
	
	String generateListadoProductos() {
		String mensaje = "LISTADO DE CERÄMICOS\n\n";
		
       for (int index = 0; index < this.productos.length; index++) {
    	   mensaje += "Modelo\t: " + this.productos[index].modelo + "\n";
    	   mensaje += "Precio\t: S/. " + this.productos[index].precio + "\n";
    	   mensaje += "Ancho (cm)\t: " + this.productos[index].ancho + " cm\n";
    	   mensaje += "Largo (cm)\t: " + this.productos[index].largo + " cm\n";
    	   mensaje += "Espesor (mm)\t: " + this.productos[index].espesor + " mm\n";
    	   mensaje += "Contenido\t: " + this.productos[index].contenido + " unidades\n\n";
        }
		
		return mensaje;
	}
	
	double getPorcentajeDescuento(int cantidadCajas) {
		double procentajeDescuento = 0;
		
		if(cantidadCajas >= 1 && cantidadCajas <=5 ) {
			procentajeDescuento = porcentaje1;
		} else if(cantidadCajas <= 10) {
			procentajeDescuento = porcentaje2;
		} else if(cantidadCajas <= 15) {
			procentajeDescuento = porcentaje3;
		} else {
			procentajeDescuento = porcentaje4;
		}
		
		return procentajeDescuento;
	}
	
	int getCantidadObsequios(int UnidadesAdquiridas) {
		int cantidadObsequios =0;
		
		if(UnidadesAdquiridas >= 1 && UnidadesAdquiridas <= 5) {
			cantidadObsequios = obsequioCantidad1;
		} else if(UnidadesAdquiridas <= 10) {
			cantidadObsequios = obsequioCantidad2;
		} else {
			cantidadObsequios = obsequioCantidad3;
		}
		
		return cantidadObsequios;
	}
	
	Double getProcenteCoutaDiariaRespectoImporteTotal() {
		return (100 * importeTotalAcumulado) / cuotaDiaria;
	}
	
	void verificar5ventas() {
		if(cantidadVentasRealizadas % 5 == 0 && cantidadVentasRealizadas != 0) {
			String mensaje = "Venta Nro. " + cantidadVentasRealizadas + "\n";
			mensaje += "Importe total general acumulado: S/. " + importeTotalAcumulado + "\n";
			mensaje += "Porcentaje de la cuota diaria: " + this.getProcenteCoutaDiariaRespectoImporteTotal() + " %";
			
			JOptionPane.showMessageDialog(rootPane, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	void addVenta(int productoIndex, int cantidadCajas, double importePago) {
		productos[productoIndex].cantidadVentas++;
		productos[productoIndex].cantidadCajasVendidas += cantidadCajas;
		productos[productoIndex].importeTotalVendido += importePago;
	}
	
	// SECCION DE REPORTES

	String generarReporteVentasPorModelo() {
		String mensaje = "VENTAS POR MODELO\n\n";
		
		// Generar resultados
		
		// Generar mensaje usando los resultados	
		for (int index = 0; index < this.productos.length; index++) {
		   mensaje += "Modelo\t\t: " + this.productos[index].modelo + "\n";
		   mensaje += "Cantidad de ventas\t: " + 00 + "\n";
		   mensaje += "Cantidad de cajas vendidas\t: " + 00 + "\n";
		   mensaje += "Importe total vendido\t: S/. " + 00 + "\n";
		   mensaje += "Aporte a la cuota diaria\t: " + 00 + " %\n\n";
		}
		  
		return mensaje;
	}
	
	String generarReporteComparacionPreciosConPrecioPromedio() {
		String mensaje = "COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO\n\n";
		
		// Generar resultados
		
		// Generar mensaje usando los resultados		
		for (int index = 0; index < this.productos.length; index++) {
		   mensaje += "Modelo\t\t: " + this.productos[index].modelo + "\n";
		   mensaje += "Precio\t\t: S/. " + 00 + "\n";
		   mensaje += "Precio promedio\t: S/. " + 00 + "\n";
		   mensaje += "Comparación\t\t: " + 00 + "\n\n";
		}
		  
		return mensaje;
	}
	
	String generarReporteCajasVendidasCantidadOptima() {
		String mensaje = "COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA\n\n";
		
		// Generar resultados
		
		// Generar mensaje usando los resultados
		for (int index = 0; index < this.productos.length; index++) {
		   mensaje += "Modelo\t\t: " + this.productos[index].modelo + "\n";
		   mensaje += "Cantidad de cajas vendidas\t: " + 00 + "\n";
		   mensaje += "Cantidad óptima\t: " + 00 + "\n";
		   mensaje += "Comparación\t\t: " + 00 + "\n\n";
		}
		  
		return mensaje;
	}
	
	String generarReporteEstadisticaPrecio() {
		String mensaje = "ESTADISTICA SOBRE EL PRECIO\n\n";
		
		// Generar resultados
		
		// Generar mensaje usando los resultados		
		mensaje += "Precio promedio\t: S/. " + 00 + "\n";
		mensaje += "Precio mayor\t\t: S/. " + 00 + "\n";
		mensaje += "Precio menor\t\t: S/. " + 00;
		  
		return mensaje;
	}
	
	// SECCION CONFIGURACIÓN
	String getTipoObsequio() {
		return tipoObsequio;
	}

	double[] getPorcentajesDescuento() {
		double[] valores = {porcentaje1, porcentaje2, porcentaje3, porcentaje4};
		
		return valores;
	}
	
	int[] getCantidadesObsequios() {
		int[] valores = {obsequioCantidad1, obsequioCantidad2, obsequioCantidad3};
		
		return valores;
	}
	
	int getCantidadOptima() {
		return cantidadOptima;
	}
	
	double getCuotaDiaria() {
		return cuotaDiaria;
	}
	
	void setConfigurarPorcentajeDescuento(double[] valores) {
		porcentaje1 = valores[0];
		porcentaje2 = valores[1];
		porcentaje3 = valores[2];
		porcentaje4 = valores[3];
	}
	
	void setConfigurarObsequios(int[] valores) {
		obsequioCantidad1 = valores[0];
		obsequioCantidad2 = valores[1];
		obsequioCantidad3 = valores[2];
	}
	
	void setConfigurarCantidadOptima(int valor) {
		cantidadOptima = valor;
	}
	
	void setConfigurarCuotaDiaria(double valor) {
		cuotaDiaria = valor;
	}
}
