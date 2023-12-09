package AdministradorTienda;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfigurarCuotaDiariaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tf_cuotaDiariaEsperada;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	
	private App appReference;


	/**
	 * Create the frame.
	 */
	public ConfigurarCuotaDiariaFrame(App appReference) {
		this.appReference = appReference;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 105);
		setTitle("Configurar Cuota diaria");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setBounds(10, 10, 160, 18);
		contentPane.add(lblNewLabel);
		
		tf_cuotaDiariaEsperada = new JTextField();
		tf_cuotaDiariaEsperada.setBounds(180, 10, 121, 19);
		contentPane.add(tf_cuotaDiariaEsperada);
		tf_cuotaDiariaEsperada.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					double nuevaCuotaEsperada =0;
					
					nuevaCuotaEsperada = Double.parseDouble(tf_cuotaDiariaEsperada.getText());

					appReference.setCuotaDiaria(nuevaCuotaEsperada);
					
					// Mostrar mensaje de exito
					JOptionPane.showMessageDialog(rootPane,"La cuota diaria fue actualizada exitosamente", "Exito",  JOptionPane.INFORMATION_MESSAGE);
					
					// cerrar ventana
					setVisible(false);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane,"EL valor ingresado no es valido, revise nuevamente por favor", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_aceptar.setBounds(361, 9, 85, 21);
		contentPane.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cancelar.setBounds(361, 39, 85, 21);
		contentPane.add(btn_cancelar);
		
		mostrarValorDefecto();
	}
	
	void mostrarValorDefecto() {
		double cantidadDiariaDefecto = appReference.getCuotaDiaria();
		
		tf_cuotaDiariaEsperada.setText(Double.toString(cantidadDiariaDefecto));
	}

}
