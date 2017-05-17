package gui;

import java.util.ListIterator;

/**
 * @author pablo
 *
 */
public class PanelMostrar extends PanelPadre {

	public PanelMostrar(ListIterator it) {
		super(it);
		btnALaCesta_anadir.setVisible(false);
		btnSacar_borrar.setVisible(false);
		spinnerEntrada.setEnabled(false);
		textNombre.setEditable(false);
		textPrecio.setEditable(false);
		textDetalles.setEditable(false);
		textStock.setEditable(false);
		btnALaCesta_anadir.setVisible(false);
		btnSacar_borrar.setText("Eliminar");
		chckbxEnLaCesta.setVisible(false);
		comboBoxEstado.setEditable(false);
		comboBoxTipoArticulo.setVisible(false);
		textStock.setEnabled(false);
		textId.setEnabled(false);
		textPrecio.setEnabled(false);
		textDetalles.setEnabled(false);
		textCartas.setEnabled(false);	
		comboBoxDificultad.setEnabled(false);
		chkbxColeccion.setEnabled(false);
		comboBox_Genero.setEnabled(true);
		comboBoxMaterialRol.setEnabled(false);
		textEdicion.setEnabled(false);
		spinnerPeso.setEnabled(false);
		textTematica.setEnabled(false);
		numElementos.setEnabled(false);
		chkbxColeccion.setEnabled(false);
		chckbxDesmontable.setEnabled(false);
		textNombre.setEnabled(false);
		textDetalles.setEnabled(false);
		comboBoxEstado.setEnabled(false);
		spinnerPublicacion.setEnabled(false);
		textPaginas.setEnabled(false); 
		textAutor.setEnabled(false);
		comboBox_Idioma.setEnabled(false);
		comboBox_Genero.setEnabled(false);
		btnAnterior.setEnabled(false);
		avanzar();
	}

	
}
