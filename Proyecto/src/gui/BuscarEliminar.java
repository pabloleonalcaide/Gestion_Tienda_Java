package gui;

public class BuscarEliminar extends PanelPadre {

	public BuscarEliminar() {
		spinnerEntrada.setEnabled(false);
		textNombre.setEditable(false);
		textPrecio.setEditable(false);
		textDetalles.setEditable(false);
		textStock.setEditable(false);
		//cleanRightPanel();
		btnALaCesta_anadir.setVisible(false);
		btnSacar_borrar.setText("Eliminar");
		chckbxEnLaCesta.setVisible(false);
		comboBoxEstado.setEditable(false);
		comboBoxTipoArticulo.setVisible(false);
		textStock.setEnabled(false);
		textId.setEnabled(false);
		textPrecio.setEnabled(false);
		textDetalles.setEnabled(false);
	}

}
