package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import jerarquia.Articulo;
/**
 * Muestra el catálogo de artículos y permite eliminar en el propio recorrido
 * @author pablo
 *
 */
public class PanelBuscarEliminar extends PanelMostrar {
	
	private static final long serialVersionUID = 1L;

	public PanelBuscarEliminar( ListIterator<Articulo> iterador) {
		super(iterador);
		btnSacar_borrar.setVisible(true);
		btnSacar_borrar.setText("Eliminar");
		btnSacar_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					it.remove();
					Principal.stock.setModificado(true);
				}catch(Exception e){
					JOptionPane.showMessageDialog(rootPane, e.getMessage());
				}
				
				if (!it.hasPrevious() && !it.hasNext())
					setVisible(false);				
				else if (!it.hasPrevious()){
					showNext();
					btnAnterior.setEnabled(false);
				}
				else{
					showPrevious();
					btnSiguiente.setEnabled(false);
				}				
			}

		});
	}

}
