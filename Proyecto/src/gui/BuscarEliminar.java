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
	
	public BuscarEliminar( ListIterator<Articulo> iterador) {
		super(iterador);
		this.it =iterador;
		btnSacar_borrar.setVisible(true);
		btnSacar_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				it.remove();
				if(it.hasNext()) avanzar();
				else if(it.hasPrevious()) retroceder();
				else return;
			}

		});
	}
	@Override
	public void avanzar(){
		super.avanzar();
		cleanRightPanel();
	}
	@Override
	public void retroceder(){
		super.avanzar();
		cleanRightPanel();
	}

}
