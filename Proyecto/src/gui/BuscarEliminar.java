package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import jerarquia.Articulo;
/**
 * Muestra el catálogo de artículos y permite eliminar en el propio recorrido
 * @author pablo
 *
 */
public class BuscarEliminar extends PanelMostrar {

	//IMPLEMENTAR EN CONDICIONES
	
	public BuscarEliminar(final ListIterator<Articulo> it) {
		super(it);
		btnSacar_borrar.setVisible(true);
		btnSacar_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Comprobación de botones (si elimina al último elemento, se sale)
				it.remove();
				
			}

		});
	}

}
