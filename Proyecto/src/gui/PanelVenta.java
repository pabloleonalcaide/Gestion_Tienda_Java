package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import jerarquia.Articulo;
/**
 * Permite al usuario marcar aquellos elementos a introducir en la cesta de su compra online
 * @author pablo
 *
 */
public class PanelVenta extends PanelMostrar {

	private static final long serialVersionUID = 1L;

	public PanelVenta(ListIterator<Articulo> iterator) {
		super(iterator);
		checkEnLaCesta.setVisible(true);
		checkEnLaCesta.setEnabled(true);
		checkEnLaCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkEnLaCesta.isSelected()){
					getArticuloMostrado().setSeleccionado(true);
				}else
					getArticuloMostrado().setSeleccionado(false);
			}

		});
	}

}
