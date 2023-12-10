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

	App appReference;
	
	int productoSeleccionadoIndex =0;
	int cantidadProductos = 0, cantidadObsequios=0;
	
		
	// Declarar variables
	String nombre = "";
	double precio=0;
	int cantidad=0;
	
	double importeCompra=0, importeDescuento=0, importePagar=0;
	private JLabel lbl_imagen;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Create the frame.
	 */
	public VenderFrame(App appReference) {
		setResizable(false);
		this.appReference = appReference;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 505);
		
		setTitle("Vender");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(230, 29, 81, 13);
		contentPane.add(lblNewLabel);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(230, 58, 81, 13);
		contentPane.add(lblPrecio);
		
		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_precio.setEditable(false);
		tf_precio.setColumns(10);
		tf_precio.setBounds(311, 59, 177, 19);
		contentPane.add(tf_precio);
		
		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(230, 84, 81, 13);
		contentPane.add(lblNewLabel_2);
		
		tf_cantidad = new JTextField();
		tf_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_cantidad.setColumns(10);
		tf_cantidad.setBounds(311, 85, 177, 19);
		contentPane.add(tf_cantidad);
		
		btn_vender = new JButton("Vender");
		btn_vender.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
					appReference.productos[productoSeleccionadoIndex].vender(cantidadProductos, importePagar);
					
					// verificar si la venta es multiplo de 5, mostrar mensaje
					appReference.verificar5ventas();
					
					// mostra mensaje de exito
					JOptionPane.showMessageDialog(rootPane,"¡Venta realizada exitosamente!", "Exito",  JOptionPane.INFORMATION_MESSAGE);
					
					mostrarResultados();

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane,"La cantidad ingresada no es válida, revise nuevamente por favor", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}
		
			}
		});
		btn_vender.setBounds(549, 57, 105, 21);
		contentPane.add(btn_vender);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(549, 24, 105, 21);
		contentPane.add(btn_cerrar);
		
		cb_modelo = new JComboBox<>();
		cb_modelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productoSeleccionadoIndex = cb_modelo.getSelectedIndex();
				mostrarPrecio();
			}
		});

		cb_modelo.setModel(new DefaultComboBoxModel<>(appReference.getModelosDeProductos()));
		cb_modelo.setBounds(311, 29, 177, 19);
		contentPane.add(cb_modelo);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 200, 193);
		contentPane.add(panel);
		
		lbl_imagen = new JLabel("");
		panel.add(lbl_imagen);
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 213, 644, 245);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		ta_resultados = new JTextArea();
		ta_resultados.setBounds(10, 10, 624, 225);
		panel_1.add(ta_resultados);
		ta_resultados.setEditable(false);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 15));
		
		// mostrar precio del producto seleccionado por defecto
		mostrarPrecio();
	}
	
	void mostrarPrecio() {
		Producto producto = appReference.productos[productoSeleccionadoIndex];
		
		double precio = producto.precio;
		String imagen = producto.imagen;

		tf_precio.setText(Double.toString(precio));
		lbl_imagen.setIcon(appReference.crearImagen(180, 180, imagen));
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
