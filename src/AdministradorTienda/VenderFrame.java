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
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

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

	AppFrame appReference;
	
	int productoSeleccionadoIndex =0;
	int cantidadProductos = 0, cantidadObsequios=0;
	
		
	// Declarar variables
	String nombre = "";
	double precio=0;
	int cantidad=0;
	
	double importeCompra=0, importeDescuento=0, importePagar=0;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lbl_imagen;
	private JButton btn_vender_1;

	/**
	 * Create the frame.
	 */
	public VenderFrame(AppFrame appReference) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VenderFrame.class.getResource("/icons/shopping-32.png")));
		setResizable(false);
		this.appReference = appReference;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 511);
		
		setTitle("Vender");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(230, 24, 81, 25);
		contentPane.add(lblNewLabel);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(230, 67, 81, 13);
		contentPane.add(lblPrecio);
		
		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_precio.setEditable(false);
		tf_precio.setColumns(10);
		tf_precio.setBounds(317, 59, 177, 25);
		contentPane.add(tf_precio);
		
		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(230, 101, 81, 13);
		contentPane.add(lblNewLabel_2);
		
		tf_cantidad = new JTextField();
		tf_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_cantidad.setColumns(10);
		tf_cantidad.setBounds(317, 94, 177, 25);
		contentPane.add(tf_cantidad);
		
		btn_vender = new JButton("Vender");
		btn_vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_vender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_vender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					// Leer valores
					cantidadProductos = Integer.parseInt(tf_cantidad.getText());
					cantidadObsequios = appReference.getCantidadObsequios(cantidadProductos);
					
					nombre = cb_modelo.getSelectedItem().toString();
					precio = Double.parseDouble(tf_precio.getText());
					cantidad = Integer.parseInt(tf_cantidad.getText());
					
					calcularImportes();

					// ACTUALIZAR PRODUCTO ORIGINAL CONTADORES - REALIZAR LA COMPRA
					appReference.productos[productoSeleccionadoIndex].venderProducto(cantidadProductos, importePagar);
					
					// mostra mensaje de exito
					JOptionPane.showMessageDialog(rootPane,"¡Venta realizada exitosamente!", "Exito",  JOptionPane.INFORMATION_MESSAGE);
					
					mostrarResultados();
					
					// verificar si la venta es multiplo de 5, mostrar mensaje
					appReference.verificar5ventas();

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane,"La cantidad ingresada no es válida, revise nuevamente por favor", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}
		
			}
		});
		btn_vender.setBounds(549, 67, 105, 33);
		contentPane.add(btn_vender);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(549, 24, 105, 33);
		contentPane.add(btn_cerrar);
		
		cb_modelo = new JComboBox<>();
		cb_modelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productoSeleccionadoIndex = cb_modelo.getSelectedIndex();
				mostrarPrecio();
			}
		});

		cb_modelo.setModel(new DefaultComboBoxModel<>(appReference.getModelosDeProductos()));
		cb_modelo.setBounds(317, 24, 177, 24);
		contentPane.add(cb_modelo);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 190, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl_imagen = new JLabel("");
		lbl_imagen.setBounds(10, 10, 170, 170);
		panel.add(lbl_imagen);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 210, 644, 256);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		ta_resultados = new JTextArea();
		ta_resultados.setBounds(10, 10, 624, 236);
		panel_1.add(ta_resultados);
		ta_resultados.setEditable(false);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btn_vender_1 = new JButton("Limpiar");
		btn_vender_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_cantidad.setText("");
				ta_resultados.setText("");
				cb_modelo.setSelectedIndex(0);
			}
		});
		btn_vender_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_vender_1.setBounds(549, 114, 105, 33);
		contentPane.add(btn_vender_1);
		
		// mostrar precio del producto seleccionado por defecto
		mostrarPrecio();
	}
	
	void mostrarPrecio() {
		Producto producto = appReference.productos[productoSeleccionadoIndex];
		
		double precio = producto.precio;
		String imagen = producto.imagen;

		tf_precio.setText(Double.toString(precio));
		lbl_imagen.setIcon(appReference.crearImagen(170, 170, imagen));
	}
	
	void calcularImportes() {
		double porcentajeDescuento = appReference.getPorcentajeDescuento(cantidadProductos);
		
		importeCompra = cantidadProductos * precio;
		importeDescuento = importeCompra * (porcentajeDescuento/100);
		importePagar = importeCompra - importeDescuento;
	}
	
	void mostrarResultados() {
		ta_resultados.setText("BOLETA DE VENTA\n\n");

		ta_resultados.append("Modelo\t\t: " + nombre + " \n");
		ta_resultados.append("Precio\t\t: S/. " + precio + " \n");
		ta_resultados.append("Cantidad adquirida\t: " + cantidadProductos + " \n\n");

		ta_resultados.append("Importe de compra\t: S/. " + importeCompra + " \n");
		ta_resultados.append("Importe de descuento\t: S/. " + importeDescuento + " \n");
		ta_resultados.append("Importe de pagar\t: S/. " + importePagar + "\n\n");
		
		ta_resultados.append("Tipo de obsequio\t: " + appReference.getTipoObsequio() + "\n");
		ta_resultados.append("Unidades obsequiadas\t: " + cantidadObsequios);
	}
	
	void limpiarCampos() {
		ta_resultados.setText("");
	}

}
