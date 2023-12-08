package Calculadoras;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfigurarObsequiosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblA;
	private JLabel lblA_2;
	private JTextField tf_obsequioCantidad1;
	private JTextField tf_obsequioCantidad2;
	private JTextField tf_obsequioCantidad3;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	private JLabel lblTipoDeObsequio;
	
	private App appReference;
	private JTextField tf_tipoObsequio;


	/**
	 * Create the frame.
	 */
	public ConfigurarObsequiosFrame(App appReference) {
		this.appReference= appReference;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		setTitle("Configurar obsequios");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setBounds(10, 51, 119, 13);
		contentPane.add(lblNewLabel);
		
		lblA = new JLabel("6 a 10 unidades");
		lblA.setBounds(10, 86, 119, 13);
		contentPane.add(lblA);
		
		lblA_2 = new JLabel("11 a más unidades");
		lblA_2.setBounds(10, 123, 119, 13);
		contentPane.add(lblA_2);
		
		tf_obsequioCantidad1 = new JTextField();
		tf_obsequioCantidad1.setBounds(139, 44, 108, 27);
		contentPane.add(tf_obsequioCantidad1);
		tf_obsequioCantidad1.setColumns(10);
		
		tf_obsequioCantidad2 = new JTextField();
		tf_obsequioCantidad2.setColumns(10);
		tf_obsequioCantidad2.setBounds(139, 79, 108, 27);
		contentPane.add(tf_obsequioCantidad2);
		
		tf_obsequioCantidad3 = new JTextField();
		tf_obsequioCantidad3.setColumns(10);
		tf_obsequioCantidad3.setBounds(139, 116, 108, 27);
		contentPane.add(tf_obsequioCantidad3);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cantidadObsequio1, cantidadObsequio2, cantidadObsequio3;
				
				cantidadObsequio1 = Integer.parseInt(tf_obsequioCantidad1.getText());
				cantidadObsequio2 = Integer.parseInt(tf_obsequioCantidad2.getText());
				cantidadObsequio3 = Integer.parseInt(tf_obsequioCantidad3.getText());
				
				int[] cantidades = {cantidadObsequio1, cantidadObsequio2, cantidadObsequio3};
				
				appReference.setConfigurarObsequios(cantidades);
			}
		});
		btn_aceptar.setBounds(341, 13, 85, 21);
		contentPane.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_cancelar.setBounds(341, 44, 85, 21);
		contentPane.add(btn_cancelar);
		
		lblTipoDeObsequio = new JLabel("Tipo de obsequio");
		lblTipoDeObsequio.setBounds(10, 17, 119, 13);
		contentPane.add(lblTipoDeObsequio);
		
		tf_tipoObsequio = new JTextField();
		tf_tipoObsequio.setColumns(10);
		tf_tipoObsequio.setBounds(139, 7, 108, 27);
		contentPane.add(tf_tipoObsequio);
		
		mostrarValoresDefecto();
	}
	
	// FUNCIONES
	void mostrarValoresDefecto() {
		String tipoObsequio = appReference.getTipoObsequio();
		int[] valores = appReference.getCantidadesObsequios();
		
		tf_tipoObsequio.setText(tipoObsequio);
		tf_obsequioCantidad1.setText(Integer.toString(valores[0]));
		tf_obsequioCantidad2.setText(Integer.toString(valores[1]));
		tf_obsequioCantidad3.setText(Integer.toString(valores[2]));
	}
}
