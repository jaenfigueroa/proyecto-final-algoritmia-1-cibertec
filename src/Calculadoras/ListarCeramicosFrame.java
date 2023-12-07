package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ListarCeramicosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	public ListarCeramicosFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 411);
		setTitle("Listar cerámicos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 10, 416, 318);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.setBounds(132, 338, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setBounds(227, 338, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
