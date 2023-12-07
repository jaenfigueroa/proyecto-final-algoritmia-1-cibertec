package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConfigurarCantidadOptimaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarCantidadOptimaFrame frame = new ConfigurarCantidadOptimaFrame();
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
	public ConfigurarCantidadOptimaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 105);
		setTitle("Configurar cantidad óptima");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad óptima de unidades vendidas");
		lblNewLabel.setBounds(10, 10, 235, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(255, 10, 85, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(361, 9, 85, 21);
		contentPane.add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(361, 39, 85, 21);
		contentPane.add(btnCancelar);
	}

}
