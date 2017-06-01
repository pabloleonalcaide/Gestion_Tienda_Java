package gui;

import java.awt.event.ActionListener;
import java.util.ListIterator;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import excepciones.ImposibleEliminarException;
import jerarquia.*;
/**
 * Elimina los articulos por su codigo identificativo
 * @author pablo
 *
 */
public class PanelEliminar extends PanelPadre {
	
	private static final long serialVersionUID = 1L;

	public PanelEliminar(ListIterator<Articulo> it) {
		super();
		setTitle("Eliminar");
		textNombre.setEditable(false);
		textPrecio.setEditable(false);
		textDescripcion.setEditable(false);
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
		textDescripcion.setEnabled(false);
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
				
				show(id);
				
				switch (JOptionPane.showConfirmDialog(getContentPane(), "desea eliminar?", null,
						JOptionPane.YES_NO_CANCEL_OPTION)) {
				case JOptionPane.YES_OPTION:
					removeArticle(id);
					emptyPanels();
					Principal.stock.setModificado(true);
					break;
				case JOptionPane.NO_OPTION:
				case JOptionPane.CANCEL_OPTION:
					break;
				}
				if(Principal.stock.isEmpty())
					setVisible(false);
			}

			/**
			 * Filtra el tipo de articulo y elimina
			 * @param id
			 */
			protected void removeArticle(int id) {
				try {
					Articulo articulo = Principal.stock.devuelvePorCódigo(id);
					if (articulo instanceof Libro)
						Principal.stock.removeFromStock((Articulo) Principal.stock.getLibro(id));
					else if (articulo instanceof Figura)
						Principal.stock.removeFromStock((Articulo) Principal.stock.getFigura(id));
					else if (articulo instanceof Rol)
						Principal.stock.removeFromStock((Articulo) Principal.stock.getRol(id));
					else if (articulo instanceof Tablero)
						Principal.stock.removeFromStock((Articulo) Principal.stock.getTablero(id));
					else if (articulo instanceof Cartas)
						Principal.stock.removeFromStock((Articulo) Principal.stock.getCartas(id));
				} catch (ImposibleEliminarException e) {
					JOptionPane.showMessageDialog(getContentPane(), e.getMessage());
				}
			}
		});
	}
	/**
	 * Muestra el articulo antes de eliminarlo
	 * @param id
	 */
	protected void show(int id) {
		
		if (Principal.stock.devuelvePorCódigo(id) instanceof Libro)
			showArticle(Principal.stock.getLibro(id));
		else if (Principal.stock.devuelvePorCódigo(id) instanceof Figura)
			showArticle(Principal.stock.getFigura(id));
		else if (Principal.stock.devuelvePorCódigo(id) instanceof Rol)
			showArticle(Principal.stock.getRol(id));
		else if (Principal.stock.devuelvePorCódigo(id) instanceof Tablero)
			showArticle(Principal.stock.getTablero(id));
		else if (Principal.stock.devuelvePorCódigo(id) instanceof Cartas)
			showArticle(Principal.stock.getCartas(id));
		
	}
}
