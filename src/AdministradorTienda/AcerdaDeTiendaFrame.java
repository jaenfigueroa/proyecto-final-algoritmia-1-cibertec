package AdministradorTienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
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


	private AppFrame appReference;

	/**
	 * Create the frame.
	 */
	public AcerdaDeTiendaFrame(AppFrame appReference) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcerdaDeTiendaFrame.class.getResource("/icons/store-32.png")));
		this.appReference = appReference;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 449);
		
		setTitle("Acerca de la tienda");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 27, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        
		lbl_logo = new JLabel("");

		// Establecer el ImageIcon en el JLabel
		lbl_logo.setIcon(appReference.crearImagen(300, 120, "/italia/logo.jpg"));
		
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_logo.setBounds(10, 10, 416, 157);
		contentPane.add(lbl_logo);
		
		
		lblNewLabel_1 = new JLabel("Autores:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
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
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 253, 416, 17);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Nombres y apellidos");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 280, 416, 17);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nombres y apellidos");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
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
	}
}
