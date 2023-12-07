package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Font;

public class Vender extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnCerrar;
	private JComboBox comboBox;
	private JTextArea txtrCscscscs;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
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
	public Vender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 14, 60, 13);
		contentPane.add(lblNewLabel);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 43, 60, 13);
		contentPane.add(lblPrecio);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 44, 177, 19);
		contentPane.add(textField_1);
		
		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setBounds(10, 69, 60, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 70, 177, 19);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("Vender");
		btnNewButton.setBounds(341, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(341, 39, 85, 21);
		contentPane.add(btnCerrar);
		
		comboBox = new JComboBox();
		comboBox.setBounds(91, 14, 177, 19);
		contentPane.add(comboBox);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setBounds(10, 106, 416, 188);
		contentPane.add(textArea);
		
		// MOSTRAR TEXTO
		textArea.setText("MODELO DE VENTA\n\n");
		textArea.append("Modelo\t\t: " + "\n");
		textArea.append("Precio\t\t: S/. " + "\n");
		textArea.append("Cantidad adquirida\t: " + "\n");
		textArea.append("Importe de compra\t: S/. " + "\n");
		textArea.append("Importe de descuento\t: S/. " + "\n");
		textArea.append("Importe a pagar\t: S/. " + "\n");
		textArea.append("Tipo de obsequio\t: " + "\n");
		textArea.append("Unidades adquiridas\t: " + "\n");
	}
}
