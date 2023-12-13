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
import javax.swing.SwingConstants;

public class ConfigurarCuotaDiariaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tf_cuotaDiariaEsperada;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	
	private AppFrame appReference;
	private JPanel panel;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public ConfigurarCuotaDiariaFrame(AppFrame appReference) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCuotaDiariaFrame.class.getResource("/icons/briefcase-32.png")));
		setResizable(false);
		this.appReference = appReference;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 260);
		
		setTitle("Configurar Cuota diaria");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(163, 10, 489, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setBounds(0, 0, 205, 32);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tf_cuotaDiariaEsperada = new JTextField();
		tf_cuotaDiariaEsperada.setBounds(215, 0, 121, 33);
		panel.add(tf_cuotaDiariaEsperada);
		tf_cuotaDiariaEsperada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_cuotaDiariaEsperada.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(384, 0, 105, 32);
		panel.add(btn_aceptar);
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(384, 42, 105, 29);
		panel.add(btn_cancelar);
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(11, 10, 142, 185);
		contentPane.add(lblNewLabel_1);
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
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
		
		mostrarValorDefecto();
	}
	
	void mostrarValorDefecto() {
		double cantidadDiariaDefecto = appReference.getCuotaDiaria();
		
		tf_cuotaDiariaEsperada.setText(Double.toString(cantidadDiariaDefecto));
	}

}
