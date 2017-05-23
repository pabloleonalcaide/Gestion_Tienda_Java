package gui;

import java.awt.event.ActionListener;
import java.util.ListIterator;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import excepciones.ImposibleEliminarException;
import jerarquia.Articulo;
import jerarquia.Libro;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelEliminar extends PanelPadre {
	public PanelEliminar(ListIterator<Articulo> it) {
		super(it);
		textNombre.setEditable(false);
		textPrecio.setEditable(false);
		textDetalles.setEditable(false);
		textStock.setEditable(false);
		textStock.setEnabled(false);
		comboBoxEstado.setEnabled(false);
		cleanRightPanel();
		rdbtnCartas.setEnabled(false);
		rdbtnTablero.setEnabled(false);
		rdbtnRol.setEnabled(false);
		lblEstado.setBounds(12, 205, 80, 27);
		lblFechaEntrada.setBounds(12, 286, 80, 34);
		lblCantidadStock.setBounds(12, 251, 80, 27);
		lblDescripcion.setBounds(12, 121, 80, 27);
		lblNombre.setBounds(12, 30, 80, 27);
		textNombre.setEnabled(false);
		textDetalles.setEnabled(false);
		textPrecio.setEnabled(false);
		spinnerEntrada.setEnabled(false);
		comboBoxTipoArticulo.setVisible(false);
		btnSiguiente.setEnabled(false);
		textId.setEditable(true);
		btnSacar_borrar.setText("Eliminar");
		btnAnterior.setEnabled(false);
		btnALaCesta_anadir.setEnabled(false);
		textId.setEnabled(true);

		btnSacar_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textId.getText());
				showMainPanel(new Libro(id));
				switch (JOptionPane.showConfirmDialog(getContentPane(), "desea eliminar?", null,
						JOptionPane.YES_NO_CANCEL_OPTION)) {
				case JOptionPane.YES_OPTION:
					removeArticle(id);
					Principal.stock.setModificado(true);
					break;
				case JOptionPane.NO_OPTION:
				case JOptionPane.CANCEL_OPTION:
					break;
				}
			}
			//Constructor con id de cada clase hija e insertar el instanceof para filtrar el eliminado
			protected void removeArticle(int id) {
				try {
					Principal.stock.removeFromStock((Articulo) Principal.stock.getArticulo(id));
				} catch (ImposibleEliminarException e) {
					JOptionPane.showMessageDialog(getContentPane(), e.getMessage());
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "algo falla");
				}
			}
		});
	}
}
