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

public class ConfigurarCantidadOptimaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tf_cantidadOptima;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	
	
	private AppFrame appReference;

	/**
	 * Create the frame.
	 */
	public ConfigurarCantidadOptimaFrame(AppFrame appReference) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCantidadOptimaFrame.class.getResource("/icons/money-32.png")));
		setResizable(false);
		this.appReference = appReference;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 139);
		
		setTitle("Configurar cantidad óptima");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad óptima de unidades vendidas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 18, 292, 31);
		contentPane.add(lblNewLabel);
		
		tf_cantidadOptima = new JTextField();
		tf_cantidadOptima.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_cantidadOptima.setBounds(307, 17, 90, 32);
		contentPane.add(tf_cantidadOptima);
		tf_cantidadOptima.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int nuevaCantidadOptima=0;

					nuevaCantidadOptima = Integer.parseInt(tf_cantidadOptima.getText());

					appReference.setCantidadOptima(nuevaCantidadOptima);
					
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
		btn_aceptar.setBounds(428, 18, 98, 31);
		contentPane.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cancelar.setBounds(428, 59, 98, 29);
		contentPane.add(btn_cancelar);
		
		mostrarValorDefecto();
	}
	
	void mostrarValorDefecto() {
		int cantidadDefecto = appReference.getCantidadOptima();
		
		tf_cantidadOptima.setText(Integer.toString(cantidadDefecto));
	}

}
