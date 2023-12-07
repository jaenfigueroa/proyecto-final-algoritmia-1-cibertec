package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarDescuentosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblA;
	private JLabel lblA_2;
	private JLabel lblA_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JLabel lblA_3;
	private JLabel lblA_4;
	private JLabel lblS_1;
	private JLabel lblS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarDescuentosFrame frame = new ConfigurarDescuentosFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfigurarDescuentosFrame() {
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
		
		textField = new JTextField();
		textField.setBounds(147, 10, 108, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 45, 108, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 82, 108, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 119, 108, 27);
		contentPane.add(textField_3);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(341, 13, 85, 21);
		contentPane.add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(341, 44, 85, 21);
		contentPane.add(btnCancelar);
		
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
	}

}
