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
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ListarProductosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ta_resultados;
	private JButton btn_cerrar;
	private JButton btn_listar;
	
	AppFrame appReferense;
	private JScrollPane scrollPane;
	private JProgressBar pb_progreso;
	private JLabel lblNewLabel;
	private JLabel lblResultados;
	private JButton btn_borrar;
	private JButton btn_actualizar;

	/**
	 * Create the frame.
	 */
	public ListarProductosFrame(AppFrame appReferense) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarProductosFrame.class.getResource("/icons/books-32.png")));
		setResizable(false);
		
		this.appReferense = appReferense;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 744);
		
		setTitle("Listar cerámicos");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(341, 10, 85, 29);
		contentPane.add(btn_cerrar);
		
		btn_listar = new JButton("Listar");
		btn_listar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_listar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarResultados();
				btn_actualizar.setEnabled(true);
				btn_borrar.setEnabled(true);
			}
		});
		btn_listar.setBounds(10, 10, 76, 29);
		contentPane.add(btn_listar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 416, 523);
		contentPane.add(scrollPane);
		
		ta_resultados = new JTextArea();
		scrollPane.setViewportView(ta_resultados);
		ta_resultados.setEditable(false);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 16));
		
		pb_progreso = new JProgressBar();
		pb_progreso.setStringPainted(true);
		pb_progreso.setBounds(10, 658, 416, 36);
		contentPane.add(pb_progreso);
		
		lblNewLabel = new JLabel("Progreso:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 630, 144, 18);
		contentPane.add(lblNewLabel);
		
		lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResultados.setBounds(10, 53, 144, 29);
		contentPane.add(lblResultados);
		
		btn_borrar = new JButton("Limpiar");
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
		btn_borrar.setBounds(83, 10, 91, 29);
		contentPane.add(btn_borrar);
		
		btn_actualizar = new JButton("Actualizar");
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarResultados();
				btn_actualizar.setEnabled(true);
				btn_borrar.setEnabled(true);
			}
		});
		btn_actualizar.setEnabled(false);
		btn_actualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_actualizar.setBounds(170, 10, 111, 29);
		contentPane.add(btn_actualizar);
	}
	
	void mostrarResultados() {
		ta_resultados.setText(appReferense.generateListadoProductos());
		pb_progreso.setValue(100);
	}
}
