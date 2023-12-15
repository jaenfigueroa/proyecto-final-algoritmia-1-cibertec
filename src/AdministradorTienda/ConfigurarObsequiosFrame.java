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
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
	

	private JTextField tf_tipoObsequio;
	private JPanel panel;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public ConfigurarObsequiosFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarObsequiosFrame.class.getResource("/icons/gift-32.png")));
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 255);
		
		setTitle("Configurar obsequios");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(155, 19, 443, 179);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setBounds(17, 61, 135, 13);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblA = new JLabel("6 a 10 unidades");
		lblA.setBounds(17, 96, 135, 13);
		panel.add(lblA);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblA_2 = new JLabel("11 a más unidades");
		lblA_2.setBounds(17, 133, 135, 13);
		panel.add(lblA_2);
		lblA_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tf_obsequioCantidad1 = new JTextField();
		tf_obsequioCantidad1.setBounds(173, 57, 108, 27);
		panel.add(tf_obsequioCantidad1);
		tf_obsequioCantidad1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_obsequioCantidad1.setColumns(10);
		
		tf_obsequioCantidad2 = new JTextField();
		tf_obsequioCantidad2.setBounds(173, 92, 108, 27);
		panel.add(tf_obsequioCantidad2);
		tf_obsequioCantidad2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_obsequioCantidad2.setColumns(10);
		
		tf_obsequioCantidad3 = new JTextField();
		tf_obsequioCantidad3.setBounds(173, 129, 108, 27);
		panel.add(tf_obsequioCantidad3);
		tf_obsequioCantidad3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_obsequioCantidad3.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(318, 23, 103, 29);
		panel.add(btn_aceptar);
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(318, 66, 103, 29);
		panel.add(btn_cancelar);
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblTipoDeObsequio = new JLabel("Tipo de obsequio");
		lblTipoDeObsequio.setBounds(17, 27, 135, 13);
		panel.add(lblTipoDeObsequio);
		lblTipoDeObsequio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tf_tipoObsequio = new JTextField();
		tf_tipoObsequio.setBounds(173, 20, 108, 27);
		panel.add(tf_tipoObsequio);
		tf_tipoObsequio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_tipoObsequio.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(ConfigurarObsequiosFrame.class.getResource("/icons/gift-128.png")));
		lblNewLabel_1.setBounds(10, 13, 142, 185);
		contentPane.add(lblNewLabel_1);
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
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
					
					AppFrame.setTipoObsequio(tipoObsequio);
					AppFrame.setCantidadesObsequios(cantidades);
					
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
		
		mostrarValoresDefecto();
	}
	
	// FUNCIONES
	void mostrarValoresDefecto() {
		String tipoObsequio = AppFrame.getTipoObsequio();
		int[] valores = AppFrame.getCantidadesObsequios();
		
		tf_tipoObsequio.setText(tipoObsequio);
		tf_obsequioCantidad1.setText(Integer.toString(valores[0]));
		tf_obsequioCantidad2.setText(Integer.toString(valores[1]));
		tf_obsequioCantidad3.setText(Integer.toString(valores[2]));
	}
}
