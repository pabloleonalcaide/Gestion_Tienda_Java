package gui;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * La ventana de Bienvenida habilita/deshabilita el menu de opciones de los empleados
 * permitiendo así que se mantenga activa la barra de clientes para comprobar cambios
 * @author pablo
 *
 */
public class DialogBienvenida {

	private JDialog frameWelcome;
	/**
	 * Create the application.
	 */
	public DialogBienvenida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameWelcome = new JDialog();
		frameWelcome.setVisible(true);
		frameWelcome.setModal(true);
		frameWelcome.setTitle("Developer's Dungeon - May the force be with Unix");
		frameWelcome.setResizable(false);
		frameWelcome.setBounds(100, 100, 402, 156);
		frameWelcome.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frameWelcome.getContentPane().setLayout(null);
		
		JButton btnAreaClientes = new JButton("Area Clientes");
		btnAreaClientes.setMnemonic('C');
		btnAreaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarVentanasCliente();
				frameWelcome.setVisible(false);
				Principal.framePrincipal.setVisible(true);
				
				JOptionPane.showMessageDialog(frameWelcome, "Bienvenido a nuestra tienda Online \n"
						+ "recuerda que puedes descargar el catalogo de forma gratuita");

			}
			/**
			 * Habilita el menu de cliente, es decir, las pestañas de acciones de cliente
			 */
			private void habilitarVentanasCliente() {
				Principal.menuEmpleado.setVisible(false);
				
			}
		});
		btnAreaClientes.setBounds(35, 54, 150, 47);
		frameWelcome.getContentPane().add(btnAreaClientes);
		
		JButton btnAreaEmpleados = new JButton("Area Empleados");
		btnAreaEmpleados.setMnemonic('E');
		btnAreaEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarVentanasEmpleado();
				frameWelcome.setVisible(false);
				Principal.framePrincipal.setVisible(true);
			}
			/**
			 * Habilita el menu de empleado, es decir, pestañas de gestion
			 */
			private void habilitarVentanasEmpleado() {
				Principal.menuUsuario.setVisible(false);
				
			}
		});
		btnAreaEmpleados.setBounds(212, 54, 150, 47);
		frameWelcome.getContentPane().add(btnAreaEmpleados);
		
		JLabel lblBienvenidoALa = new JLabel("Bienvenido a la Mazmorra del Desarrollador");
		lblBienvenidoALa.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBienvenidoALa.setBounds(35, 0, 383, 15);
		frameWelcome.getContentPane().add(lblBienvenidoALa);
		
		JLabel lblIndicaSiEres = new JLabel("Indica si eres cliente o empleado");
		lblIndicaSiEres.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblIndicaSiEres.setBounds(69, 26, 314, 15);
		frameWelcome.getContentPane().add(lblIndicaSiEres);
	}
}
