package AdministradorTienda;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class DashboardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarCermico;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_12;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_2;

	/**
	 * Create the frame.
	 */
	public DashboardFrame() {
		setBackground(new Color(255, 255, 255));
		setTitle("Panel de administración de Zelima cerámicos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DashboardFrame.class.getResource("/icons/store-32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 638);
		setLocationRelativeTo(null);// Centrar la ventana en la pantalla

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(150, 131, 557, 256);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(151, 0, 256, 256);
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(MainApp.crearImagen(256, 256, "/icons/store-256.png"));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(429, 77, 128, 128);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/store-128.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 77, 128, 128);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/store-128.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);

		panel = new JPanel();
		panel.setBackground(new Color(11, 34, 57));
		panel.setBounds(0, 0, 872, 82);
		contentPane.add(panel);
		panel.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(21, 10, 723, 62);
		panel.add(menuBar);
		menuBar.setBorderPainted(false);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setForeground(new Color(0, 0, 255));
		menuBar.setBackground(new Color(11, 34, 57));

		mnNewMenu = new JMenu("  Archivo  ");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/carpeta.png")));
		mnNewMenu.setFont(new Font("Dialog", Font.PLAIN, 17));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/logout-32.png")));
		mntmNewMenuItem.setFont(new Font("Dialog", Font.PLAIN, 17));
		mntmNewMenuItem.setBackground(new Color(240, 240, 240));
		mntmNewMenuItem.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarAplicacion();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		mnMantenimiento = new JMenu("  Mantenimiento  ");
		mnMantenimiento.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/reporte.png")));
		mnMantenimiento.setFont(new Font("Dialog", Font.PLAIN, 16));
		mnMantenimiento.setForeground(new Color(255, 255, 255));
		menuBar.add(mnMantenimiento);

		mntmConsultarCermico = new JMenuItem("Consultar cerámico");
		mntmConsultarCermico.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/idea-32.png")));
		mntmConsultarCermico.setFont(new Font("Dialog", Font.PLAIN, 17));
		mntmConsultarCermico.setForeground(new Color(0, 0, 255));
		mntmConsultarCermico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProductoFrame frame = new ConsultarProductoFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);

			}
		});
		mnMantenimiento.add(mntmConsultarCermico);

		mntmNewMenuItem_4 = new JMenuItem("Modificar cerámico");
		mntmNewMenuItem_4.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/notes-32.png")));
		mntmNewMenuItem_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		mntmNewMenuItem_4.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ModificarProductoFrame frame = new ModificarProductoFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmNewMenuItem_4);

		mntmNewMenuItem_5 = new JMenuItem("Listar cerámicos");
		mntmNewMenuItem_5.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/books-32.png")));
		mntmNewMenuItem_5.setFont(new Font("Dialog", Font.PLAIN, 17));
		mntmNewMenuItem_5.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProductosFrame frame = new ListarProductosFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmNewMenuItem_5);

		mnNewMenu_2 = new JMenu("  Ventas  ");
		mnNewMenu_2.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/credit-48.png")));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_6 = new JMenuItem("Vender");
		mntmNewMenuItem_6.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/shopping-32.png")));
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_6.setForeground(new Color(0, 0, 255));

		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VenderFrame frame = new VenderFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);

		mntmNewMenuItem_7 = new JMenuItem("Generar reportes");
		mntmNewMenuItem_7.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/bar-32.png")));
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_7.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarReportesFrame frame = new GenerarReportesFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);

		mnNewMenu_3 = new JMenu("  Configuración  ");
		mnNewMenu_3.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/settings-48.png")));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_3);

		mntmNewMenuItem_9 = new JMenuItem("Configurar descuentos");
		mntmNewMenuItem_9.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/pig-32.png")));
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_9.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarDescuentosFrame frame = new ConfigurarDescuentosFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);

		mntmNewMenuItem_10 = new JMenuItem("Configurar obsequios");
		mntmNewMenuItem_10.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/gift-32.png")));
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_10.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarObsequiosFrame frame = new ConfigurarObsequiosFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);

		mntmNewMenuItem_11 = new JMenuItem("Configurar cantidad óptima");
		mntmNewMenuItem_11.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/briefcase-32.png")));
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_11.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarCantidadOptimaFrame frame = new ConfigurarCantidadOptimaFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);

		mntmNewMenuItem_1 = new JMenuItem("Configurar cuota diaria");
		mntmNewMenuItem_1.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/money-32.png")));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_1.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarCuotaDiariaFrame frame = new ConfigurarCuotaDiariaFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);

		mnNewMenu_1 = new JMenu("  Ayuda");
		mnNewMenu_1.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/help-48.png")));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem_12 = new JMenuItem("Acerca de la Tienda");
		mntmNewMenuItem_12.setIcon(new ImageIcon(DashboardFrame.class.getResource("/icons/store-32.png")));
		mntmNewMenuItem_12.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_12.setForeground(new Color(0, 0, 255));
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcerdaDeTiendaFrame frame = new AcerdaDeTiendaFrame();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_12);
		
		panel_1 = new JPanel();
		panel_1.setBounds(293, 415, 331, 115);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Zelima");
		lblNewLabel_1.setBounds(0, 0, 242, 73);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 67));
		
		lblNewLabel_2 = new JLabel("Cerámicos");
		lblNewLabel_2.setForeground(new Color(113, 113, 113));
		lblNewLabel_2.setBounds(128, 71, 203, 34);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
	}

	// METODOS
	
	static void cerrarAplicacion() {
		int cerrarAplicacion = JOptionPane.showOptionDialog(
				null,
				"Se va a cerrar la aplicación ¿estas seguro?",
				"Confirma acción",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				null,
				null
			);

		if (cerrarAplicacion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
