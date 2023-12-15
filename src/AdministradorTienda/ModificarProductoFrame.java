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
import java.awt.Toolkit;


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


	private JPanel panel;
	private JLabel lbl_imagen;

	/**
	 * Create the frame.
	 */
	public ModificarProductoFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarProductoFrame.class.getResource("/icons/notes-32.png")));
		setResizable(false);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 329);
		
		setTitle("Modificar cerámico");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setBounds(287, 28, 106, 25);
		contentPane.add(lblNewLabel);

		cb_modelo = new JComboBox<>();
		cb_modelo.setFont(new Font("Dialog", Font.PLAIN, 16));
		cb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatosDelProducto();
			}
		});
		cb_modelo.setModel(new DefaultComboBoxModel<>(AppFrame.obtenerModelosDeProductos()));
		cb_modelo.setBounds(403, 24, 183, 29);
		contentPane.add(cb_modelo);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPrecio.setBounds(287, 65, 106, 27);
		contentPane.add(lblPrecio);

		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_precio.setBounds(403, 63, 183, 29);
		contentPane.add(tf_precio);
		tf_precio.setColumns(10);

		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAnchocm.setBounds(287, 102, 106, 34);
		contentPane.add(lblAnchocm);

		tf_ancho = new JTextField();
		tf_ancho.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_ancho.setColumns(10);
		tf_ancho.setBounds(403, 105, 183, 31);
		contentPane.add(tf_ancho);

		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblLargocm.setBounds(287, 146, 106, 29);
		contentPane.add(lblLargocm);

		tf_largo = new JTextField();
		tf_largo.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_largo.setColumns(10);
		tf_largo.setBounds(403, 146, 183, 29);
		contentPane.add(tf_largo);

		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEspesormm.setBounds(287, 185, 121, 28);
		contentPane.add(lblEspesormm);

		tf_espesor = new JTextField();
		tf_espesor.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_espesor.setColumns(10);
		tf_espesor.setBounds(403, 185, 183, 28);
		contentPane.add(tf_espesor);

		lblPrecios = new JLabel("Contenido");
		lblPrecios.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPrecios.setBounds(287, 223, 121, 27);
		contentPane.add(lblPrecios);

		tf_contenido = new JTextField();
		tf_contenido.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_contenido.setColumns(10);
		tf_contenido.setBounds(403, 223, 183, 27);
		contentPane.add(tf_contenido);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(634, 22, 100, 31);
		contentPane.add(btn_cerrar);
		
		btn_grabar = new JButton("Grabar");
		btn_grabar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btn_grabar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// GUARDAR CAMBIOS
				actualizarProducto();
			}
		});
		btn_grabar.setBounds(634, 63, 100, 29);
		contentPane.add(btn_grabar);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 14, 260, 260);
		contentPane.add(panel);
		
		lbl_imagen = new JLabel("");
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagen.setBounds(10, 10, 240, 240);
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
			AppFrame.productos[productoIndex].updateProducto(nuevoPrecio, nuevoAncho, nuevoLargo, nuevoEspesor, nuevoContenido);
			
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
		Producto productoItem = AppFrame.productos[indexProducto];

		// Mostrar datos del producto
		tf_precio.setText(Double.toString(productoItem.precio));
		tf_ancho.setText(Double.toString(productoItem.ancho));
		tf_largo.setText(Double.toString(productoItem.largo));
		tf_espesor.setText(Double.toString(productoItem.espesor));
		tf_contenido.setText(Integer.toString(productoItem.contenido));
		
		lbl_imagen.setIcon(AppFrame.crearImagen(240, 240, productoItem.imagen));
	}
}
