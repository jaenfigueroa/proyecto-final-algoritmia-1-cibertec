package AdministradorTienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class ConsultarProductoFrame extends DashboardFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox<String> cb_modelo;
	private JLabel lblPrecio;
	private JTextField tf_precio;
	private JLabel lblAnchocm;
	private JTextField tf_ancho;
	private JLabel lblLargocm;
	private JTextField tf_largo;
	private JLabel lblEspesormm;
	private JTextField tf_espesor;
	private JLabel lblPrecios;
	private JTextField tf_contenido;
	private JButton btn_cerrar;
	private JLabel lbl_imagen;
	private JPanel panel;
	
	private int productoSeleccionadoIndex;
	
	/**
	 * Create the frame.
	 */
	public ConsultarProductoFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarProductoFrame.class.getResource("/icons/idea-32.png")));		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 335);
		setTitle("Consultar cerámico");
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setBounds(292, 27, 103, 29);
		contentPane.add(lblNewLabel);

		cb_modelo = new JComboBox<>();
		cb_modelo.setFont(new Font("Dialog", Font.PLAIN, 16));
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				productoSeleccionadoIndex = cb_modelo.getSelectedIndex();
				
				mostrarDatosProducto();
			}
		});
		cb_modelo.setModel(new DefaultComboBoxModel<>(MainApp.getGestorProductos().obtenerListaModelos()));
		cb_modelo.setBounds(408, 27, 190, 29);
		contentPane.add(cb_modelo);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPrecio.setBounds(292, 70, 103, 29);
		contentPane.add(lblPrecio);

		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_precio.setEditable(false);
		tf_precio.setBounds(406, 70, 192, 29);
		contentPane.add(tf_precio);
		tf_precio.setColumns(10);

		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAnchocm.setBounds(292, 115, 103, 29);
		contentPane.add(lblAnchocm);

		tf_ancho = new JTextField();
		tf_ancho.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_ancho.setEditable(false);
		tf_ancho.setColumns(10);
		tf_ancho.setBounds(406, 115, 192, 29);
		contentPane.add(tf_ancho);

		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblLargocm.setBounds(292, 154, 103, 32);
		contentPane.add(lblLargocm);

		tf_largo = new JTextField();
		tf_largo.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_largo.setEditable(false);
		tf_largo.setColumns(10);
		tf_largo.setBounds(406, 157, 192, 29);
		contentPane.add(tf_largo);

		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEspesormm.setBounds(292, 202, 103, 29);
		contentPane.add(lblEspesormm);

		tf_espesor = new JTextField();
		tf_espesor.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_espesor.setEditable(false);
		tf_espesor.setColumns(10);
		tf_espesor.setBounds(406, 202, 192, 29);
		contentPane.add(tf_espesor);

		lblPrecios = new JLabel("Contenido");
		lblPrecios.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPrecios.setBounds(292, 241, 103, 31);
		contentPane.add(lblPrecios);

		tf_contenido = new JTextField();
		tf_contenido.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_contenido.setEditable(false);
		tf_contenido.setColumns(10);
		tf_contenido.setBounds(406, 243, 192, 29);
		contentPane.add(tf_contenido);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_cerrar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(644, 27, 100, 29);
		contentPane.add(btn_cerrar);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 260, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl_imagen = new JLabel("");
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagen.setBounds(10, 10, 240, 240);
		panel.add(lbl_imagen);
		
		mostrarDatosProducto(); // Mostrar por defecto los datos del primer producto
	}
	
	// FUNCIONES
	private void mostrarDatosProducto() {

		// Traer el producto por su index
		Producto productoSeleccionado = MainApp.getGestorProductos().getProducto(productoSeleccionadoIndex);

		// Mostrar datos del producto
		tf_precio.setText(Double.toString(productoSeleccionado.getPrecio()));
		tf_ancho.setText(Double.toString(productoSeleccionado.getAncho()));
		tf_largo.setText(Double.toString(productoSeleccionado.getLargo()));
		tf_espesor.setText(Double.toString(productoSeleccionado.getEspesor()));
		tf_contenido.setText(Integer.toString(productoSeleccionado.getContenido()));
		
		lbl_imagen.setIcon(MainApp.crearImagen(240, 240, productoSeleccionado.getImagen()));
	}
}
