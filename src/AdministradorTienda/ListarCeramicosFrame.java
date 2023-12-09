package AdministradorTienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ListarCeramicosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ta_resultados;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	App appReferense;

	/**
	 * Create the frame.
	 */
	public ListarCeramicosFrame(App appReferense) {
		
		this.appReferense = appReferense;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 708);
		setTitle("Listar cerámicos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ta_resultados = new JTextArea();
		ta_resultados.setEditable(false);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 14));
		ta_resultados.setBounds(10, 41, 416, 618);
		contentPane.add(ta_resultados);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(341, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Listar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarResultados();
			}
		});
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
	}
	
	void mostrarResultados() {
		ta_resultados.setText(appReferense.generateListadoProductos());
	}

}
