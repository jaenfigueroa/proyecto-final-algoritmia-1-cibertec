package AdministradorTienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ListarProductosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ta_resultados;
	private JButton btn_cerrar;
	private JButton btn_listar;
	
	
	private JScrollPane scrollPane;
	private JProgressBar pb_progreso;
	private JLabel lblNewLabel;
	private JLabel lblResultados;
	private JButton btn_borrar;
	private JButton btn_actualizar;
	private JPanel panel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public ListarProductosFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarProductosFrame.class.getResource("/icons/books-32.png")));
		setResizable(false);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 771);
		
		setTitle("Listar cerámicos");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(164, 10, 459, 714);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setBounds(351, 20, 85, 29);
		panel.add(btn_cerrar);
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btn_listar = new JButton("Listar");
		btn_listar.setBounds(20, 20, 76, 29);
		panel.add(btn_listar);
		btn_listar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 96, 416, 523);
		panel.add(scrollPane);
		
		ta_resultados = new JTextArea();
		scrollPane.setViewportView(ta_resultados);
		ta_resultados.setEditable(false);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 16));
		
		pb_progreso = new JProgressBar();
		pb_progreso.setBounds(20, 668, 416, 36);
		panel.add(pb_progreso);
		pb_progreso.setStringPainted(true);
		
		lblNewLabel = new JLabel("Progreso:");
		lblNewLabel.setBounds(20, 640, 144, 18);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(20, 63, 144, 29);
		panel.add(lblResultados);
		lblResultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btn_borrar = new JButton("Limpiar");
		btn_borrar.setBounds(93, 20, 91, 29);
		panel.add(btn_borrar);
		btn_borrar.setEnabled(false);
		btn_borrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ta_resultados.setText("");
				pb_progreso.setValue(0);
				btn_borrar.setEnabled(false);
				//btn_actualizar.setEnabled(false);
			}
		});
		btn_borrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btn_actualizar = new JButton("Actualizar");
		btn_actualizar.setBounds(180, 20, 111, 29);
		panel.add(btn_actualizar);
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarResultados();
				btn_actualizar.setEnabled(true);
				btn_borrar.setEnabled(true);
			}
		});
		btn_actualizar.setEnabled(false);
		btn_actualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListarProductosFrame.class.getResource("/icons/books-128.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 470, 142, 150);
		contentPane.add(lblNewLabel_1);
		btn_listar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarResultados();
				btn_actualizar.setEnabled(true);
				btn_borrar.setEnabled(true);
			}
		});
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
	}
	
	void mostrarResultados() {
		ta_resultados.setText(AppFrame.generarListadoProductos());
		pb_progreso.setValue(100);
	}
}
