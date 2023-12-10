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

public class ConfigurarCantidadOptimaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tf_cantidadOptima;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	
	
	private App appReference;

	/**
	 * Create the frame.
	 */
	public ConfigurarCantidadOptimaFrame(App appReference) {
		setResizable(false);
		this.appReference = appReference;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 113);
		
		setTitle("Configurar cantidad óptima");
		// Centra la ventana en la pantalla
        setLocationRelativeTo(null); 
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad óptima de unidades vendidas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 269, 18);
		contentPane.add(lblNewLabel);
		
		tf_cantidadOptima = new JTextField();
		tf_cantidadOptima.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_cantidadOptima.setBounds(289, 10, 85, 19);
		contentPane.add(tf_cantidadOptima);
		tf_cantidadOptima.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		btn_aceptar.setBounds(428, 10, 98, 21);
		contentPane.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cancelar.setBounds(428, 40, 98, 21);
		contentPane.add(btn_cancelar);
		
		mostrarValorDefecto();
	}
	
	void mostrarValorDefecto() {
		int cantidadDefecto = appReference.getCantidadOptima();
		
		tf_cantidadOptima.setText(Integer.toString(cantidadDefecto));
	}

}
