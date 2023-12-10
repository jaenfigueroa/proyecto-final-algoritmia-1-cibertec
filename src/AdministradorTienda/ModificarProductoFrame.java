package AdministradorTienda;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class ModificarProductoFrame extends JFrame {

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
	private JButton btn_grabar;

	private App appReference;
	private JPanel panel;
	private JLabel lbl_imagen;

	/**
	 * Create the frame.
	 */
	public ModificarProductoFrame(App appReference) {
		setResizable(false);
		
		this.appReference = appReference;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 306);
		
		setTitle("Modificar cerámico");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(287, 28, 121, 13);
		contentPane.add(lblNewLabel);

		cb_modelo = new JComboBox<>();
		cb_modelo.setFont(new Font("Dialog", Font.PLAIN, 15));
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatosDelProducto();
			}
		});
		cb_modelo.setModel(new DefaultComboBoxModel<>(appReference.getModelosDeProductos()));
		cb_modelo.setBounds(398, 24, 181, 21);
		contentPane.add(cb_modelo);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(287, 57, 121, 13);
		contentPane.add(lblPrecio);

		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_precio.setBounds(396, 55, 183, 21);
		contentPane.add(tf_precio);
		tf_precio.setColumns(10);

		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnchocm.setBounds(287, 92, 121, 13);
		contentPane.add(lblAnchocm);

		tf_ancho = new JTextField();
		tf_ancho.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_ancho.setColumns(10);
		tf_ancho.setBounds(396, 90, 183, 21);
		contentPane.add(tf_ancho);

		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLargocm.setBounds(287, 126, 121, 13);
		contentPane.add(lblLargocm);

		tf_largo = new JTextField();
		tf_largo.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_largo.setColumns(10);
		tf_largo.setBounds(396, 124, 183, 21);
		contentPane.add(tf_largo);

		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEspesormm.setBounds(287, 157, 121, 13);
		contentPane.add(lblEspesormm);

		tf_espesor = new JTextField();
		tf_espesor.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_espesor.setColumns(10);
		tf_espesor.setBounds(396, 154, 183, 21);
		contentPane.add(tf_espesor);

		lblPrecios = new JLabel("Contenido");
		lblPrecios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecios.setBounds(287, 188, 121, 13);
		contentPane.add(lblPrecios);

		tf_contenido = new JTextField();
		tf_contenido.setFont(new Font("Dialog", Font.PLAIN, 15));
		tf_contenido.setColumns(10);
		tf_contenido.setBounds(396, 186, 183, 21);
		contentPane.add(tf_contenido);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(611, 24, 100, 21);
		contentPane.add(btn_cerrar);
		
		btn_grabar = new JButton("Grabar");
		btn_grabar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btn_grabar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// GUARDAR CAMBIOS
				actualizarProducto();
			}
		});
		btn_grabar.setBounds(611, 53, 100, 21);
		contentPane.add(btn_grabar);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 14, 259, 245);
		contentPane.add(panel);
		
		lbl_imagen = new JLabel("");
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagen.setBounds(10, 10, 239, 225);
		panel.add(lbl_imagen);
		
		// mostrar los datos del producto seleccionado por defecto
		mostrarDatosDelProducto();
	}
	
	// METODOS

	void actualizarProducto() {
		// recuperar el valor indece seleccionado del combobox
		int productoIndex = cb_modelo.getSelectedIndex();
		
		try {
			
			// recolectar los campos actualizados
			double nuevoPrecio = Double.parseDouble(tf_precio.getText());
			double nuevoAncho = Double.parseDouble(tf_ancho.getText());
			double nuevoLargo = Double.parseDouble(tf_largo.getText());
			double nuevoEspesor = Double.parseDouble(tf_espesor.getText());
			int nuevoContenido = Integer.parseInt(tf_contenido.getText());
			
			// actualizar el producto
			appReference.productos[productoIndex].updateProducto(nuevoPrecio, nuevoAncho, nuevoLargo, nuevoEspesor, nuevoContenido);
			
			// Mostra mensaje
			JOptionPane.showMessageDialog(rootPane,"¡Producto actualizado correctamente!", "Ups, ocurrió un error",  JOptionPane.INFORMATION_MESSAGE);
			
			// cerrar ventana
			setVisible(false);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane,"Alguno de los campos ingresados no son válidos, revise nuevamente por favor", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
		}
	}
	
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
