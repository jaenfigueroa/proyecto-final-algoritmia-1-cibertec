package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConsultarCeramico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel lblPrecio;
	private JTextField textField;
	private JLabel lblAnchocm;
	private JTextField textField_1;
	private JLabel lblLargocm;
	private JTextField textField_2;
	private JLabel lblEspesormm;
	private JTextField textField_3;
	private JLabel lblPrecios;
	private JTextField textField_4;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCeramico frame = new ConsultarCeramico();
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
	public ConsultarCeramico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.setBounds(115, 6, 201, 21);
		contentPane.add(comboBox);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 39, 66, 13);
		contentPane.add(lblPrecio);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(113, 37, 203, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setBounds(10, 74, 66, 13);
		contentPane.add(lblAnchocm);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(113, 72, 203, 21);
		contentPane.add(textField_1);

		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setBounds(10, 108, 66, 13);
		contentPane.add(lblLargocm);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(113, 106, 203, 21);
		contentPane.add(textField_2);

		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setBounds(10, 139, 93, 13);
		contentPane.add(lblEspesormm);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(113, 136, 203, 21);
		contentPane.add(textField_3);

		lblPrecios = new JLabel("Contenido");
		lblPrecios.setBounds(10, 170, 66, 13);
		contentPane.add(lblPrecios);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(113, 168, 203, 21);
		contentPane.add(textField_4);

		btnNewButton = new JButton("Cerrar");
		btnNewButton.setBounds(326, 6, 100, 21);
		contentPane.add(btnNewButton);
	}
}
