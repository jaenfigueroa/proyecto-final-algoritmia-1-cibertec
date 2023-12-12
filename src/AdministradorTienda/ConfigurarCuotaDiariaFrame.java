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
import java.awt.Font;
import java.awt.Toolkit;

public class ConfigurarCuotaDiariaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tf_cuotaDiariaEsperada;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	
	private AppFrame appReference;


	/**
	 * Create the frame.
	 */
	public ConfigurarCuotaDiariaFrame(AppFrame appReference) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCuotaDiariaFrame.class.getResource("/icons/briefcase-32.png")));
		setResizable(false);
		this.appReference = appReference;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 132);
		
		setTitle("Configurar Cuota diaria");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 205, 32);
		contentPane.add(lblNewLabel);
		
		tf_cuotaDiariaEsperada = new JTextField();
		tf_cuotaDiariaEsperada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_cuotaDiariaEsperada.setBounds(225, 10, 121, 33);
		contentPane.add(tf_cuotaDiariaEsperada);
		tf_cuotaDiariaEsperada.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		btn_aceptar.setBounds(394, 10, 105, 32);
		contentPane.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cancelar.setBounds(394, 52, 105, 29);
		contentPane.add(btn_cancelar);
		
		mostrarValorDefecto();
	}
	
	void mostrarValorDefecto() {
		double cantidadDiariaDefecto = appReference.getCuotaDiaria();
		
		tf_cuotaDiariaEsperada.setText(Double.toString(cantidadDiariaDefecto));
	}

}
