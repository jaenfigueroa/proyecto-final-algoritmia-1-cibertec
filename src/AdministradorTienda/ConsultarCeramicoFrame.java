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

public class ConsultarCeramicoFrame extends JFrame {

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


	private App appReference;
	
	/**
	 * Create the frame.
	 */
	public ConsultarCeramicoFrame(App appReference) {
		
		this.appReference = appReference;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Consultar ceramico");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel);

		cb_modelo = new JComboBox<>();
		cb_modelo.setFont(new Font("Dialog", Font.PLAIN, 14));
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatosDelProducto();
			}
		});
		cb_modelo.setModel(new DefaultComboBoxModel<>(appReference.getModelosDeProductos()));
		cb_modelo.setBounds(115, 6, 201, 21);
		contentPane.add(cb_modelo);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 39, 66, 13);
		contentPane.add(lblPrecio);

		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_precio.setEditable(false);
		tf_precio.setBounds(113, 37, 203, 21);
		contentPane.add(tf_precio);
		tf_precio.setColumns(10);

		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setBounds(10, 74, 66, 13);
		contentPane.add(lblAnchocm);

		tf_ancho = new JTextField();
		tf_ancho.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_ancho.setEditable(false);
		tf_ancho.setColumns(10);
		tf_ancho.setBounds(113, 72, 203, 21);
		contentPane.add(tf_ancho);

		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setBounds(10, 108, 66, 13);
		contentPane.add(lblLargocm);

		tf_largo = new JTextField();
		tf_largo.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_largo.setEditable(false);
		tf_largo.setColumns(10);
		tf_largo.setBounds(113, 106, 203, 21);
		contentPane.add(tf_largo);

		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setBounds(10, 139, 93, 13);
		contentPane.add(lblEspesormm);

		tf_espesor = new JTextField();
		tf_espesor.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_espesor.setEditable(false);
		tf_espesor.setColumns(10);
		tf_espesor.setBounds(113, 136, 203, 21);
		contentPane.add(tf_espesor);

		lblPrecios = new JLabel("Contenido");
		lblPrecios.setBounds(10, 170, 66, 13);
		contentPane.add(lblPrecios);

		tf_contenido = new JTextField();
		tf_contenido.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_contenido.setEditable(false);
		tf_contenido.setColumns(10);
		tf_contenido.setBounds(113, 168, 203, 21);
		contentPane.add(tf_contenido);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(326, 6, 100, 21);
		contentPane.add(btn_cerrar);
		
		// Mostrar los datos del primer item por defecto
		mostrarDatosDelProducto();
	}
	
	// FUNCIONES
	void mostrarDatosDelProducto() {
		// recuperar valor del combobox
		int indexProducto = cb_modelo.getSelectedIndex();

		// Traer el producto por su index
		Producto productoItem = appReference.productos[indexProducto];

		// Mostrar datos del producto
		tf_precio.setText(Double.toString(productoItem.precio));
		tf_ancho.setText(Double.toString(productoItem.ancho));
		tf_largo.setText(Double.toString(productoItem.largo));
		tf_espesor.setText(Double.toString(productoItem.espesor));
		tf_contenido.setText(Integer.toString(productoItem.contenido));
	}

}
