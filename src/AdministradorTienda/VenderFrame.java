package AdministradorTienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class VenderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JTextField tf_precio;
	private JLabel lblNewLabel_2;
	private JTextField tf_cantidad;
	private JButton btn_vender;
	private JButton btn_cerrar;
	private JComboBox<String> cb_modelo;
	private JTextArea ta_resultados;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lbl_imagen;
	private JButton btn_vender_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;

	int cantidadCajas = 0;
	
	int productoSeleccionadoIndex = 0;
	Producto productoSeleccionado = MainApp.getGestorProductos().getProducto(productoSeleccionadoIndex);
	Venta ventaActual;
	
	String boleta = "";

	/**
	 * Create the frame.
	 */
	public VenderFrame() {
		setTitle("Vender");
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VenderFrame.class.getResource("/icons/shopping-32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 563);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(169, 10, 694, 506);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(235, 38, 81, 25);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(235, 81, 81, 13);
		panel_2.add(lblPrecio);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tf_precio = new JTextField();
		tf_precio.setBounds(361, 73, 177, 25);
		panel_2.add(tf_precio);
		tf_precio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_precio.setEditable(false);
		tf_precio.setColumns(10);

		lblNewLabel_2 = new JLabel("Cantidad (cajas)");
		lblNewLabel_2.setBounds(235, 108, 118, 25);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tf_cantidad = new JTextField();
		tf_cantidad.setBounds(361, 108, 177, 25);
		panel_2.add(tf_cantidad);
		tf_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_cantidad.setColumns(10);

		btn_vender = new JButton("Vender");
		btn_vender.setBounds(570, 81, 105, 33);
		panel_2.add(btn_vender);
		btn_vender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_vender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				limpiarCampoResultado();
				venderProducto();
			}
		});

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setBounds(570, 38, 105, 33);
		panel_2.add(btn_cerrar);
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		cb_modelo = new JComboBox<>();
		cb_modelo.setBounds(361, 38, 177, 24);
		panel_2.add(cb_modelo);
		cb_modelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productoSeleccionadoIndex = cb_modelo.getSelectedIndex();
				productoSeleccionado = MainApp.getGestorProductos().getProducto(productoSeleccionadoIndex);
				mostrarDatosProducto();
			}
		});

		cb_modelo.setModel(new DefaultComboBoxModel<>(MainApp.getGestorProductos().obtenerListaModelos()));

		panel = new JPanel();
		panel.setBounds(21, 24, 190, 190);
		panel_2.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		lbl_imagen = new JLabel("");
		lbl_imagen.setBounds(10, 10, 170, 170);
		panel.add(lbl_imagen);

		panel_1 = new JPanel();
		panel_1.setBounds(21, 224, 654, 256);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(null);

		ta_resultados = new JTextArea();
		ta_resultados.setBounds(10, 10, 624, 236);
		panel_1.add(ta_resultados);
		ta_resultados.setEditable(false);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 16));

		btn_vender_1 = new JButton("Limpiar");
		btn_vender_1.setBounds(570, 128, 105, 33);
		panel_2.add(btn_vender_1);
		btn_vender_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_cantidad.setText("");
				ta_resultados.setText("");
				cb_modelo.setSelectedIndex(0);
			}
		});
		btn_vender_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VenderFrame.class.getResource("/icons/shopping-128.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 267, 142, 150);
		contentPane.add(lblNewLabel_1);

		// mostrar precio del producto seleccionado
		mostrarDatosProducto();
	}

	void mostrarDatosProducto() {
		double precio = productoSeleccionado.getPrecio();
		String imagen = productoSeleccionado.getImagen();

		tf_precio.setText(Double.toString(precio));
		lbl_imagen.setIcon(Utilidades.crearImagen(170, 170, imagen));
	}
	
	void venderProducto() {
		try {
			// Leer valores
			cantidadCajas = Integer.parseInt(tf_cantidad.getText());
			
			// realizar la venta
			ventaActual = new Venta(productoSeleccionado, cantidadCajas );
		
			// Actualizar contadores del producto despues de la venta
			productoSeleccionado.actulizarContadoresDespuesVenta(cantidadCajas, ventaActual.getImportePagar());
			
			// generar la boleta
			boleta = ventaActual.generarBoleta();

			// mostra mensaje de exito
			JOptionPane.showMessageDialog(
					rootPane,
					"¡Venta realizada exitosamente!",
					"Exito",
					JOptionPane.INFORMATION_MESSAGE
				);

			mostrarBoletaAlCliente();
	
			verificarVentaMultiplo5();

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(
					rootPane,
					"La cantidad ingresada no es válida, revise nuevamente por favor", "Ups, ocurrió un error",
					JOptionPane.ERROR_MESSAGE
				);

			limpiarCampoResultado();
		}
	}
	
	void verificarVentaMultiplo5() { // VERIFICAR, CREO QUE YA TENGO LA CANTIDAD DE VENTAS COMO VARIABLE GLOBAL
		int cantidadVentasTotales = ventaActual.getNumeroVenta();
		boolean multiploDe5 = ventaActual.verificarVentaMultiplo5();


		if (multiploDe5 && cantidadVentasTotales > 0) {

			// declaracion de variables
			double importeAcumulado = MainApp.getGestorProductos().calcularImporteAcumuladoTotal();
			double porcentajeDeLaCuotaDiaria = Utilidades.calcularPorcentajeCuotaDiariaRespectoImporteTotal(importeAcumulado);

			mostrarAviso5ventas(cantidadVentasTotales, importeAcumulado, porcentajeDeLaCuotaDiaria);
		}
	}

	void mostrarAviso5ventas(int cantidadVentasTotales, double importeAcumulado, double porcentajeDeLaCuotaDiaria) {

		String mensaje = "Venta Nro. " + cantidadVentasTotales + "\n";
		mensaje += "Importe total general acumulado: S/. " + importeAcumulado + "\n";
		mensaje += "Porcentaje de la cuota diaria: " + porcentajeDeLaCuotaDiaria + " %";

		JOptionPane.showMessageDialog(null, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
	}

	void mostrarBoletaAlCliente() {
		ta_resultados.setText(boleta);
	}
	
	void limpiarCampoResultado() {
		ta_resultados.setText("");
	}
}
