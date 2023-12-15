package AdministradorTienda;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class ConfigurarDescuentosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblA;
	private JLabel lblA_2;
	private JLabel lblA_1;
	private JTextField tf_descuentoValor1;
	private JTextField tf_descuentoValor2;
	private JTextField tf_descuentoValor3;
	private JTextField tf_descuentoValor4;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	private JLabel lblA_3;
	private JLabel lblA_4;
	private JLabel lblS_1;
	private JLabel lblS;
	private JPanel panel;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public ConfigurarDescuentosFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarDescuentosFrame.class.getResource("/icons/pig-32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 253);
		setTitle("Configurar descuentos");
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(165, 21, 476, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setBounds(21, 29, 145, 13);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblA = new JLabel("6 a 10 unidades");
		lblA.setBounds(21, 66, 145, 13);
		panel.add(lblA);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblA_2 = new JLabel("11  a 15 unidades");
		lblA_2.setBounds(21, 103, 145, 13);
		panel.add(lblA_2);
		lblA_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblA_1 = new JLabel("Más de 15 unidades");
		lblA_1.setBounds(21, 140, 145, 13);
		panel.add(lblA_1);
		lblA_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tf_descuentoValor1 = new JTextField();
		tf_descuentoValor1.setBounds(176, 22, 89, 27);
		panel.add(tf_descuentoValor1);
		tf_descuentoValor1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_descuentoValor1.setColumns(10);
		//tf_descuentoValor1.selectAll();
		
		tf_descuentoValor2 = new JTextField();
		tf_descuentoValor2.setBounds(176, 59, 89, 27);
		panel.add(tf_descuentoValor2);
		tf_descuentoValor2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_descuentoValor2.setColumns(10);
		
		tf_descuentoValor3 = new JTextField();
		tf_descuentoValor3.setBounds(176, 96, 89, 27);
		panel.add(tf_descuentoValor3);
		tf_descuentoValor3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_descuentoValor3.setColumns(10);
		
		tf_descuentoValor4 = new JTextField();
		tf_descuentoValor4.setBounds(176, 133, 89, 27);
		panel.add(tf_descuentoValor4);
		tf_descuentoValor4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_descuentoValor4.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(344, 25, 106, 29);
		panel.add(btn_aceptar);
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarDescuentos();
			}
		});
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(344, 64, 106, 29);
		panel.add(btn_cancelar);
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		
		lblA_3 = new JLabel("%");
		lblA_3.setBounds(271, 140, 34, 13);
		panel.add(lblA_3);
		lblA_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblA_4 = new JLabel("%");
		lblA_4.setBounds(271, 103, 34, 13);
		panel.add(lblA_4);
		lblA_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblS_1 = new JLabel("%");
		lblS_1.setBounds(271, 66, 34, 13);
		panel.add(lblS_1);
		lblS_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblS = new JLabel("%");
		lblS.setBounds(271, 29, 34, 13);
		panel.add(lblS);
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(ConfigurarDescuentosFrame.class.getResource("/icons/pig-128.png")));
		lblNewLabel_1.setBounds(10, 21, 145, 163);
		contentPane.add(lblNewLabel_1);
		
		mostrarValoresDefecto();
	}
	
	// FUNCIONES
	
	void mostrarValoresDefecto() {
		double[] valores = MainApp.getPorcentajesDescuento();
		
		tf_descuentoValor1.setText(Double.toString(valores[0]));
		tf_descuentoValor2.setText(Double.toString(valores[1]));
		tf_descuentoValor3.setText(Double.toString(valores[2]));
		tf_descuentoValor4.setText(Double.toString(valores[3]));
	}
	
	void actualizarDescuentos() {
		try {
			double descuentoValor1 = Double.parseDouble(tf_descuentoValor1.getText());
			double descuentoValor2 = Double.parseDouble(tf_descuentoValor2.getText());
			double descuentoValor3 = Double.parseDouble(tf_descuentoValor3.getText());
			double descuentoValor4 = Double.parseDouble(tf_descuentoValor4.getText());
			
			double[] cantidades = {descuentoValor1, descuentoValor2, descuentoValor3, descuentoValor4};
			
			// actualizar los valores
			MainApp.setPorcentajesDescuento(cantidades);
			
			// Mostrar mensaje de exito
			JOptionPane.showMessageDialog(
					rootPane,
					"Los descuentos fueron actualizados exitosamente",
					"Exito",
					JOptionPane.INFORMATION_MESSAGE
				);
			
			// cerrar ventana
			setVisible(false);

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(rootPane,"Alguno de los campos ingresados no son válidos, revise nuevamente por favor", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
		}
	}
}
