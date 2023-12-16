package AdministradorTienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class AcerdaDeTiendaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbl_logo;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JLabel lbl_version;
	private JLabel lblNewLabel;
	private JLabel lblCermicos;
	private JPanel panel;


	/**
	 * Create the frame.
	 */
	public AcerdaDeTiendaFrame() {
		setTitle("Acerca de la tienda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcerdaDeTiendaFrame.class.getResource("/icons/store-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 449);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_version = new JLabel("V1.0");
		lbl_version.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_version.setBounds(389, 10, 37, 27);
		contentPane.add(lbl_version);

		lbl_logo = new JLabel("");
		lbl_logo.setIcon(Utilidades.crearImagen(128, 128, "/icons/store-128.png"));
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_logo.setBounds(47, 10, 155, 157);
		contentPane.add(lbl_logo);
		
		lblNewLabel_1 = new JLabel("Autores:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 204, 416, 27);
		contentPane.add(lblNewLabel_1);
		
		separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(10, 177, 416, 17);
		contentPane.add(separator);
		
		lblNewLabel_2 = new JLabel("Jaen Redy Figueroa Llampi (i202334365)");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 253, 416, 17);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Nombres y apellidos");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 280, 416, 17);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nombres y apellidos");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 307, 416, 17);
		contentPane.add(lblNewLabel_4);
		
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(145, 355, 135, 35);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBounds(206, 59, 169, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Zelima");
		lblNewLabel.setBounds(0, 0, 141, 47);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		
		lblCermicos = new JLabel("Cerámicos");
		lblCermicos.setForeground(new Color(97, 97, 97));
		lblCermicos.setBounds(46, 35, 122, 45);
		panel.add(lblCermicos);
		lblCermicos.setFont(new Font("Tahoma", Font.PLAIN, 25));
	}
}
