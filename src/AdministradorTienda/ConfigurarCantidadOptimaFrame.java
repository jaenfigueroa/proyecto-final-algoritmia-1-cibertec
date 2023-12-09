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
		this.appReference = appReference;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 105);
		setTitle("Configurar cantidad óptima");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad óptima de unidades vendidas");
		lblNewLabel.setBounds(10, 10, 235, 18);
		contentPane.add(lblNewLabel);
		
		tf_cantidadOptima = new JTextField();
		tf_cantidadOptima.setBounds(255, 10, 85, 19);
		contentPane.add(tf_cantidadOptima);
		tf_cantidadOptima.setColumns(10);
		
		btn_aceptar = new JButton("Aceptar");
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
		int cantidadDefecto = appReference.getCantidadOptima();
		
		tf_cantidadOptima.setText(Integer.toString(cantidadDefecto));
	}

}
