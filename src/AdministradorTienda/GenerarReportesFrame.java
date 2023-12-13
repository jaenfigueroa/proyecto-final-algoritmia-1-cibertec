package AdministradorTienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JProgressBar;
import java.awt.Toolkit;

public class GenerarReportesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox<String> cb_tiposReportes;
	private JButton btn_cerrar;
	private JTextArea ta_resultados;
	
	private AppFrame appReference;
	
	int tipoReporte =0;

	String[] tiposReportes = {
			"Ventas por modelo",
			"Comparación de precios con el precio promedio",
			"Comparación de cajas vendidas con la cantidad óptima",
			"Estadistica sobre el precio"
		};


	String reporteResultados = "";
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JButton btn_limpiar;
	private JButton btn_actualizar;
	private JLabel lblNewLabel_1;
	private JProgressBar pb_progreso;

	/**
	 * Create the frame.
	 */
	public GenerarReportesFrame(AppFrame appReference) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarReportesFrame.class.getResource("/icons/bar-32.png")));
		setResizable(false);
		this.appReference = appReference;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 771);
		
		setTitle("Generar reportes");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de reporte");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 115, 29);
		contentPane.add(lblNewLabel);
		
		cb_tiposReportes = new JComboBox<>();
		cb_tiposReportes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_tiposReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoReporte = cb_tiposReportes.getSelectedIndex();

				generarReporte();
			}
		});
		cb_tiposReportes.setModel(new DefaultComboBoxModel<>(tiposReportes));
		cb_tiposReportes.setBounds(128, 10, 400, 29);
		contentPane.add(cb_tiposReportes);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(548, 10, 86, 29);
		contentPane.add(btn_cerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 624, 525);
		contentPane.add(scrollPane);
		
		ta_resultados = new JTextArea();
		scrollPane.setViewportView(ta_resultados);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 16));
		ta_resultados.setEditable(false);
		
		lblNewLabel_2 = new JLabel("Resultados:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 63, 144, 18);
		contentPane.add(lblNewLabel_2);
		
		btn_limpiar = new JButton("Limpiar");
		btn_limpiar.setEnabled(false);
		btn_limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cb_tiposReportes.setSelectedIndex(0);
				ta_resultados.setText("");
				pb_progreso.setValue(0);
				btn_limpiar.setEnabled(false);
				//btn_actualizar.setEnabled(false);
			}
		});
		btn_limpiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_limpiar.setBounds(425, 626, 96, 29);
		contentPane.add(btn_limpiar);
		
		btn_actualizar = new JButton("Actualizar");
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pb_progreso.setValue(0);
				generarReporte();
				pb_progreso.setValue(100);
				btn_limpiar.setEnabled(true);
			}
		});
		btn_actualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_actualizar.setBounds(519, 626, 115, 29);
		contentPane.add(btn_actualizar);
		
		lblNewLabel_1 = new JLabel("Progreso:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 653, 144, 18);
		contentPane.add(lblNewLabel_1);
		
		pb_progreso = new JProgressBar();
		pb_progreso.setStringPainted(true);
		pb_progreso.setBounds(8, 681, 624, 43);
		contentPane.add(pb_progreso);
		
		generarReporte();
	}
	
	// METODOS
	void generarReporte() {
		obtenerReporteCorrespondiente(this.tipoReporte);
		mostrarResultados();
	}
	
	void obtenerReporteCorrespondiente(int tipoReporte) {
		String reporte = "";
		
		switch (tipoReporte) {
			case 0: {
				reporte = appReference.getResporteTipo1();
				break;
			}
			case 1: {
				reporte = appReference.getResporteTipo2();
				break;
			}
			case 2: {
				reporte = appReference.getResporteTipo3();
				break;
			}
			case 3: {
				reporte = appReference.getResporteTipo4();
				break;
			}
		}
		
		reporteResultados = reporte;
	}
	
	void mostrarResultados() {
		ta_resultados.setText(reporteResultados);
		
		btn_limpiar.setEnabled(true);
		btn_actualizar.setEnabled(true);
		pb_progreso.setValue(100);
	}
}
