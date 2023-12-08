package Calculadoras;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	private App appReference;


	/**
	 * Create the frame.
	 */
	public ConfigurarDescuentosFrame(App appReference) {
		this.appReference = appReference;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		setTitle("Configurar descuentos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setBounds(18, 17, 119, 13);
		contentPane.add(lblNewLabel);
		
		lblA = new JLabel("6 a 10 unidades");
		lblA.setBounds(18, 52, 119, 13);
		contentPane.add(lblA);
		
		lblA_2 = new JLabel("11  a 15 unidades");
		lblA_2.setBounds(18, 89, 119, 13);
		contentPane.add(lblA_2);
		
		lblA_1 = new JLabel("Más de 15 unidades");
		lblA_1.setBounds(18, 126, 119, 13);
		contentPane.add(lblA_1);
		
		tf_descuentoValor1 = new JTextField();
		tf_descuentoValor1.setBounds(147, 10, 108, 27);
		contentPane.add(tf_descuentoValor1);
		tf_descuentoValor1.setColumns(10);
		
		tf_descuentoValor2 = new JTextField();
		tf_descuentoValor2.setColumns(10);
		tf_descuentoValor2.setBounds(147, 45, 108, 27);
		contentPane.add(tf_descuentoValor2);
		
		tf_descuentoValor3 = new JTextField();
		tf_descuentoValor3.setColumns(10);
		tf_descuentoValor3.setBounds(147, 82, 108, 27);
		contentPane.add(tf_descuentoValor3);
		
		tf_descuentoValor4 = new JTextField();
		tf_descuentoValor4.setColumns(10);
		tf_descuentoValor4.setBounds(147, 119, 108, 27);
		contentPane.add(tf_descuentoValor4);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Declaración de variables
				double descuentoValor1 =0, descuentoValor2=0, descuentoValor3 =0, descuentoValor4 =0; 
				
				// recoger los valores
				descuentoValor1 = Double.parseDouble(tf_descuentoValor1.getText());
				descuentoValor2 = Double.parseDouble(tf_descuentoValor2.getText());
				descuentoValor3 = Double.parseDouble(tf_descuentoValor3.getText());
				descuentoValor4 = Double.parseDouble(tf_descuentoValor4.getText());
				
				double[] cantidades = {descuentoValor1, descuentoValor2, descuentoValor3, descuentoValor4};
				
				// actualizar los valores
				appReference.setConfigurarPorcentajeDescuento(cantidades);
			}
		});
		btn_aceptar.setBounds(341, 13, 85, 21);
		contentPane.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cancelar.setBounds(341, 44, 85, 21);
		contentPane.add(btn_cancelar);
		
		lblA_3 = new JLabel("%");
		lblA_3.setBounds(261, 126, 34, 13);
		contentPane.add(lblA_3);
		
		lblA_4 = new JLabel("%");
		lblA_4.setBounds(261, 89, 34, 13);
		contentPane.add(lblA_4);
		
		lblS_1 = new JLabel("%");
		lblS_1.setBounds(261, 52, 34, 13);
		contentPane.add(lblS_1);
		
		lblS = new JLabel("%");
		lblS.setBounds(261, 17, 34, 13);
		contentPane.add(lblS);
		
		mostrarValoresDefecto();
	}
	
	// FUNCIONES
	void mostrarValoresDefecto() {
		double[] valores = appReference.getPorcentajesDescuento();
		
		tf_descuentoValor1.setText(Double.toString(valores[0]));
		tf_descuentoValor2.setText(Double.toString(valores[1]));
		tf_descuentoValor3.setText(Double.toString(valores[2]));
		tf_descuentoValor4.setText(Double.toString(valores[3]));
	}

}
