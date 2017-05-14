package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Permite habilitar /deshabilitar los distintos panels asociados a los tipos de
 * artículo
 * 
 * @author pablo CORREGIR --> Hacer que no muestre lo que hay en
 *         DialogOpcionesAnadir
 */
public class DialogOpcionesMostrar extends DialogOpcionesAnadir {

	public DialogOpcionesMostrar() {
		setTitle("Mira los articulos");
		btnContinuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelMostrar mostrar = new PanelMostrar();
				mostrar.setVisible(true);

				if (comboBoxTipoArticulo.getSelectedItem() == "Libro") {
					mostrar.panelLibro.setVisible(true);
					mostrar.panelFigura.setVisible(false);
					mostrar.panelJuego.setVisible(false);
				} else if (comboBoxTipoArticulo.getSelectedItem() == "Figura") {
					mostrar.panelLibro.setVisible(false);
					mostrar.panelFigura.setVisible(true);
					mostrar.panelJuego.setVisible(false);
				} else
					mostrar.panelLibro.setVisible(false);
				mostrar.panelFigura.setVisible(false);
				mostrar.panelJuego.setVisible(true);

			}
		});
	}
}
