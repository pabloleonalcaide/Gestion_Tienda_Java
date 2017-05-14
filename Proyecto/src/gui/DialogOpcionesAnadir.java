package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Permite habilitar /deshabilitar los distintos panels asociados a los tipos de
 * artículo
 * 
 * @author pablo
 *
 */
public class DialogOpcionesAnadir extends JDialog {
	PanelAnadir anadir;
	final JPanel panelAnadir = new JPanel();
	protected JButton btnContinuar;

	final JComboBox comboBoxTipoArticulo = new JComboBox();

	@SuppressWarnings("unchecked")
	public DialogOpcionesAnadir() {
		setTitle("introduce un nuevo articulo");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 247, 166);
		getContentPane().setLayout(new BorderLayout());
		panelAnadir.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelAnadir, BorderLayout.CENTER);
		panelAnadir.setLayout(null);
		{
			JLabel lblTipoArticulo = new JLabel("Selecciona el Tipo de Articulo");
			lblTipoArticulo.setBounds(12, 12, 223, 15);
			panelAnadir.add(lblTipoArticulo);
		}

		comboBoxTipoArticulo.setModel(new DefaultComboBoxModel(
				new String[] { "Libro", "Figura", "Tablero (Juego)", "Cartas (Juego)", "Rol (Juego)" }));
		comboBoxTipoArticulo.setBounds(64, 61, 119, 24);
		panelAnadir.add(comboBoxTipoArticulo);

		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				anadirPanel();
				if (comboBoxTipoArticulo.getSelectedItem() == "Libro") {
					anadir.panelLibro.setVisible(true);
					anadir.panelFigura.setVisible(false);
					anadir.panelJuego.setVisible(false);
				} else if (comboBoxTipoArticulo.getSelectedItem() == "Figura") {
					anadir.panelLibro.setVisible(false);
					anadir.panelFigura.setVisible(true);
					anadir.panelJuego.setVisible(false);
				} else
					anadir.panelLibro.setVisible(false);
				anadir.panelFigura.setVisible(false);
				anadir.panelJuego.setVisible(true);

				setVisible(false);

			}

			private void anadirPanel() {
				anadir = new PanelAnadir();
				anadir.setVisible(true);
			}
		});
		btnContinuar.setBounds(65, 97, 117, 25);
		panelAnadir.add(btnContinuar);
	}
}
