package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JComboBox cb_modelo;
	private JTextArea txtrCscscscs;
	private JTextArea ta_resultados;

	App appReference;
	
	Producto productoSeleccionado = null;
	int cantidadProductos = 0;
	
	double importeCompra=0, importeDescuento=0, importePagar=0;
	int cantidadObsequios=0;
	
	int productoIndex=0;
	

	/**
	 * Create the frame.
	 */
	public VenderFrame(App appReference) {
		this.appReference = appReference;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
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
				realizarVenta();
			}
		});
		btn_vender.setBounds(341, 10, 85, 21);
		contentPane.add(btn_vender);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(341, 39, 85, 21);
		contentPane.add(btn_cerrar);
		
		cb_modelo = new JComboBox();
		cb_modelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				productoIndex = cb_modelo.getSelectedIndex();
				mostrarPrecio(productoIndex);
			}
		});
		cb_modelo.setModel(new DefaultComboBoxModel(appReference.getModelosDeProductos()));
		cb_modelo.setBounds(91, 14, 177, 19);
		contentPane.add(cb_modelo);
		
		ta_resultados = new JTextArea();
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 14));
		ta_resultados.setBounds(10, 106, 416, 188);
		contentPane.add(ta_resultados);
		
		// mostrar precio del producto seleccionado por defecto
		mostrarPrecio(cb_modelo.getSelectedIndex());
	}
	
	void mostrarPrecio(int productoIndex) {
		productoSeleccionado = appReference.getProducto(productoIndex);
		
		tf_precio.setText(Double.toString(productoSeleccionado.precio));
	}
	
	void realizarVenta() {
		cantidadProductos = Integer.parseInt(tf_cantidad.getText());
		cantidadObsequios = appReference.getCantidadObsequios(cantidadProductos);
		
		calcularImportes();
		mostrarResultados();
		
		// aumentar el contador de ventas realizadas
		appReference.cantidadVentasRealizadas++;
		appReference.importeTotalAcumulado += importePagar;
		
		appReference.addVenta(productoIndex, cantidadObsequios, importeCompra);
		
		appReference.verificar5ventas();
	}
	
	void calcularImportes() {
		double porcentajeDescuento = appReference.getPorcentajeDescuento(cantidadProductos);
		
		importeCompra = cantidadProductos * productoSeleccionado.precio;
		importeDescuento = importeCompra * (porcentajeDescuento/100);
		importePagar = importeCompra - importeDescuento;
	}
	
	void mostrarResultados() {
		ta_resultados.setText("BOLETA DE VENTA\n\n");

		ta_resultados.append("Modelo\t\t: " + productoSeleccionado.modelo + " \n");
		ta_resultados.append("Precio\t\t: S/. " + productoSeleccionado.precio + " \n");
		ta_resultados.append("Cantidad adquirida\t: " + cantidadProductos + " \n");

		ta_resultados.append("Importe de compra\t: S/. " + importeCompra + " \n");
		ta_resultados.append("Importe de descuento\t: S/. " + importeDescuento + " \n");
		ta_resultados.append("Importe de pagar\t: S/. " + importePagar + "\n");
		ta_resultados.append("Tipo de obsequio\t: " + appReference.tipoObsequio + "\n");
		ta_resultados.append("Unidades obsequiadas\t: " + cantidadObsequios);
	}
}
