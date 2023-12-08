package Calculadoras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AcerdaDeFrame extends App {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcerdaDeFrame frame = new AcerdaDeFrame();
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
	public AcerdaDeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 331);
		setTitle("Acerca de la tienda");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tienda 1.0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 416, 42);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Autores");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 77, 416, 27);
		contentPane.add(lblNewLabel_1);
		
		separator = new JSeparator();
		separator.setBounds(10, 62, 416, 17);
		contentPane.add(separator);
		
		lblNewLabel_2 = new JLabel("Jaen Redy Figueroa Llampi");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 126, 416, 17);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Jaen Redy Figueroa Llampi");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 153, 416, 17);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Jaen Redy Figueroa Llampi");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 180, 416, 17);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Jaen Redy Figueroa Llampi");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 207, 416, 17);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.setBounds(145, 256, 135, 27);
		contentPane.add(btnNewButton);
	}
}
