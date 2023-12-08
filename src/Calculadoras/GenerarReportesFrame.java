package Calculadoras;

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

	/**
	 * Create the frame.
	 */
	public GenerarReportesFrame(App appReference) {
		this.appReference = appReference;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 620);
		setTitle("Generar reportes");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de reporte");
		lblNewLabel.setBounds(10, 10, 101, 13);
		contentPane.add(lblNewLabel);
		
		cb_tiposReportes = new JComboBox<>();
		cb_tiposReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tipoReporte = cb_tiposReportes.getSelectedIndex();

				generarReporte(tipoReporte);
			}
		});
		cb_tiposReportes.setModel(new DefaultComboBoxModel<>(tiposReportes));
		cb_tiposReportes.setBounds(121, 6, 341, 21);
		contentPane.add(cb_tiposReportes);
		
		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cerrar.setBounds(477, 6, 85, 21);
		contentPane.add(btn_cerrar);
		
		ta_resultados = new JTextArea();
		ta_resultados.setBounds(10, 37, 557, 536);
		contentPane.add(ta_resultados);
		
		// Mostrar reporte de la opción seleccionada por defecto
		generarReporte(cb_tiposReportes.getSelectedIndex());
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
				reporte = appReference.generarReporteVentasPorModelo();
				break;
			}
			case 1: {
				reporte = appReference.generarReporteComparacionPreciosConPrecioPromedio();
				break;
			}
			case 2: {
				reporte = appReference.generarReporteCajasVendidasCantidadOptima();
				break;
			}
			case 3: {
				reporte = appReference.generarReporteEstadisticaPrecio();
				break;
			}
		}
		
		reporteResultados = reporte;
	}
	
	void mostrarResultados() {
		ta_resultados.setText(reporteResultados);
	}
}
