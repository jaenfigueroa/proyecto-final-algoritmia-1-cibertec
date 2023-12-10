package AdministradorTienda;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ConfigurarObsequiosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblA;
	private JLabel lblA_2;
	private JTextField tf_obsequioCantidad1;
	private JTextField tf_obsequioCantidad2;
	private JTextField tf_obsequioCantidad3;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	private JLabel lblTipoDeObsequio;
	
	private App appReference;
	private JTextField tf_tipoObsequio;


	/**
	 * Create the frame.
	 */
	public ConfigurarObsequiosFrame(App appReference) {
		setResizable(false);
		this.appReference= appReference;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		
		setTitle("Configurar obsequios");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 51, 135, 13);
		contentPane.add(lblNewLabel);
		
		lblA = new JLabel("6 a 10 unidades");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblA.setBounds(10, 86, 135, 13);
		contentPane.add(lblA);
		
		lblA_2 = new JLabel("11 a más unidades");
		lblA_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblA_2.setBounds(10, 123, 135, 13);
		contentPane.add(lblA_2);
		
		tf_obsequioCantidad1 = new JTextField();
		tf_obsequioCantidad1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_obsequioCantidad1.setBounds(148, 47, 108, 27);
		contentPane.add(tf_obsequioCantidad1);
		tf_obsequioCantidad1.setColumns(10);
		
		tf_obsequioCantidad2 = new JTextField();
		tf_obsequioCantidad2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_obsequioCantidad2.setColumns(10);
		tf_obsequioCantidad2.setBounds(148, 82, 108, 27);
		contentPane.add(tf_obsequioCantidad2);
		
		tf_obsequioCantidad3 = new JTextField();
		tf_obsequioCantidad3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_obsequioCantidad3.setColumns(10);
		tf_obsequioCantidad3.setBounds(148, 119, 108, 27);
		contentPane.add(tf_obsequioCantidad3);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					String tipoObsequio ="";
					int cantidadObsequio1, cantidadObsequio2, cantidadObsequio3;
					
					tipoObsequio = tf_tipoObsequio.getText();
					cantidadObsequio1 = Integer.parseInt(tf_obsequioCantidad1.getText());
					cantidadObsequio2 = Integer.parseInt(tf_obsequioCantidad2.getText());
					cantidadObsequio3 = Integer.parseInt(tf_obsequioCantidad3.getText());
					
					int[] cantidades = {cantidadObsequio1, cantidadObsequio2, cantidadObsequio3};
					
					appReference.setTipoObsequio(tipoObsequio);
					appReference.setCantidadesObsequios(cantidades);
					
					// Mostrar mensaje de exito
					JOptionPane.showMessageDialog(rootPane,"Los obsequios fueron actualizados exitosamente", "Exito",  JOptionPane.INFORMATION_MESSAGE);
					
					// cerrar ventana
					setVisible(false);

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(rootPane,"Alguno(s) de los campos ingresados no son válidos, revise nuevamente por favor.", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
					
				}

			}
		});
		btn_aceptar.setBounds(323, 13, 103, 21);
		contentPane.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cancelar.setBounds(323, 44, 103, 21);
		contentPane.add(btn_cancelar);
		
		lblTipoDeObsequio = new JLabel("Tipo de obsequio");
		lblTipoDeObsequio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeObsequio.setBounds(10, 17, 135, 13);
		contentPane.add(lblTipoDeObsequio);
		
		tf_tipoObsequio = new JTextField();
		tf_tipoObsequio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_tipoObsequio.setColumns(10);
		tf_tipoObsequio.setBounds(148, 10, 108, 27);
		contentPane.add(tf_tipoObsequio);
		
		mostrarValoresDefecto();
	}
	
	// FUNCIONES
	void mostrarValoresDefecto() {
		String tipoObsequio = appReference.getTipoObsequio();
		int[] valores = appReference.getCantidadesObsequios();
		
		tf_tipoObsequio.setText(tipoObsequio);
		tf_obsequioCantidad1.setText(Integer.toString(valores[0]));
		tf_obsequioCantidad2.setText(Integer.toString(valores[1]));
		tf_obsequioCantidad3.setText(Integer.toString(valores[2]));
	}
}
