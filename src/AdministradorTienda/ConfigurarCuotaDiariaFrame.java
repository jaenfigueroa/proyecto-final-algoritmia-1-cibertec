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
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class ConfigurarCuotaDiariaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tf_cuotaDiariaEsperada;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	private JPanel panel;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public ConfigurarCuotaDiariaFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCuotaDiariaFrame.class.getResource("/icons/briefcase-32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 211);
		setTitle("Configurar Cuota diaria");
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(163, 10, 539, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setBounds(21, 22, 205, 32);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tf_cuotaDiariaEsperada = new JTextField();
		tf_cuotaDiariaEsperada.setBounds(236, 22, 121, 33);
		panel.add(tf_cuotaDiariaEsperada);
		tf_cuotaDiariaEsperada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_cuotaDiariaEsperada.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(408, 22, 105, 32);
		panel.add(btn_aceptar);
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarCuotaDiaria();
			}
		});
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(408, 64, 105, 29);
		panel.add(btn_cancelar);
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ConfigurarCuotaDiariaFrame.class.getResource("/icons/money-128.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(11, 10, 142, 150);
		contentPane.add(lblNewLabel_1);

		mostrarValorDefecto();
	}
	
	void mostrarValorDefecto() {
		double cantidadDiariaDefecto = MainApp.getCuotaDiaria();
		
		tf_cuotaDiariaEsperada.setText(Double.toString(cantidadDiariaDefecto));
	}
	
	void actualizarCuotaDiaria() {
		try {
			double nuevaCuotaEsperada = Double.parseDouble(tf_cuotaDiariaEsperada.getText());

			MainApp.setCuotaDiaria(nuevaCuotaEsperada);
			
			// Mostrar mensaje de exito
			JOptionPane.showMessageDialog(rootPane,"La cuota diaria fue actualizada exitosamente", "Exito",  JOptionPane.INFORMATION_MESSAGE);
			
			// cerrar ventana
			setVisible(false);

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(rootPane,"EL valor ingresado no es valido, revise nuevamente por favor", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
		}
	}

}
