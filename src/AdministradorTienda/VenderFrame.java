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
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Create the frame.
	 */
	public VenderFrame(App appReference) {
		this.appReference = appReference;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 393);
		setTitle("Vender");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 14, 60, 13);
		contentPane.add(lblNewLabel);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 43, 60, 13);
		contentPane.add(lblPrecio);
		
		tf_precio = new JTextField();
		tf_precio.setEditable(false);
		tf_precio.setColumns(10);
		tf_precio.setBounds(91, 44, 177, 19);
		contentPane.add(tf_precio);
		
		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setBounds(10, 69, 60, 13);
		contentPane.add(lblNewLabel_2);
		
		tf_cantidad = new JTextField();
		tf_cantidad.setColumns(10);
		tf_cantidad.setBounds(91, 70, 177, 19);
		contentPane.add(tf_cantidad);
		
		btn_vender = new JButton("Vender");
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
					JOptionPane.showMessageDialog(rootPane,"Alguno de los campos ingresados no son válidos, revise nuevamente por favor", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}
		
			}
		});
		btn_vender.setBounds(341, 39, 85, 21);
		contentPane.add(btn_vender);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(341, 10, 85, 21);
		contentPane.add(btn_cerrar);
		
		cb_modelo = new JComboBox<>();
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productoSeleccionadoIndex = cb_modelo.getSelectedIndex();
				mostrarPrecio();
			}
		});

		cb_modelo.setModel(new DefaultComboBoxModel<>(appReference.getModelosDeProductos()));
		cb_modelo.setBounds(91, 14, 177, 19);
		contentPane.add(cb_modelo);
		
		ta_resultados = new JTextArea();
		ta_resultados.setEditable(false);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 14));
		ta_resultados.setBounds(10, 106, 416, 235);
		contentPane.add(ta_resultados);
		
		// mostrar precio del producto seleccionado por defecto
		mostrarPrecio();
	}
	
	void mostrarPrecio() {
		double precio = appReference.productos[productoSeleccionadoIndex].precio;

		tf_precio.setText(Double.toString(precio));
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
