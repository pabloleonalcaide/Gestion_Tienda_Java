package gui;

import java.awt.event.ActionListener;
import java.util.ListIterator;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import excepciones.ImposibleEliminarException;

import jerarquia.Libro;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//RECUERDA, MUESTRA Y PIDE CONFIRMACION ANTES DE ELIMINAR
public class PanelEliminar extends PanelPadre {
	public PanelEliminar(ListIterator it) {
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
				try {
					Principal.stock.removeFromStock(new Libro(id));
					Principal.stock.setModificado(true);
				} catch (ImposibleEliminarException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}
}
