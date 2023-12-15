package AdministradorTienda;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class ConfigurarCantidadOptimaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tf_cantidadOptima;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Create the frame.
	 */
	public ConfigurarCantidadOptimaFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCantidadOptimaFrame.class.getResource("/icons/money-32.png")));
		setResizable(false);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 216);
		
		setTitle("Configurar cantidad óptima");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(165, 10, 560, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad óptima de unidades vendidas:");
		lblNewLabel.setBounds(22, 26, 292, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tf_cantidadOptima = new JTextField();
		tf_cantidadOptima.setBounds(319, 25, 90, 32);
		panel.add(tf_cantidadOptima);
		tf_cantidadOptima.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_cantidadOptima.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(440, 26, 98, 31);
		panel.add(btn_aceptar);
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(440, 67, 98, 29);
		panel.add(btn_cancelar);
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ConfigurarCantidadOptimaFrame.class.getResource("/icons/briefcase-128.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 12, 142, 150);
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
					int nuevaCantidadOptima=0;

					nuevaCantidadOptima = Integer.parseInt(tf_cantidadOptima.getText());

					AppFrame.setCantidadOptima(nuevaCantidadOptima);
					
					// Mostrar mensaje de exito
					JOptionPane.showMessageDialog(rootPane,"La cantidad optima fue actualizada exitosamente", "Exito",  JOptionPane.INFORMATION_MESSAGE);
					
					// cerrar ventana
					setVisible(false);
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(rootPane,"EL valor ingresado no es valido, revise nuevamente por favor", "Ups, ocurrió un error",  JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		mostrarValorDefecto();
	}
	
	void mostrarValorDefecto() {
		int cantidadDefecto = AppFrame.getCantidadOptima();
		
		tf_cantidadOptima.setText(Integer.toString(cantidadDefecto));
	}

}
