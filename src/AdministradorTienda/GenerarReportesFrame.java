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

public class GenerarReportesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox<String> cb_tiposReportes;
	private JButton btn_cerrar;
	private JTextArea ta_resultados;
	
	private App appReference;
	

	String[] tiposReportes = {
			"Ventas por modelo",
			"Comparación de precios con el precio promedio",
			"Comparación de cajas vendidas con la cantidad óptima",
			"Estadistica sobre el precio"
		};


	String reporteResultados = "";
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public GenerarReportesFrame(App appReference) {
		setResizable(false);
		this.appReference = appReference;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 618);
		
		setTitle("Generar reportes");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de reporte:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 115, 13);
		contentPane.add(lblNewLabel);
		
		cb_tiposReportes = new JComboBox<>();
		cb_tiposReportes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_tiposReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tipoReporte = cb_tiposReportes.getSelectedIndex();

				generarReporte(tipoReporte);
			}
		});
		cb_tiposReportes.setModel(new DefaultComboBoxModel<>(tiposReportes));
		cb_tiposReportes.setBounds(135, 6, 414, 21);
		contentPane.add(cb_tiposReportes);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(587, 6, 85, 21);
		contentPane.add(btn_cerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 662, 525);
		contentPane.add(scrollPane);
		
		ta_resultados = new JTextArea();
		scrollPane.setViewportView(ta_resultados);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 15));
		ta_resultados.setEditable(false);
		
		generarReporte(0);
	}
	
	// METODOS
	void generarReporte(int tipoReporte) {
		obtenerReporteCorrespondiente(tipoReporte);
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
	}
}
