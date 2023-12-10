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

public class ConsultarProductoFrame extends JFrame {

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
	private JLabel lbl_imagen;
	private JPanel panel;
	
	/**
	 * Create the frame.
	 */
	public ConsultarProductoFrame(App appReference) {
		setResizable(false);
		
		this.appReference = appReference;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 319);
		
		setTitle("Consultar cerámico");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        //setUndecorated(true);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(292, 31, 103, 13);
		contentPane.add(lblNewLabel);

		cb_modelo = new JComboBox<>();
		cb_modelo.setFont(new Font("Dialog", Font.PLAIN, 15));
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatosDelProducto();
			}
		});
		cb_modelo.setModel(new DefaultComboBoxModel<>(appReference.getModelosDeProductos()));
		cb_modelo.setBounds(398, 27, 190, 21);
		contentPane.add(cb_modelo);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(292, 60, 103, 13);
		contentPane.add(lblPrecio);

		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_precio.setEditable(false);
		tf_precio.setBounds(396, 58, 192, 21);
		contentPane.add(tf_precio);
		tf_precio.setColumns(10);

		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnchocm.setBounds(292, 95, 103, 13);
		contentPane.add(lblAnchocm);

		tf_ancho = new JTextField();
		tf_ancho.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_ancho.setEditable(false);
		tf_ancho.setColumns(10);
		tf_ancho.setBounds(396, 93, 192, 21);
		contentPane.add(tf_ancho);

		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLargocm.setBounds(292, 129, 103, 13);
		contentPane.add(lblLargocm);

		tf_largo = new JTextField();
		tf_largo.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_largo.setEditable(false);
		tf_largo.setColumns(10);
		tf_largo.setBounds(396, 127, 192, 21);
		contentPane.add(tf_largo);

		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEspesormm.setBounds(292, 160, 103, 13);
		contentPane.add(lblEspesormm);

		tf_espesor = new JTextField();
		tf_espesor.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_espesor.setEditable(false);
		tf_espesor.setColumns(10);
		tf_espesor.setBounds(396, 157, 192, 21);
		contentPane.add(tf_espesor);

		lblPrecios = new JLabel("Contenido");
		lblPrecios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecios.setBounds(292, 191, 103, 13);
		contentPane.add(lblPrecios);

		tf_contenido = new JTextField();
		tf_contenido.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_contenido.setEditable(false);
		tf_contenido.setColumns(10);
		tf_contenido.setBounds(396, 189, 192, 21);
		contentPane.add(tf_contenido);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(608, 27, 100, 21);
		contentPane.add(btn_cerrar);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 261, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl_imagen = new JLabel("");
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagen.setBounds(10, 10, 241, 230);
		panel.add(lbl_imagen);
		
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
		
		lbl_imagen.setIcon(appReference.crearImagen(190, 190, productoItem.imagen));
	}
}
