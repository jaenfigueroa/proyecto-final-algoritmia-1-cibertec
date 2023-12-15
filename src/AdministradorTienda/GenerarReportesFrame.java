package AdministradorTienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class GenerarReportesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox<String> cb_tiposReportes;
	private JButton btn_cerrar;
	private JTextArea ta_resultados;
	private JLabel lblNewLabel_2;
	private JButton btn_limpiar;
	private JButton btn_actualizar;
	private JLabel lblNewLabel_1;
	private JProgressBar pb_progreso;
	private JLabel lblNewLabel_3;
	private JPanel panel;
	private JScrollPane scrollPane;
	
	
	private int tipoReporteSelecionadoIndex = 0;
	private String reporteResultados = "";

	/**
	 * Create the frame.
	 */
	public GenerarReportesFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarReportesFrame.class.getResource("/icons/bar-32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 771);
		setTitle("Generar reportes");
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(162, 10, 640, 714);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Resultados:");
		lblNewLabel_2.setBounds(22, 117, 144, 18);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btn_limpiar = new JButton("Limpiar");
		btn_limpiar.setBounds(408, 106, 96, 29);
		panel.add(btn_limpiar);
		btn_limpiar.setEnabled(false);
		btn_limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_resultados.setText("");
				pb_progreso.setValue(0);
				btn_limpiar.setEnabled(false);
			}
		});
		btn_limpiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btn_actualizar = new JButton("Actualizar");
		btn_actualizar.setBounds(502, 106, 115, 29);
		panel.add(btn_actualizar);
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pb_progreso.setValue(0);
				generarReporte();
				pb_progreso.setValue(100);
				btn_limpiar.setEnabled(true);
			}
		});
		btn_actualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("Progreso:");
		lblNewLabel_1.setBounds(22, 621, 502, 18);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		pb_progreso = new JProgressBar();
		pb_progreso.setBounds(22, 649, 595, 43);
		panel.add(pb_progreso);
		pb_progreso.setStringPainted(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 145, 595, 460);
		panel.add(scrollPane);
		
		ta_resultados = new JTextArea();
		scrollPane.setViewportView(ta_resultados);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 16));
		ta_resultados.setEditable(false);
		
		cb_tiposReportes = new JComboBox<>();
		cb_tiposReportes.setBounds(22, 55, 439, 29);
		panel.add(cb_tiposReportes);
		cb_tiposReportes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_tiposReportes.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Ventas por modelo",
				"Comparación de precios con el precio promedio",
				"Comparación de cajas vendidas con la cantidad óptima",
				"Estadistica sobre el precio"
			}));
		cb_tiposReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoReporteSelecionadoIndex = cb_tiposReportes.getSelectedIndex();
				generarReporte();
			}
		});
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setBounds(531, 23, 86, 29);
		panel.add(btn_cerrar);
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel = new JLabel("Tipo de reporte:");
		lblNewLabel.setBounds(22, 23, 170, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(GenerarReportesFrame.class.getResource("/icons/bar-128.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 439, 142, 134);
		contentPane.add(lblNewLabel_3);
		
		generarReporte();
	}
	
	// METODOS
	void generarReporte() {
		obtenerReporteCorrespondiente(this.tipoReporteSelecionadoIndex);
		mostrarResultados();
	}
	
	void obtenerReporteCorrespondiente(int tipoReporte) {
		String reporte = "";
		
		switch (tipoReporte) {
			case 0: {
				reporte = MainApp.getResporteTipo1();
				break;
			}
			case 1: {
				reporte = MainApp.getResporteTipo2();
				break;
			}
			case 2: {
				reporte = MainApp.getResporteTipo3();
				break;
			}
			case 3: {
				reporte = MainApp.getResporteTipo4();
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
