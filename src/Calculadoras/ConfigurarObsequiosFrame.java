package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class ConfigurarObsequiosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblA;
	private JLabel lblA_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JLabel lblTipoDeObsequio;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarObsequiosFrame frame = new ConfigurarObsequiosFrame();
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
	public ConfigurarObsequiosFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setBounds(10, 51, 119, 13);
		contentPane.add(lblNewLabel);
		
		lblA = new JLabel("6 a 10 unidades");
		lblA.setBounds(10, 86, 119, 13);
		contentPane.add(lblA);
		
		lblA_2 = new JLabel("11 a más unidades");
		lblA_2.setBounds(10, 123, 119, 13);
		contentPane.add(lblA_2);
		
		textField = new JTextField();
		textField.setBounds(139, 44, 108, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 79, 108, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 116, 108, 27);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(341, 13, 85, 21);
		contentPane.add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(341, 44, 85, 21);
		contentPane.add(btnCancelar);
		
		lblTipoDeObsequio = new JLabel("Tipo de obsequio");
		lblTipoDeObsequio.setBounds(10, 17, 119, 13);
		contentPane.add(lblTipoDeObsequio);
		
		comboBox = new JComboBox();
		comboBox.setBounds(139, 10, 108, 24);
		contentPane.add(comboBox);
	}

}
